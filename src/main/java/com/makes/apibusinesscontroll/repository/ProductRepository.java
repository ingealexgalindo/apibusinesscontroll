package com.makes.apibusinesscontroll.repository;

import com.makes.apibusinesscontroll.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    boolean existsByName(String roleName);
}
