package com.makes.apibusinesscontroll.dto.request;

import lombok.Data;

@Data
public class SupplierRequest {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String createdBy;
    private String modifiedBy;
}
