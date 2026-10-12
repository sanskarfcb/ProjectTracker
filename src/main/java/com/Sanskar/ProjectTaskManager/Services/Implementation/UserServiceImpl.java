package com.Sanskar.ProjectTaskManager.Services.Implementation;

import com.Sanskar.ProjectTaskManager.DTOs.UserRequestDTO;
import com.Sanskar.ProjectTaskManager.DTOs.UserResponseDTO;
import com.Sanskar.ProjectTaskManager.Entity.AppUser;
import com.Sanskar.ProjectTaskManager.Repo.ProjectRepo;
import com.Sanskar.ProjectTaskManager.Repo.UserRepo;
import com.Sanskar.ProjectTaskManager.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ProjectRepo projectRepo;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){

        AppUser appUser = new AppUser();
        appUser.setName(userRequestDTO.getName());
        appUser.setEmail(userRequestDTO.getEmail());
        appUser.setPassword(userRequestDTO.getPassword());
        appUser.setRole(userRequestDTO.getRole());

        AppUser savedUser = userRepo.save(appUser);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole()
        );
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        AppUser user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return mapToResponse(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private UserResponseDTO mapToResponse(AppUser user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }

}
