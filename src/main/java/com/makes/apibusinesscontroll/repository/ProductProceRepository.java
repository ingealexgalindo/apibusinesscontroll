package com.makes.apibusinesscontroll.repository;

import com.makes.apibusinesscontroll.models.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductProceRepository extends JpaRepository<ProductPrice,Long> {
}
