package com.Sanskar.ProjectTaskManager.DTOs;


import com.Sanskar.ProjectTaskManager.Entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank(message = "name should not be null")
    private String name;

    @NotBlank
    @Email(message = "invalid email address")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotNull
    private Role role;
}
