package com.makes.apibusinesscontroll.mapper;

import com.makes.apibusinesscontroll.dto.BrandDto;
import com.makes.apibusinesscontroll.models.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    BrandDto toDto(Brand brand);
    Brand toEntity(BrandDto brandDto);

    @Mapping(target = "creationTime", ignore = true) // Ignora el campo de creación
    @Mapping(target = "createdBy", ignore = true) // Ignora el campo de creador

    void updateEntityFromDto(BrandDto brandDto, @MappingTarget Brand brand);
}
