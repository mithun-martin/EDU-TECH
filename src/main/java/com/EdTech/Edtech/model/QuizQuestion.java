package com.EdTech.Edtech.model;

import jakarta.persistence.*;

@Entity

public class QuizQuestion {

    @Id
//    Marks the field as the primary key for the table.
//    Every entity (row in the database) must have a unique identifier,and
//    this annotation tells Spring Boot that id is the unique key.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    This tells the database to automatically generate the ID when a new record
//    is inserted. The IDENTITY strategy means the database will use auto-increment,
//    meaning the ID will start at 1, then 2, then 3, etc.
    private Long id;


//    @Column  = Used to customize a database column in a JPA entity.
//    nullable = false  Ensures that this field
//    must always have a value (i.e., it cannot be null)
//

    @Column(nullable = false)
    private String text; // The actual question

    @Column(nullable = false)
    private String optionA;

    @Column(nullable = false)
    private String optionB;

    @Column(nullable = false)
    private String optionC;

    @Column(nullable = false)
    private String optionD;

    @Column(nullable = false)
    private String correctAnswer; // Store the correct option (A, B, C, D)

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)

    //in join column inside child entity
    // it refers to pointing to the primary key of the parent entity
    //name can be anything which will form the name as a  coulumn in table
    //gonna be created and for teh convenience we wrote quiz id

    //the parent entity(QUIZ) to whose primary key we  r gonna create relation ship
    // for the currnent entity class (QUIZQN) must be defined and
    // object be created directly after the many to one and join coloumn annotation

    private Quiz quiz; // Relationship with Quiz entity

    // Default Constructor
    public QuizQuestion() {}

    // Parameterized Constructor
    public QuizQuestion(String text, String optionA, String optionB, String optionC, String optionD, String correctAnswer, Quiz quiz) {
        this.text = text;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.quiz = quiz;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getOptionA() { return optionA; }
    public void setOptionA(String optionA) { this.optionA = optionA; }

    public String getOptionB() { return optionB; }
    public void setOptionB(String optionB) { this.optionB = optionB; }

    public String getOptionC() { return optionC; }
    public void setOptionC(String optionC) { this.optionC = optionC; }

    public String getOptionD() { return optionD; }
    public void setOptionD(String optionD) { this.optionD = optionD; }

    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }

    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }

    // toString() method
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", quiz=" + quiz.getId() +
                '}';
    }
}



