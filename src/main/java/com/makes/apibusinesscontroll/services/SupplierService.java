package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.dto.SupplierDto;
import com.makes.apibusinesscontroll.mapper.SupplierMapper;
import com.makes.apibusinesscontroll.models.Supplier;
import com.makes.apibusinesscontroll.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplierService {
    
    @Autowired
    private SupplierRepository repository;
    
    @Autowired
    private SupplierMapper mapper;

    public SupplierDto createSupplier(SupplierDto dto) {
        Supplier supplier = mapper.toEntity(dto);

        supplier.setCreationTime(LocalDateTime.now());
        Supplier savedBrand = repository.save(supplier);
        return mapper.toDto(savedBrand);
    }

    public SupplierDto getSupplierById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    public List<SupplierDto> getAllSupplier() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


    public SupplierDto updateSupplier(Long id, SupplierDto dto) {
        return repository.findById(id)
                .map(existingBrand -> {
                    mapper.updateEntityFromDto(dto, existingBrand);
                    existingBrand.setModificationTime(LocalDateTime.now());
                    Supplier updatedBrand = repository.save(existingBrand);
                    return mapper.toDto(updatedBrand);
                })
                .orElse(null);
    }
}
