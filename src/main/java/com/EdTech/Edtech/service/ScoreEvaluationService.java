package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.ScoreEvaluation;
import com.EdTech.Edtech.repository.ScoreEvaluationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreEvaluationService {
    @Autowired
    private ScoreEvaluationRepo repo;

    public List<ScoreEvaluation> getAllScoreEvaluations(){
        return repo.findAll();
    }

    public Optional<ScoreEvaluation> getScoreEvaluationById(Long id) {
        return repo.findById(id);
    }

    public ScoreEvaluation addScoreEvaluation(ScoreEvaluation scoreEvaluation) {
        return repo.save(scoreEvaluation);
    }

    public ScoreEvaluation updateScoreEvaluation(Long id, ScoreEvaluation updatedScoreEvaluation) {
        return repo.save(updatedScoreEvaluation);
    }

    public void deleteScoreEvaluation(Long id) {
        repo.deleteById(id);
    }
}
