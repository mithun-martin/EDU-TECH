package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.AssignmentSubmission;
import com.EdTech.Edtech.repository.AssignmentSubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentSubmissionService {
    @Autowired
    private AssignmentSubmissionRepo repo;

    public List<AssignmentSubmission> getAllSubmissions() {
        return repo.findAll();
    }

    public Optional<AssignmentSubmission> getSubmissionById(Long id) {
        return repo.findById(id);
    }

    public AssignmentSubmission addSubmission(AssignmentSubmission submission) {
        return repo.save(submission);
    }

    public AssignmentSubmission updateSubmission(Long id, AssignmentSubmission updatedSubmission) {
        return repo.save(updatedSubmission);
    }

    public void deleteSubmission(Long id) {
        repo.deleteById(id);
    }
}
