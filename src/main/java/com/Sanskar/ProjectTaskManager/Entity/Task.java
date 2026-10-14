package com.Sanskar.ProjectTaskManager.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title should not be empty")
    @Size(max = 25)
    @Column(nullable = false, length = 500)
    private String title;

    @NotBlank(message = "description should not be empty")
    @Size(max = 25)
    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;


    private LocalDate dueDate;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "assignee_id", nullable = false)
    private AppUser assignee;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = TaskStatus.TODO;
    }

}
