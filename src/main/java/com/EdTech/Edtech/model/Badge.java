package com.EdTech.Edtech.model;

import jakarta.persistence.*;

@Entity
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // FK linking to User entity
    private User user;

    private String badgeName;
    private String badgeLevel; // Gold, Silver, Diamond

    // Constructors
    public Badge() {}

    public Badge(User user, String badgeName, String badgeLevel) {
        this.user = user;
        this.badgeName = badgeName;
        this.badgeLevel = badgeLevel;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getBadgeName() { return badgeName; }
    public void setBadgeName(String badgeName) { this.badgeName = badgeName; }

    public String getBadgeLevel() { return badgeLevel; }
    public void setBadgeLevel(String badgeLevel) { this.badgeLevel = badgeLevel; }
}
