package com.EdTech.Edtech.model;

import jakarta.persistence.*;

@Entity
public class ProgressTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private int totalQuizzesAttempted;
    private int totalAssignmentsSubmitted;
    private int totalBadgesEarned;

    private double progressPercentage;

    // Constructors
    public ProgressTracking() {}

    public ProgressTracking(User user, int totalQuizzesAttempted, int totalAssignmentsSubmitted, int totalBadgesEarned, double progressPercentage) {
        this.user = user;
        this.totalQuizzesAttempted = totalQuizzesAttempted;
        this.totalAssignmentsSubmitted = totalAssignmentsSubmitted;
        this.totalBadgesEarned = totalBadgesEarned;
        this.progressPercentage = progressPercentage;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public int getTotalQuizzesAttempted() { return totalQuizzesAttempted; }
    public void setTotalQuizzesAttempted(int totalQuizzesAttempted) { this.totalQuizzesAttempted = totalQuizzesAttempted; }

    public int getTotalAssignmentsSubmitted() { return totalAssignmentsSubmitted; }
    public void setTotalAssignmentsSubmitted(int totalAssignmentsSubmitted) { this.totalAssignmentsSubmitted = totalAssignmentsSubmitted; }

    public int getTotalBadgesEarned() { return totalBadgesEarned; }
    public void setTotalBadgesEarned(int totalBadgesEarned) { this.totalBadgesEarned = totalBadgesEarned; }

    public double getProgressPercentage() { return progressPercentage; }
    public void setProgressPercentage(double progressPercentage) { this.progressPercentage = progressPercentage; }
}
