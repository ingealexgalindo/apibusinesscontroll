package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.dto.ProductCostDto;
import com.makes.apibusinesscontroll.mapper.ProductCostMapper;
import com.makes.apibusinesscontroll.models.ProductCost;
import com.makes.apibusinesscontroll.repository.ProductCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductCostService {
    
    @Autowired
    private ProductCostRepository repository;
    
    @Autowired
    private ProductCostMapper mapper;

    public ProductCostDto createProductCost(ProductCostDto categoryDto) {
        ProductCost productCost = mapper.toEntity(categoryDto);

        productCost.setCreationTime(LocalDateTime.now());
        ProductCost savedBrand = repository.save(productCost);
        return mapper.toDto(savedBrand);
    }

    public ProductCostDto getProductCostById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    public List<ProductCostDto> getAllProductCost() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductCostDto updateProductCost(Long id, ProductCostDto brandDto) {
        return repository.findById(id)
                .map(existingBrand -> {
                    mapper.updateEntityFromDto(brandDto, existingBrand);
                    existingBrand.setModificationTime(LocalDateTime.now());
                    ProductCost updatedBrand = repository.save(existingBrand);
                    return mapper.toDto(updatedBrand);
                })
                .orElse(null);
    }
}
