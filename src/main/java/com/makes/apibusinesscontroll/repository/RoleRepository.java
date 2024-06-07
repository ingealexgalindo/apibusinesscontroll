package com.makes.apibusinesscontroll.repository;

import com.makes.apibusinesscontroll.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    boolean existsByRoleName(String roleName);
}
