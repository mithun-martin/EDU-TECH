package com.EdTech.Edtech.model;

import jakarta.persistence.*;

@Entity
public class UserResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_attempt_id", nullable = false) // FK linking to QuizAttempt entity
    private QuizAttempt quizAttempt;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false) // FK linking to QuizQuestion entity
    private QuizQuestion question;

    private String userAnswer; // The user's selected answer

    // Default Constructor
    public UserResponse() {}

    // Parameterized Constructor
    public UserResponse(QuizAttempt quizAttempt, QuizQuestion question, String userAnswer) {
        this.quizAttempt = quizAttempt;
        this.question = question;
        this.userAnswer = userAnswer;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public QuizAttempt getQuizAttempt() { return quizAttempt; }
    public void setQuizAttempt(QuizAttempt quizAttempt) { this.quizAttempt = quizAttempt; }

    public QuizQuestion getQuestion() { return question; }
    public void setQuestion(QuizQuestion question) { this.question = question; }

    public String getUserAnswer() { return userAnswer; }
    public void setUserAnswer(String userAnswer) { this.userAnswer = userAnswer; }
}
