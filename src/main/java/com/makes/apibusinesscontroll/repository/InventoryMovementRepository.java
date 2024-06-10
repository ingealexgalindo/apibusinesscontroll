package com.makes.apibusinesscontroll.repository;

import com.makes.apibusinesscontroll.models.InventoryMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryMovementRepository extends JpaRepository<InventoryMovement,Long> {
}
