package com.EdTech.Edtech.model;

import jakarta.persistence.*;

@Entity
public class ScoreEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "quiz_attempt_id", nullable = false) // FK linking to QuizAttempt entity
    private QuizAttempt quizAttempt;

    private int score; // Final score of the attempt

    // Default Constructor
    public ScoreEvaluation() {}

    // Parameterized Constructor
    public ScoreEvaluation(QuizAttempt quizAttempt, int score) {
        this.quizAttempt = quizAttempt;
        this.score = score;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public QuizAttempt getQuizAttempt() { return quizAttempt; }
    public void setQuizAttempt(QuizAttempt quizAttempt) { this.quizAttempt = quizAttempt; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}
