package com.makes.apibusinesscontroll.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class ProductCostDto {
    private Long id;
    private Long productId;
    private BigDecimal cost;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
    private Boolean active;
    private String createdBy;
    private LocalDateTime creationTime;
    private String modifiedBy;
    private LocalDateTime modificationTime;
}
