package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<QuizQuestion,Long> {

    // Custom method to find questions by quiz ID
    List<QuizQuestion> findByQuizId(Long quizId);

}
