package com.makes.apibusinesscontroll.controllers;

import com.makes.apibusinesscontroll.dto.CategoryDto;
import com.makes.apibusinesscontroll.dto.ProductDto;
import com.makes.apibusinesscontroll.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getProductById(@PathVariable Long id) {
        CategoryDto categories = categoryService.getCategoryById(id);
        return categories != null ? new ResponseEntity<>(categories, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createProduct(@RequestBody CategoryDto productDto) {
        CategoryDto createdCategory = categoryService.createCategory(productDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateProduct(@PathVariable Long id, @RequestBody CategoryDto productDto) {
        CategoryDto updatedCategory = categoryService.updateCategory(id, productDto);
        return updatedCategory != null ? new ResponseEntity<>(updatedCategory, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
