package com.Sanskar.ProjectTaskManager.Controller;

import com.Sanskar.ProjectTaskManager.DTOs.ProjectRequestDTO;
import com.Sanskar.ProjectTaskManager.DTOs.ProjectResponseDTO;
import com.Sanskar.ProjectTaskManager.Services.ProjectServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectServices projectServices;

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@Valid @RequestBody ProjectRequestDTO projectRequestDTO){
        ProjectResponseDTO projectResponseDTO = projectServices.createProject(projectRequestDTO);
        return new ResponseEntity<>(projectResponseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectServices.getProjectById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects() {
        return ResponseEntity.ok(projectServices.getAllProjects());
    }

}
