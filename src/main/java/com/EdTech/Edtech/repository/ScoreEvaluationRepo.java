package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.ScoreEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreEvaluationRepo extends JpaRepository<ScoreEvaluation, Long> {
}
