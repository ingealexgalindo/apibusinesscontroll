package com.makes.apibusinesscontroll.repository;

import com.makes.apibusinesscontroll.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);
}
