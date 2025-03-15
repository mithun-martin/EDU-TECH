package com.EdTech.Edtech.model;

import com.EdTech.Edtech.model.Course;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId; // Foreign key to User (Student)

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course; // Foreign key to Course

    private LocalDate enrollmentDate;

    // Constructors
    public Enrollment() {}

    public Enrollment(Long studentId, Course course, LocalDate enrollmentDate) {
        this.studentId = studentId;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }
}
