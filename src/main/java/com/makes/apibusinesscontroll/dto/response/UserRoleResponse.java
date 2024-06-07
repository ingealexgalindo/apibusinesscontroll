package com.makes.apibusinesscontroll.dto.response;

import lombok.Data;

@Data
public class UserRoleResponse {
    private Integer userRoleId;
    private UserResponse user;
    private RoleResponse role;

}
