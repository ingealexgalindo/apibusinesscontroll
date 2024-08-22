package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.dto.BrandDto;
import com.makes.apibusinesscontroll.dto.CategoryDto;
import com.makes.apibusinesscontroll.mapper.BrandMapper;
import com.makes.apibusinesscontroll.models.Brand;
import com.makes.apibusinesscontroll.models.Category;
import com.makes.apibusinesscontroll.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandMapper brandMapper;
    
    public BrandDto createBrand(BrandDto categoryDto) {
        Brand brand = brandMapper.toEntity(categoryDto);

        brand.setCreationTime(LocalDateTime.now());
        Brand savedBrand = brandRepository.save(brand);
        return brandMapper.toDto(savedBrand);
    }

    public BrandDto getBrandById(Long id) {
        return brandRepository.findById(id)
                .map(brandMapper::toDto)
                .orElse(null);
    }

    public List<BrandDto> getAllCategories() {
        return brandRepository.findAll()
                .stream()
                .map(brandMapper::toDto)
                .collect(Collectors.toList());
    }


    public BrandDto updateCategory(Long id, BrandDto brandDto) {
        return brandRepository.findById(id)
                .map(existingBrand -> {
                    brandMapper.updateEntityFromDto(brandDto, existingBrand);
                    existingBrand.setModificationTime(LocalDateTime.now());
                    Brand updatedBrand = brandRepository.save(existingBrand);
                    return brandMapper.toDto(updatedBrand);
                })
                .orElse(null);
    }

}
