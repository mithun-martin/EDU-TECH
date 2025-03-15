package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.Lesson;
import com.EdTech.Edtech.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private LessonService service;

    // ✅ Get all lessons
    @GetMapping
    public List<Lesson> getAllLessons() {
        return service.getAllLessons();
    }

    // ✅ Get lesson by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Lesson>> getLessonById(@PathVariable Long id) {
        Optional<Lesson> lesson = service.getLessonById(id);
        if (lesson.isPresent()) {
            return new ResponseEntity<>(lesson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Add a new lesson
    @PostMapping
    public Lesson addLesson(@RequestBody Lesson newLesson) {
        return service.addLesson(newLesson);
    }

    // ✅ Update an existing lesson
    @PutMapping("/{id}")
    public Lesson updateLesson(@PathVariable Long id, @RequestBody Lesson updatedLesson) {
        return service.updateLesson(id, updatedLesson);
    }

    // ✅ Delete a lesson by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLesson(@PathVariable Long id) {
        Optional<Lesson> lesson = service.getLessonById(id);
        if (lesson != null) {
            service.deleteLesson(id);
            return new ResponseEntity<>("Lesson deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Lesson not found", HttpStatus.NOT_FOUND);
        }
    }
}
