package com.EdTech.Edtech.model;

import jakarta.persistence.*;

@Entity //to mark that we have an entity class
//Quiz (ID, Title, Linked Course)
//Question (ID, Question Text, Options, Correct Answer, Linked Quiz)
//QuizAttempt (ID, User, Quiz, Score, Timestamp)
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    //4 rln to course id in course class we cant simply give courseid as
    //private int coureid v n 2 link coloumns
    //course id will be fk to course since wkt each quiz will be
    //part of a single course

    //Yes, exactly! When we use @ManyToOne with Course,
    //our goal is to link each Quiz with a specific Course in the database.
    //Instead of just storing a long courseId

    // ✅ Default Constructor
    public Quiz() {}
    //Yes, we need a default constructor because:
    //Hibernate (JPA) requires a default constructor
    //to instantiate the entity when fetching data from the database.


    //now no more logic simply just create const,getter setter 4 the 3
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
