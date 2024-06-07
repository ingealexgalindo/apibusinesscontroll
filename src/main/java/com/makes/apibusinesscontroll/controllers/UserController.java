package com.makes.apibusinesscontroll.controllers;

import com.makes.apibusinesscontroll.dto.UserDto;
import com.makes.apibusinesscontroll.dto.UserUpdateDto;
import com.makes.apibusinesscontroll.models.User;
import com.makes.apibusinesscontroll.services.UserService;
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
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto) {

        if (service.existsByEmail(userDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This email exist");
        }
        User userModel = new User();
        BeanUtils.copyProperties(userDto, userModel);
        userModel.setCreationTime(LocalDateTime.now(ZoneId.of("America/Guatemala")));
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userModel));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllL());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getByUserId(@PathVariable(value = "id") Integer id) {
        Optional<User> userOptional = service.findById(id);
        if (!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ID not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Integer id) {
        Optional<User> userOptional = service.findById(id);
        if (!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user ID not found.");
        }
        service.delete(userOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Integer id, @RequestBody @Valid UserUpdateDto dto) {

        Optional<User> userModelOptional = service.findById(id);

        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        User userModel = userModelOptional.get();
        BeanUtils.copyProperties(dto, userModel);

        userModel.setModificationTime(LocalDateTime.now(ZoneId.of("America/Guatemala")));
        User updatedUser = service.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }


}
