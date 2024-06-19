package com.makes.apibusinesscontroll.dto.response;

import lombok.Data;

@Data
public class SupplierResponse {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
}
