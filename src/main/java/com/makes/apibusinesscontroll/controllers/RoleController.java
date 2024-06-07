package com.makes.apibusinesscontroll.controllers;

import com.makes.apibusinesscontroll.dto.RoleDto;
import com.makes.apibusinesscontroll.dto.RoleUpdateDto;
import com.makes.apibusinesscontroll.models.Role;
import com.makes.apibusinesscontroll.services.RoleService;
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
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService service;

    @PostMapping
    public ResponseEntity<Object> saveRole(@RequestBody @Valid RoleDto dto) {

        if (service.existsByRoleName(dto.getRoleName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This role exist");
        }
        Role roleModel = new Role();
        BeanUtils.copyProperties(dto, roleModel);
        roleModel.setCreationTime(LocalDateTime.now(ZoneId.of("America/Guatemala")));
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(roleModel));
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllL());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getByRoleId(@PathVariable(value = "id") Integer id) {
        Optional<Role> roleOptional = service.findById(id);
        if (!roleOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role ID not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(roleOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable(value = "id") Integer id) {
        Optional<Role> roleOptional = service.findById(id);
        if (!roleOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role ID not found.");
        }
        service.delete(roleOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Role deleted successfully");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRole(@PathVariable(value = "id") Integer id, @RequestBody @Valid RoleUpdateDto dto) {

        Optional<Role> roleModelOptional = service.findById(id);

        if (!roleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        Role roleModel = roleModelOptional.get();
        BeanUtils.copyProperties(dto, roleModel);

        roleModel.setModificationTime(LocalDateTime.now(ZoneId.of("America/Guatemala")));
        Role updatedRole = service.save(roleModel);
        return ResponseEntity.status(HttpStatus.OK).body(updatedRole);
    }
}
