package com.makes.apibusinesscontroll.controllers;

import com.makes.apibusinesscontroll.dto.CustomerGroupDto;
import com.makes.apibusinesscontroll.services.CustomerGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/customerGroup")
public class CustomerGroupController {

    private final CustomerGroupService service;

    public CustomerGroupController(CustomerGroupService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerGroupDto>> getAllObjects(){
        List<CustomerGroupDto> obj = service.getAllCustomerGroup();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerGroupDto> getObjectById(@PathVariable Long id) {
        CustomerGroupDto obj = service.getCustomerGroupById(id);
        return obj != null ? new ResponseEntity<>(obj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CustomerGroupDto> createObject(@RequestBody CustomerGroupDto dto) {
        CustomerGroupDto createdObj = service.createCustomerGroup(dto);
        return new ResponseEntity<>(createdObj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerGroupDto> updateObject(@PathVariable Long id, @RequestBody CustomerGroupDto dto) {
        CustomerGroupDto updatedObj = service.updateCustomerGroup(id, dto);
        return updatedObj != null ? new ResponseEntity<>(updatedObj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
