package com.makes.apibusinesscontroll.controllers;

import com.makes.apibusinesscontroll.dto.ProductCostDto;
import com.makes.apibusinesscontroll.services.ProductCostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productCost")
public class ProductCostController {

    private  final ProductCostService service;

    public ProductCostController(ProductCostService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductCostDto>> getAllObjects(){
        List<ProductCostDto> obj = service.getAllProductCost();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCostDto> getObjectById(@PathVariable Long id) {
        ProductCostDto obj = service.getProductCostById(id);
        return obj != null ? new ResponseEntity<>(obj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ProductCostDto> createObject(@RequestBody ProductCostDto dto) {
        ProductCostDto createdObj = service.createProductCost(dto);
        return new ResponseEntity<>(createdObj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCostDto> updateObject(@PathVariable Long id, @RequestBody ProductCostDto dto) {
        ProductCostDto updatedObj = service.updateProductCost(id, dto);
        return updatedObj != null ? new ResponseEntity<>(updatedObj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
