package com.makes.apibusinesscontroll.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UnitDto {
    private Long id;
    private String unitName;
    private String unitSymbol;
    private String createdBy;
    private LocalDateTime creationTime;
    private String modifiedBy;
    private LocalDateTime modificationTime;
}
