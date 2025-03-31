package com.EdTech.Edtech.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AssignmentSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // FK linking to User entity
    private User user;

    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false) // FK linking to AssignmentAssigned entity
    private AssignmentAssigned assignment;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String submissionText; // User's answer or uploaded file link

    private LocalDateTime submittedAt; // Timestamp of submission

    // Default Constructor
    public AssignmentSubmission() {}

    // Parameterized Constructor
    public AssignmentSubmission(User user, AssignmentAssigned assignment, String submissionText, LocalDateTime submittedAt) {
        this.user = user;
        this.assignment = assignment;
        this.submissionText = submissionText;
        this.submittedAt = submittedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public AssignmentAssigned getAssignment() { return assignment; }
    public void setAssignment(AssignmentAssigned assignment) { this.assignment = assignment; }

    public String getSubmissionText() { return submissionText; }
    public void setSubmissionText(String submissionText) { this.submissionText = submissionText; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
}
