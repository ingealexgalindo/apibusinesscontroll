package com.makes.apibusinesscontroll.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.math.BigDecimal;
@Data
public class ProductRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private BigDecimal purchasePrice;
    @NotBlank
    private BigDecimal salePrice;
    @NotBlank
    private Integer stock;
    @NotBlank
    private String createdBy;
    @NotBlank
    private String modifiedBy;
}
