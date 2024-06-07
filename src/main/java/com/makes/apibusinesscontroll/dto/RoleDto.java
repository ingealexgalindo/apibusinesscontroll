package com.makes.apibusinesscontroll.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    @NotBlank
    private String roleName;

    @NotBlank
    private String description;

    @NotBlank
    private String createdBy;

}
