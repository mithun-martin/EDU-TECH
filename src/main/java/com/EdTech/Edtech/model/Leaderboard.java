package com.EdTech.Edtech.model;

import jakarta.persistence.*;

@Entity
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // FK linking to User entity
    private User user;

    private int position;
    private int score;
    private String lastUpdated;

    // Constructors
    public Leaderboard() {}

    public Leaderboard(User user, int position, int score, String lastUpdated) {
        this.user = user;
        this.position = position;
        this.score = score;
        this.lastUpdated = lastUpdated;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; }
}
