package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.Quiz;
import com.EdTech.Edtech.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    @Autowired
    private QuizService service;

    // ✅ Get all quizzes
    @GetMapping //need to return list of all quizzes
    public List<Quiz> getAllQuizzes() {
        return service.getAllQuizzes();
    }

    // ✅ Get quiz by ID
    @GetMapping("/{id}")
    //need to return quiz of given id + ok status else not found status
    public ResponseEntity<Optional<Quiz>> getQuizById(@PathVariable Long id) {
        //maybe Quiz for id not exist therefore optional is used

        Optional<Quiz> quiz = service.getQuizById(id);
        if (quiz.isPresent()) {
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Add a new quiz
    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz newQuiz) {
        return service.addQuiz(newQuiz);
    }

    // ✅ Update an existing quiz
    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
        Optional<Quiz> existingQuiz = service.getQuizById(id);
        if (existingQuiz.isPresent()) {
            return new ResponseEntity<>(service.updateQuiz(id, updatedQuiz), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Delete a quiz by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Long id) {
        //since return tyep is a string plus respone msg
        Optional<Quiz> quiz = service.getQuizById(id);
        if (quiz.isPresent()) {
            service.deleteQuiz(id);
            return new ResponseEntity<>("Quiz deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Quiz not found", HttpStatus.NOT_FOUND);
        }
    }
}
