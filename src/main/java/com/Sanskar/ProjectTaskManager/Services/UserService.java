package com.Sanskar.ProjectTaskManager.Services;

import com.Sanskar.ProjectTaskManager.DTOs.UserRequestDTO;
import com.Sanskar.ProjectTaskManager.DTOs.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
}
