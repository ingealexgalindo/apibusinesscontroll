package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.dto.ProductPriceDto;
import com.makes.apibusinesscontroll.mapper.ProductPriceMapper;
import com.makes.apibusinesscontroll.models.ProductPrice;
import com.makes.apibusinesscontroll.repository.ProductProceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductPriceService {

    @Autowired
    private ProductProceRepository repository;
    @Autowired
    private ProductPriceMapper mapper;

    public ProductPriceDto createProductPrice(ProductPriceDto categoryDto) {
        ProductPrice productPrice = mapper.toEntity(categoryDto);

        productPrice.setCreationTime(LocalDateTime.now());
        ProductPrice savedBrand = repository.save(productPrice);
        return mapper.toDto(savedBrand);
    }

    public ProductPriceDto getProductPriceById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    public List<ProductPriceDto> getAllProductPrice() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductPriceDto updateProductPrice(Long id, ProductPriceDto brandDto) {
        return repository.findById(id)
                .map(existingBrand -> {
                    mapper.updateEntityFromDto(brandDto, existingBrand);
                    existingBrand.setModificationTime(LocalDateTime.now());
                    ProductPrice updatedBrand = repository.save(existingBrand);
                    return mapper.toDto(updatedBrand);
                })
                .orElse(null);
    }
}
