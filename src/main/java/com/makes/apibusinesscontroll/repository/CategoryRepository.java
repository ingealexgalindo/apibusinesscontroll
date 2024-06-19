package com.makes.apibusinesscontroll.repository;

import com.makes.apibusinesscontroll.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
