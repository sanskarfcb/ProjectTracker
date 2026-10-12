package com.Sanskar.ProjectTaskManager.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectRequestDTO {

    @NotNull
    private Long ownerId;
    @NotBlank
    private String name;
    @NotBlank
    private String description;


}
