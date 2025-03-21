package com.EdTech.Edtech.model;

import jakarta.persistence.*;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course; // Proper relationship with Course entity
    //course id will be fk to course since wkt each ass willbe
    //part of a single course

    // ✅ Default Constructor
    public Quiz() {}

    // ✅ Parameterized Constructor
    public Quiz(String title, Course course) {
        this.title = title;
        this.course = course;
    }

    // ✅ Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
