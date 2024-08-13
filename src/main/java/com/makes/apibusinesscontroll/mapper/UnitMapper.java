package com.makes.apibusinesscontroll.mapper;

import com.makes.apibusinesscontroll.dto.UnitDto;
import com.makes.apibusinesscontroll.models.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UnitMapper {

    UnitMapper INSTANCE = Mappers.getMapper(UnitMapper.class);

    UnitDto toDto(Unit unit);

    Unit toEntity(UnitDto unitDto);

    @Mapping(target = "creationTime", ignore = true) // Ignora el campo de creación
    @Mapping(target = "createdBy", ignore = true) // Ignora el campo de creador
    void updateEntityFromDto(UnitDto unitDto, @MappingTarget Unit unit);
}