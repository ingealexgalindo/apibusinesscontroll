package com.makes.apibusinesscontroll.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BrandDto {
    private Long id;
    private String brandName;
    private String description;
    private String createdBy;
    private LocalDateTime creationTime;
    private String modifiedBy;
    private LocalDateTime modificationTime;
}
