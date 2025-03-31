package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.QuizQuestion;
import com.EdTech.Edtech.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizQuestionService {
    @Autowired
    private QuestionRepo repo;

    public List<QuizQuestion> getAllQuestions() {
        return repo.findAll();
    }

    public Optional<QuizQuestion> getQuestionById(Long id) {
        return repo.findById(id);
    }

    public QuizQuestion addQuestion(QuizQuestion quizQuestion) {
        return repo.save(quizQuestion);
    }

    public QuizQuestion updateQuestion(Long id, QuizQuestion updatedQuizQuestion) {
        return repo.save(updatedQuizQuestion);
    }

    public void deleteQuestion(Long id) {
        repo.deleteById(id);
    }
}
