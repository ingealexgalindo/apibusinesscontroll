package com.makes.apibusinesscontroll.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String barcode;
    private String sku;
    private String imageUrl;
    private String warrantyPeriod;
    private Boolean active;
    private Long categoryId;
    private Long brandId;
    private Long supplierId;
    private Long unitOfMeasureId;
    private String categoryName;
    private String brandName;
    private String supplierName;
    private String unitOfMeasureName;
    private String createdBy;
    private String modifiedBy;
    private LocalDateTime creationTime;
    private LocalDateTime modificationTime;
}
