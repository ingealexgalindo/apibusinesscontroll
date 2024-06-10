package com.makes.apibusinesscontroll.repository;

import com.makes.apibusinesscontroll.models.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotRepository extends JpaRepository<Lot,Long> {
}
