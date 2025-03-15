package com.EdTech.Edtech.model;

import com.EdTech.Edtech.model.Course;
import jakarta.persistence.*;

@Entity
public class Lesson { //rep a lesson inside a course

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")  // Stores large text content
    private String content;

    private String videoUrl;

    private String accessibilityOptions;  // Example: "Text-to-Speech, Captions"

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course; // Foreign key to Course

    // Constructors
    public Lesson() {}

    public Lesson(String title, String content, String videoUrl, String accessibilityOptions, Course course) {
        this.title = title;
        this.content = content;
        this.videoUrl = videoUrl;
        this.accessibilityOptions = accessibilityOptions;
        this.course = course;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }

    public String getAccessibilityOptions() { return accessibilityOptions; }
    public void setAccessibilityOptions(String accessibilityOptions) { this.accessibilityOptions = accessibilityOptions; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}





//package com.EdTech.Edtech.model;
//
//import jakarta.persistence.*;
//
//@Entity
//
//public class Lesson {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String title;
//    private String content;
//    private String videoUrl;
//
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course; // FK to Course
//}
