package com.EdTech.Edtech.service;


import com.EdTech.Edtech.model.Course;
import com.EdTech.Edtech.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepo repo;

    // ✅ Get all courses
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    // ✅ Get course by ID
    public Optional<Course> getCourseById(long id) {
        return repo.findById(id);
    }

    // ✅ Add a new course
    public Course addCourse(Course newCourse) {
        return repo.save(newCourse);
    }

    // ✅ Update an existing course
    public Course updateCourse(long id, Course updatedCourse) {
        return repo.save(updatedCourse); // Saves new if not found, updates if found
    }

    // ✅ Delete a course by ID
    public String deleteCourse(long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Course deleted successfully";
        } else {
            return "No course found with this ID";
        }
    }
}

