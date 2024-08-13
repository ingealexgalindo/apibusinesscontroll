package com.makes.apibusinesscontroll.mapper;

import com.makes.apibusinesscontroll.dto.ProductCostDto;
import com.makes.apibusinesscontroll.models.ProductCost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductCostMapper {
    ProductCostMapper INSTANCE = Mappers.getMapper(ProductCostMapper.class);

    ProductCostDto toDto(ProductCost productCost);

    ProductCost toEntity(ProductCostDto productCostDto);

    @Mapping(target = "creationTime", ignore = true) // Ignora el campo de creación
    @Mapping(target = "createdBy", ignore = true) // Ignora el campo de creador

    void updateEntityFromDto(ProductCostDto productCostDto, @MappingTarget ProductCost productCost);


}
