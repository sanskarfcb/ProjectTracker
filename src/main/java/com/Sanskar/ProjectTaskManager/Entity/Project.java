package com.Sanskar.ProjectTaskManager.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Give me the name of the project")
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String description;


    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "ownerId",nullable = false)
    private AppUser owner;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
