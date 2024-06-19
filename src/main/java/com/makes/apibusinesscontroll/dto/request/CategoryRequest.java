package com.makes.apibusinesscontroll.dto.request;

import lombok.Data;

@Data
public class CategoryRequest {
    private String categoryName;
    private String createdBy;
    private String modifiedBy;
}
