package com.makes.apibusinesscontroll.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerGroupDto {
    private Long id;
    private String name;
    private String description;
    private String createdBy;
    private LocalDateTime creationTime;
    private String modifiedBy;
    private LocalDateTime modificationTime;
}
