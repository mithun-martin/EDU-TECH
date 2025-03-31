package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.Quiz;
import com.EdTech.Edtech.repository.QuizQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizQuestionRepo repo;

    public List<Quiz> getAllQuizzes() {
        return repo.findAll();
    }

    public Optional<Quiz> getQuizById(Long id) {
        return repo.findById(id);
    }

    public Quiz addQuiz(Quiz quiz) {
        return repo.save(quiz);
    }

    //for updatig..first we findby id ..then we map each attribute iwth new value
    //then we save it
    //so we need 2 para one is id 4 checking andto add we want the new quiz

    public Quiz updateQuiz(Long id, Quiz updatedQuiz) {
        return repo.save(updatedQuiz);
    }

    //for add and update 4 con4m8ion bh  user we retur
    // added or update data back 2 controller
    //for delete nt  needed so its void..
    //but 4 g8ing if it was sucesfful
    //we give a resonse msg in contriller
    //We manually send a success response.

    //example
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteQuiz(@PathVariable Long id) {
//        quizService.deleteQuiz(id);
//        return ResponseEntity.ok("Quiz deleted successfully");
//    }

    public void deleteQuiz(Long id){
        repo.deleteById(id);
        // If ID exists, updates. If not, inserts a new quiz.

    }
}
