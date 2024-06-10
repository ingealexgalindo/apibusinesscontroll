package com.makes.apibusinesscontroll.controllers;

import com.makes.apibusinesscontroll.dto.UserRoleDto;
import com.makes.apibusinesscontroll.dto.UserRoleUpdateDto;
import com.makes.apibusinesscontroll.dto.request.ProductRequest;
import com.makes.apibusinesscontroll.dto.response.UserRoleResponse;
import com.makes.apibusinesscontroll.models.Product;
import com.makes.apibusinesscontroll.models.UserRole;
import com.makes.apibusinesscontroll.serviceImpl.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/product")
public class ProductControler {

    @Autowired
    private ProductServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody @Valid ProductRequest dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product,"modifiedBy");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllL());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getByProductId(@PathVariable(value = "id") Long id) {
        Optional<Product> roleOptional = service.findById(id);
        if (!roleOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product ID not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(roleOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") Long id, @RequestBody @Valid ProductRequest dto) {
        Product product = new Product();
        product= service.updateProduct(id,dto);

        if (Objects.isNull(product)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
