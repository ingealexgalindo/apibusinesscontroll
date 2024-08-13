package com.makes.apibusinesscontroll.mapper;

import com.makes.apibusinesscontroll.dto.CategoryDto;
import com.makes.apibusinesscontroll.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toDto(Category category);

    Category toEntity(CategoryDto categoryDto);
    @Mapping(target = "creationTime", ignore = true) // Ignora el campo de creación
    @Mapping(target = "createdBy", ignore = true) // Ignora el campo de creador
    void updateEntityFromDto(CategoryDto categoryDto, @MappingTarget Category category);
}
