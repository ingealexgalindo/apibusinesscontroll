package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.dto.CustomerGroupDto;
import com.makes.apibusinesscontroll.mapper.CustomerGroupMapper;
import com.makes.apibusinesscontroll.models.CustomerGroup;
import com.makes.apibusinesscontroll.repository.CustomerGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerGroupService {

    @Autowired
    private CustomerGroupMapper mapper;

    @Autowired
    private CustomerGroupRepository repository;

    public CustomerGroupDto createCustomerGroup(CustomerGroupDto dto){
        CustomerGroup group = mapper.toEntity(dto);
        group.setCreationTime(LocalDateTime.now());
        CustomerGroup saveGroup = repository.save(group);

        return mapper.toDto(saveGroup);
    }

    public CustomerGroupDto getCustomerGroupById(Long id){
        return  repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    public List<CustomerGroupDto> getAllCustomerGroup(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CustomerGroupDto updateCustomerGroup(Long id,CustomerGroupDto dto){
        return  repository.findById(id)
                .map(existCG ->{
                    mapper.updateEntityFromDto(dto,existCG);
                    existCG.setModificationTime(LocalDateTime.now());
                    CustomerGroup updateGroup = repository.save(existCG);
                    return mapper.toDto(updateGroup);
                })
                .orElse(null);
    }


}
