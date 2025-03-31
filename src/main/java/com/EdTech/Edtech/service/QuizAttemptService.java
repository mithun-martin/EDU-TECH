package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.QuizAttempt;
import com.EdTech.Edtech.model.QuizQuestion;
import com.EdTech.Edtech.repository.QuizAttemptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizAttemptService {
    @Autowired
    private QuizAttemptRepo repo;

    public List<QuizAttempt> getAllQuizAttempt(){
        return repo.findAll();
    }

    public Optional<QuizAttempt> getQuizAttemptById(Long id) {
        return repo.findById(id);
    }

    public QuizAttempt addQuizAttempt(QuizAttempt quizAttempt) {
        return repo.save(quizAttempt);
    }

    public QuizAttempt updateQuizAttempt(Long id, QuizAttempt updatedquizAttempt) {
        return repo.save(updatedquizAttempt);
    }

    public void deleteQuizAttempt (long id) {
        repo.deleteById(id);
    }
}
