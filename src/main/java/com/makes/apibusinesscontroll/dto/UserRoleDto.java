package com.makes.apibusinesscontroll.dto;

import com.makes.apibusinesscontroll.models.Role;
import com.makes.apibusinesscontroll.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {

    @NotBlank
    private Integer userId;

    @NotBlank
    private Integer roleId;

    @NotBlank
    private String createdBy;
}
