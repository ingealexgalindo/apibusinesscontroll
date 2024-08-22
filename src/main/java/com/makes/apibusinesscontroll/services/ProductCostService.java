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

    public ProductCostDto createProductCost(ProductCostDto dto) {
        ProductCost productCost = mapper.toEntity(dto);

        productCost.setCreationTime(LocalDateTime.now());
        ProductCost savedCost = repository.save(productCost);
        return mapper.toDto(savedCost);
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
                .map(existingProdCost -> {
                    mapper.updateEntityFromDto(brandDto, existingProdCost);
                    existingProdCost.setModificationTime(LocalDateTime.now());
                    ProductCost updatedProductCost = repository.save(existingProdCost);
                    return mapper.toDto(updatedProductCost);
                })
                .orElse(null);
    }
}
