package com.Sanskar.ProjectTaskManager.Services;

import com.Sanskar.ProjectTaskManager.DTOs.ProjectRequestDTO;
import com.Sanskar.ProjectTaskManager.DTOs.ProjectResponseDTO;

import java.util.List;

public interface ProjectServices {
    ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO);

    ProjectResponseDTO getProjectById(Long id);
    List<ProjectResponseDTO> getAllProjects();
}
