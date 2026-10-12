package com.Sanskar.ProjectTaskManager.Services.Implementation;

import com.Sanskar.ProjectTaskManager.DTOs.ProjectRequestDTO;
import com.Sanskar.ProjectTaskManager.DTOs.ProjectResponseDTO;
import com.Sanskar.ProjectTaskManager.Entity.AppUser;
import com.Sanskar.ProjectTaskManager.Entity.Project;
import com.Sanskar.ProjectTaskManager.Repo.ProjectRepo;
import com.Sanskar.ProjectTaskManager.Repo.UserRepo;
import com.Sanskar.ProjectTaskManager.Services.ProjectServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectServices {

    private final ProjectRepo projectRepo;
    private final UserRepo userRepo;

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO) {

        AppUser appUser = userRepo.findById(projectRequestDTO.getOwnerId())
                .orElseThrow(()
                        -> new RuntimeException("User not found with id: " + projectRequestDTO.getOwnerId()));

        Project project = new Project();
        project.setName(projectRequestDTO.getName());
        project.setDescription(projectRequestDTO.getDescription());
        project.setOwner(appUser);

        Project savedProject = projectRepo.save(project);

        return new ProjectResponseDTO(
                savedProject.getId(),
                savedProject.getName(),
                savedProject.getDescription(),
                savedProject.getCreatedAt(),
                savedProject.getOwner().getName()
        );
    }

    public ProjectResponseDTO getProjectById(Long id){
        Project project1 = projectRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
        return mapToResponse(project1);
        }

        public List<ProjectResponseDTO> getAllProjects() {
            return projectRepo.findAll()
                    .stream()
                    .map(this::mapToResponse)
                    .toList();
        }

        private ProjectResponseDTO mapToResponse(Project project) {
            return new ProjectResponseDTO(
                    project.getId(),
                    project.getName(),
                    project.getDescription(),
                    project.getCreatedAt(),
                    project.getOwner().getName()
            );
        }

    }
