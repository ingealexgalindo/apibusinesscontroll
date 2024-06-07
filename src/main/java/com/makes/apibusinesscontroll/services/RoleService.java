package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.models.Role;
import com.makes.apibusinesscontroll.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public List<Role> findAllL() {
        return repository.findAll();
    }

    public Optional<Role> findById(Integer id){
        return  repository.findById(id);
    }

    @Transactional
    public Role save(Role role) {
        return repository.save(role);
    }
    @Transactional
    public void delete(Role role) {
        repository.delete(role);
    }

    public boolean existsByRoleName(String roleName) {
        return repository.existsByRoleName(roleName);
    }
}
