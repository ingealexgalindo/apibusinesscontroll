package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.dto.CategoryDto;
import com.makes.apibusinesscontroll.mapper.CategoryMapper;
import com.makes.apibusinesscontroll.models.Category;
import com.makes.apibusinesscontroll.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;


    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        // Busca la categoría existente en la base de datos.
        return categoryRepository.findById(id)
                .map(existingCategory -> {
                    // Usa el mapper para actualizar solo los campos presentes en el DTO.
                    categoryMapper.updateEntityFromDto(categoryDto, existingCategory);

                    // Actualiza los campos de auditoría.
                    existingCategory.setModificationTime(LocalDateTime.now());

                    // Guarda la categoría actualizada en la base de datos.
                    Category updatedCategory = categoryRepository.save(existingCategory);

                    // Convierte la entidad actualizada a DTO y la retorna.
                    return categoryMapper.toDto(updatedCategory);
                })
                .orElse(null); // Retorna null si la categoría no se encuentra.
    }


    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);

        // Establece los campos de auditoría.
        category.setCreationTime(LocalDateTime.now());

        // Guarda la nueva categoría en la base de datos.
        Category savedCategory = categoryRepository.save(category);

        // Convierte la entidad guardada a DTO y la retorna.
        return categoryMapper.toDto(savedCategory);
    }

    public CategoryDto getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto)
                .orElse(null);
    }


    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }
}
