package com.makes.apibusinesscontroll.controllers;

import com.makes.apibusinesscontroll.dto.UnitDto;
import com.makes.apibusinesscontroll.services.UnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitController {

    private final UnitService service;

    public UnitController(UnitService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UnitDto>> getAllObjects(){
        List<UnitDto> obj = service.getAllUnit();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitDto> getObjectById(@PathVariable Long id) {
        UnitDto obj = service.getUnitById(id);
        return obj != null ? new ResponseEntity<>(obj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UnitDto> createObject(@RequestBody UnitDto dto) {
        UnitDto createdObj = service.createUnit(dto);
        return new ResponseEntity<>(createdObj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitDto> updateObject(@PathVariable Long id, @RequestBody UnitDto dto) {
        UnitDto updatedObj = service.updateUnit(id, dto);
        return updatedObj != null ? new ResponseEntity<>(updatedObj, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
