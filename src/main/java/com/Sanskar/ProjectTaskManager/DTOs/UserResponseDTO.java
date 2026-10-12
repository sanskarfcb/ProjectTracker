package com.Sanskar.ProjectTaskManager.DTOs;

import com.Sanskar.ProjectTaskManager.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;
}
