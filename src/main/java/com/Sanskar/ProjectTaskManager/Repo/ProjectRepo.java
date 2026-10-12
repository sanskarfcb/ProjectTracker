package com.Sanskar.ProjectTaskManager.Repo;

import com.Sanskar.ProjectTaskManager.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,Long> {
}
