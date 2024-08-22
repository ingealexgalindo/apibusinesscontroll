package com.makes.apibusinesscontroll.services;


import com.makes.apibusinesscontroll.dto.UnitDto;
import com.makes.apibusinesscontroll.mapper.UnitMapper;
import com.makes.apibusinesscontroll.models.Unit;
import com.makes.apibusinesscontroll.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UnitService {
    @Autowired
    private UnitRepository repository;
    @Autowired
    private UnitMapper mapper;
    
    public UnitDto createUnit(UnitDto dto) {
        Unit unit = mapper.toEntity(dto);

        unit.setCreationTime(LocalDateTime.now());
        Unit savedBrand = repository.save(unit);
        return mapper.toDto(savedBrand);
    }

    public UnitDto getUnitById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    public List<UnitDto> getAllUnit() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public UnitDto updateUnit(Long id, UnitDto dto) {
        return repository.findById(id)
                .map(existingUnit -> {
                    mapper.updateEntityFromDto(dto, existingUnit);
                    existingUnit.setModificationTime(LocalDateTime.now());
                    Unit updatedUnit = repository.save(existingUnit);
                    return mapper.toDto(updatedUnit);
                })
                .orElse(null);
    }
}
