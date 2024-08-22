package com.makes.apibusinesscontroll.controllers;

import com.makes.apibusinesscontroll.dto.BrandDto;
import com.makes.apibusinesscontroll.services.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    private final BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> getAllObjects(){
        List<BrandDto> obj = service.getAllCategories();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> getObjectById(@PathVariable Long id) {
        BrandDto obj = service.getBrandById(id);
        return obj != null ? new ResponseEntity<>(obj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<BrandDto> createObject(@RequestBody BrandDto dto) {
        BrandDto createdObj = service.createBrand(dto);
        return new ResponseEntity<>(createdObj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandDto> updateObject(@PathVariable Long id, @RequestBody BrandDto dto) {
        BrandDto updatedObj = service.updateCategory(id, dto);
        return updatedObj != null ? new ResponseEntity<>(updatedObj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
}
