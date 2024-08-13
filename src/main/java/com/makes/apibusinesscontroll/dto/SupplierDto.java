package com.makes.apibusinesscontroll.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SupplierDto {
    private Long id;
    private String supplierName;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
    private String address;
    private String createdBy;
    private LocalDateTime creationTime;
    private String modifiedBy;
    private LocalDateTime modificationTime;
}
