package com.makes.apibusinesscontroll.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductPriceDto {
    private Long id;
    private Long productId;
    private Long customerGroupId;
    private BigDecimal price;
    private BigDecimal discount;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
    private Boolean active;
}
