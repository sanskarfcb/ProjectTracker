package com.Sanskar.ProjectTaskManager.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ProjectResponseDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private String ownerName;
}
