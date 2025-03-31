package com.EdTech.Edtech.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AssignmentAssigned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false) // FK linking to Course entity
    private Course course;

    private String title; // Short name for assignment

    @Column(nullable = false)
    private String assignmentTask; // Task description

    @Column(nullable = false)
    private Integer maxMarks; // Maximum score

    @Column(nullable = false)
    private LocalDateTime dueDate; // Deadline for submission

    private LocalDateTime createdAt; // Timestamp when created

    // Default Constructor
    public AssignmentAssigned() {
        this.createdAt = LocalDateTime.now(); // Set created time when object is made
    }

    // Parameterized Constructor
    public AssignmentAssigned(Course course, String title, String assignmentTask, Integer maxMarks, LocalDateTime dueDate) {
        this.course = course;
        this.title = title;
        this.assignmentTask = assignmentTask;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAssignmentTask() { return assignmentTask; }
    public void setAssignmentTask(String assignmentTask) { this.assignmentTask = assignmentTask; }

    public Integer getMaxMarks() { return maxMarks; }
    public void setMaxMarks(Integer maxMarks) { this.maxMarks = maxMarks; }

    public LocalDateTime getDueDate() { return dueDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
