package com.makes.apibusinesscontroll.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_history_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "sale_price", precision = 10, scale = 2)
    private BigDecimal salePrice;

    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Size(max = 255)
    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modification_time")
    private LocalDateTime modificationTime;

}