//User is a separate entity.

//Course is the main entity that contains different components like:
//Assignment
//Quiz
//Enrollment
//Lesson

//Quiz contains QuizQuestion, which represents individual questions inside a quiz.

package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.QuizQuestion;
import com.EdTech.Edtech.service.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuizQuestionController {
    @Autowired
    private QuizQuestionService service;

    // ✅ Get all questions
    @GetMapping
    public List<QuizQuestion> getAllQuestions() {
        return service.getAllQuestions();
    }

    // ✅ Get question by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<QuizQuestion>> getQuestionById(@PathVariable Long id) {
        Optional<QuizQuestion> question = service.getQuestionById(id);
        if (question.isPresent()) {
            return new ResponseEntity<>(question, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Add a new question
    @PostMapping
    public QuizQuestion addQuestion(@RequestBody QuizQuestion newQuizQuestion) {
        return service.addQuestion(newQuizQuestion);
    }

    // ✅ Update an existing question
    @PutMapping("/{id}")
    public ResponseEntity<QuizQuestion> updateQuestion(@PathVariable Long id, @RequestBody QuizQuestion updatedQuizQuestion) {
        Optional<QuizQuestion> existingQuestion = service.getQuestionById(id);
        if (existingQuestion.isPresent()) {
            return new ResponseEntity<>(service.updateQuestion(id, updatedQuizQuestion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Delete a question by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        Optional<QuizQuestion> question = service.getQuestionById(id);
        if (question.isPresent()) {
            service.deleteQuestion(id);
            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
        }
    }
}
