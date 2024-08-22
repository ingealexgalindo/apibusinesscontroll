package com.makes.apibusinesscontroll.controllers;

import com.makes.apibusinesscontroll.dto.ProductPriceDto;
import com.makes.apibusinesscontroll.services.ProductPriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productPrice")
public class ProductPriceController {

    private final ProductPriceService service;

    public ProductPriceController(ProductPriceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductPriceDto>> getAllObjects(){
        List<ProductPriceDto> obj = service.getAllProductPrice();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPriceDto> getObjectById(@PathVariable Long id) {
        ProductPriceDto obj = service.getProductPriceById(id);
        return obj != null ? new ResponseEntity<>(obj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ProductPriceDto> createObject(@RequestBody ProductPriceDto dto) {
        ProductPriceDto createdObj = service.createProductPrice(dto);
        return new ResponseEntity<>(createdObj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductPriceDto> updateObject(@PathVariable Long id, @RequestBody ProductPriceDto dto) {
        ProductPriceDto updatedObj = service.updateProductPrice(id, dto);
        return updatedObj != null ? new ResponseEntity<>(updatedObj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
