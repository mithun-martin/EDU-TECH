package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.ScoreEvaluation;
import com.EdTech.Edtech.service.ScoreEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scores")
public class ScoreEvaluationController {
    @Autowired
    private ScoreEvaluationService service;

    @GetMapping
    public List<ScoreEvaluation> getAllScoreEvaluations() {
        return service.getAllScoreEvaluations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ScoreEvaluation>> getScoreEvaluationById(@PathVariable Long id) {
        Optional<ScoreEvaluation> score = service.getScoreEvaluationById(id);
        if (score.isPresent()) {
            return new ResponseEntity<>(score, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ScoreEvaluation addScoreEvaluation(@RequestBody ScoreEvaluation newScoreEvaluation) {
        return service.addScoreEvaluation(newScoreEvaluation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScoreEvaluation(@PathVariable Long id) {
        Optional<ScoreEvaluation> score = service.getScoreEvaluationById(id);
        if (score.isPresent()) {
            service.deleteScoreEvaluation(id);
            return new ResponseEntity<>("ScoreEvaluation deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ScoreEvaluation not found", HttpStatus.NOT_FOUND);
        }
    }
}
