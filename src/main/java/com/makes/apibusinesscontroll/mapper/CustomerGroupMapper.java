package com.makes.apibusinesscontroll.mapper;

import com.makes.apibusinesscontroll.dto.CustomerGroupDto;
import com.makes.apibusinesscontroll.models.CustomerGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface CustomerGroupMapper {
        CustomerGroupMapper INSTANCE = Mappers.getMapper(CustomerGroupMapper.class);

        CustomerGroupDto toDto(CustomerGroup customerGroup);

        CustomerGroup toEntity(CustomerGroupDto customerGroupDto);

    @Mapping(target = "creationTime", ignore = true) // Ignora el campo de creación
    @Mapping(target = "createdBy", ignore = true) // Ignora el campo de creador
        void updateEntityFromDto(CustomerGroupDto customerGroupDto, @MappingTarget CustomerGroup customerGroup);
}
