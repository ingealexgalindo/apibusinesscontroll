package com.makes.apibusinesscontroll.controllers;

import com.makes.apibusinesscontroll.dto.SupplierDto;
import com.makes.apibusinesscontroll.services.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SupplierDto>> getAllObjects(){
        List<SupplierDto> obj = service.getAllSupplier();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto> getObjectById(@PathVariable Long id) {
        SupplierDto obj = service.getSupplierById(id);
        return obj != null ? new ResponseEntity<>(obj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<SupplierDto> createObject(@RequestBody SupplierDto dto) {
        SupplierDto createdObj = service.createSupplier(dto);
        return new ResponseEntity<>(createdObj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDto> updateObject(@PathVariable Long id, @RequestBody SupplierDto dto) {
        SupplierDto updatedObj = service.updateSupplier(id, dto);
        return updatedObj != null ? new ResponseEntity<>(updatedObj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
