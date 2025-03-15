package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.Course;
import com.EdTech.Edtech.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService service;

    // ✅ Get all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    // ✅ Get course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> getCourseById(@PathVariable int id) {
        Optional<Course> course = service.getCourseById(id);
        if (course.isPresent()) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Add a new course
    @PostMapping
    public Course addCourse(@RequestBody Course newCourse) {
        return service.addCourse(newCourse);
    }

    // ✅ Update an existing course
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course updatedCourse) {
        return service.updateCourse(id, updatedCourse);
    }

    // ✅ Delete a course by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        Optional<Course> course = service.getCourseById(id);
        if (course.isPresent()) {
            service.deleteCourse(id);
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
    }

}
