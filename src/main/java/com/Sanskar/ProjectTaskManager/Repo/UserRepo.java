package com.Sanskar.ProjectTaskManager.Repo;

import com.Sanskar.ProjectTaskManager.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser,Long> {
}
