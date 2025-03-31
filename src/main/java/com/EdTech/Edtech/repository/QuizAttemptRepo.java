package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizAttemptRepo extends JpaRepository<QuizAttempt,Long> {
}
