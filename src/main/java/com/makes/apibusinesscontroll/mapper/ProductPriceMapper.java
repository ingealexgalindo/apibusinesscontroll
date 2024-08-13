package com.makes.apibusinesscontroll.mapper;

import com.makes.apibusinesscontroll.dto.ProductPriceDto;
import com.makes.apibusinesscontroll.models.ProductPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductPriceMapper {
    ProductPriceMapper INSTANCE = Mappers.getMapper(ProductPriceMapper.class);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "customerGroup.id", target = "customerGroupId")
    ProductPriceDto toDto(ProductPrice productPrice);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "customerGroupId", target = "customerGroup.id")
    ProductPrice toEntity(ProductPriceDto productPriceDto);

    @Mapping(target = "creationTime", ignore = true) // Ignora el campo de creación
    @Mapping(target = "createdBy", ignore = true) // Ignora el campo de creador
    void updateEntityFromDto(ProductPriceDto productPriceDto, @MappingTarget ProductPrice productPrice);
}

