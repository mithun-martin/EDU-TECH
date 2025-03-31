package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizQuestionRepo extends JpaRepository<Quiz,Long> {
}
