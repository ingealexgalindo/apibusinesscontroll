package com.makes.apibusinesscontroll.dto.request;

import com.makes.apibusinesscontroll.dto.response.CategoryResponse;
import com.makes.apibusinesscontroll.dto.response.SupplierResponse;
import lombok.Data;


@Data
public class ProductRequest {
    private String name;
    private String description;
    private CategoryResponse category;
    private SupplierResponse supplier;
    private String unitOfMeasure;
    private String barcode;
    private String sku;
    private Integer minStockLevel;
    private Integer maxStockLevel;
    private String createdBy;
    private String modifiedBy;
}
