package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.Quiz;
import com.EdTech.Edtech.model.QuizAttempt;
import com.EdTech.Edtech.service.QuizAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attempts")
public class QuizAttemptController {
    @Autowired
    private QuizAttemptService service;

    @GetMapping //need to return list of all quizzes
    public List<QuizAttempt> getAllQuizAttempt() {
        return service.getAllQuizAttempt();
    }

    // ✅ Get quiz by ID
    @GetMapping("/{id}")
    //need to return quiz of given id + ok status else not found status
    public ResponseEntity<Optional<QuizAttempt>> getQuizAttemptById(@PathVariable Long id) {
        //maybe Quiz for id not exist therefore optional is used

        Optional<QuizAttempt> quiz = service.getQuizAttemptById(id);
        if (quiz.isPresent()) {
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Add a new quiz
    @PostMapping
    public QuizAttempt addQuizAttempt(@RequestBody QuizAttempt newQuizAttempt) {
        return service.addQuizAttempt(newQuizAttempt);
    }

    // ✅ Update an existing quiz
    @PutMapping("/{id}")
   public ResponseEntity<QuizAttempt> updateQuizAttempt(@PathVariable long id, @RequestBody QuizAttempt updatedQuizAttempt){
        Optional<QuizAttempt> quiz = service.getQuizAttemptById(id);
        if (quiz.isPresent()){
            return new ResponseEntity<>(updatedQuizAttempt,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Delete a quiz by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuizAttempt(@PathVariable Long id) {
        //since return tyep is a string plus respone msg
        Optional<QuizAttempt> quiz = service.getQuizAttemptById(id);
        if (quiz.isPresent()) {
            service.deleteQuizAttempt(id);
            return new ResponseEntity<>("QuizAttempt deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("QuizAttempt not found", HttpStatus.NOT_FOUND);
        }
    }
}


