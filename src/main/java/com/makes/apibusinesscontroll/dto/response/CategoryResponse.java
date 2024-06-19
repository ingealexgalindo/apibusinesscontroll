package com.makes.apibusinesscontroll.dto.response;

import lombok.Data;

@Data
public class CategoryResponse {

    private Long id;
    private String categoryName;
    private String createdBy;
    private String modifiedBy;


}
