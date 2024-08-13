package com.makes.apibusinesscontroll.mapper;

import com.makes.apibusinesscontroll.dto.SupplierDto;
import com.makes.apibusinesscontroll.models.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    SupplierDto toDto(Supplier supplier);

    Supplier toEntity(SupplierDto supplierDto);

    @Mapping(target = "creationTime", ignore = true) // Ignora el campo de creación
    @Mapping(target = "createdBy", ignore = true) // Ignora el campo de creador
    void updateEntityFromDto(SupplierDto supplierDto, @MappingTarget Supplier supplier);


}
