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
public class UserRoleUpdateDto {

    @NotBlank
    private Role role;

    @NotBlank
    private User user;
    
    @NotBlank
    private String modifiedBy;
}
