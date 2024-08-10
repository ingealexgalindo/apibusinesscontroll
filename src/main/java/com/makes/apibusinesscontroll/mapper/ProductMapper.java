package com.makes.apibusinesscontroll.mapper;

import com.makes.apibusinesscontroll.dto.ProductDto;
import com.makes.apibusinesscontroll.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.categoryName", target = "categoryName")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "brand.brandName", target = "brandName")
    @Mapping(source = "supplier.id", target = "supplierId")
    @Mapping(source = "supplier.supplierName", target = "supplierName")
    @Mapping(source = "unitOfMeasure.id", target = "unitOfMeasureId")
    @Mapping(source = "unitOfMeasure.unitName", target = "unitOfMeasureName")
    ProductDto toDto(Product product);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "brandId", target = "brand.id")
    @Mapping(source = "supplierId", target = "supplier.id")
    @Mapping(source = "unitOfMeasureId", target = "unitOfMeasure.id")
    Product toEntity(ProductDto productDto);

    @Mapping(target = "creationTime", ignore = true) // Ignora el campo de creación
    @Mapping(target = "createdBy", ignore = true) // Ignora el campo de creador

    void updateEntityFromDto(ProductDto productDto, @MappingTarget Product product);
}
