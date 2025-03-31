package com.EdTech.Edtech.model;

import jakarta.persistence.*;

@Entity
public class QuizAttempt {

    //we will cr8 here ye id,user id (to track which user is attempting) and quiz id

    //now 4 establing elnship instead of givingplan quiz id user id we join coloumns
    //by cr8ing their obj 4 thos classes quiz and user

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // FK linking to User entity
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false) // FK linking to Quiz entity
    private Quiz quiz;

    // Default Constructor
    public QuizAttempt() {}

    // Parameterized Constructor
    public QuizAttempt(User user, Quiz quiz) {
        this.user = user;
        this.quiz = quiz;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }
}

