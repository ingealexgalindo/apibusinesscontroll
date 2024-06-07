package com.makes.apibusinesscontroll.controllers;

import com.makes.apibusinesscontroll.dto.RoleDto;
import com.makes.apibusinesscontroll.dto.RoleUpdateDto;
import com.makes.apibusinesscontroll.dto.UserRoleDto;
import com.makes.apibusinesscontroll.dto.UserRoleUpdateDto;
import com.makes.apibusinesscontroll.dto.response.UserRoleResponse;
import com.makes.apibusinesscontroll.models.Role;
import com.makes.apibusinesscontroll.models.User;
import com.makes.apibusinesscontroll.models.UserRole;
import com.makes.apibusinesscontroll.services.UserRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService service;

    @PostMapping
    public ResponseEntity<Object> saveUserRole(@RequestBody @Valid UserRoleDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserRoleResponse>> getAllUserRoles() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllL());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getByRoleId(@PathVariable(value = "id") Integer id) {
        Optional<UserRoleResponse> roleOptional = service.findByIdResponse(id);
        if (!roleOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role ID not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(roleOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable(value = "id") Integer id) {
        Optional<UserRole> roleOptional = service.findById(id);
        if (!roleOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role ID not found.");
        }
        service.delete(roleOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Role deleted successfully");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRole(@PathVariable(value = "id") Integer id, @RequestBody @Valid UserRoleUpdateDto dto) {

        Optional<UserRole> roleModelOptional = service.findById(id);

        if (!roleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        UserRole roleModel  = roleModelOptional.get();
        BeanUtils.copyProperties(dto, roleModel);

        roleModel.setModificationTime(LocalDateTime.now(ZoneId.of("America/Guatemala")));
        UserRole updatedRole = service.save(roleModel);
        return ResponseEntity.status(HttpStatus.OK).body(updatedRole);
    }


}
