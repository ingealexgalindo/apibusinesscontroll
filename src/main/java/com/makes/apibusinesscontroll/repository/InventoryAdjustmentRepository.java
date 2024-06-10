package com.makes.apibusinesscontroll.repository;

import com.makes.apibusinesscontroll.models.InventoryAdjustment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryAdjustmentRepository extends JpaRepository<InventoryAdjustment, Long> {
}
