package com.makes.apibusinesscontroll.repository;

import com.makes.apibusinesscontroll.models.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {
}
