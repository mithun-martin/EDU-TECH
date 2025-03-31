package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.AssignmentSubmission;
import com.EdTech.Edtech.service.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/submissions")
public class AssignmentSubmissionController {
    @Autowired
    private AssignmentSubmissionService service;

    // ✅ Get all submissions
    @GetMapping
    public List<AssignmentSubmission> getAllSubmissions() {
        return service.getAllSubmissions();
    }

    // ✅ Get submission by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AssignmentSubmission>> getSubmissionById(@PathVariable Long id) {
        Optional<AssignmentSubmission> submission = service.getSubmissionById(id);
        return submission.isPresent() ? new ResponseEntity<>(submission, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // ✅ Add a new submission
    @PostMapping
    public AssignmentSubmission addSubmission(@RequestBody AssignmentSubmission newSubmission) {
        return service.addSubmission(newSubmission);
    }

    // ✅ Update a submission
    @PutMapping("/{id}")
    public ResponseEntity<AssignmentSubmission> updateSubmission(@PathVariable Long id, @RequestBody AssignmentSubmission updatedSubmission) {
        Optional<AssignmentSubmission> submission = service.getSubmissionById(id);
        return submission.isPresent() ? new ResponseEntity<>(service.updateSubmission(id, updatedSubmission), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // ✅ Delete a submission
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubmission(@PathVariable Long id) {
        Optional<AssignmentSubmission> submission = service.getSubmissionById(id);
        if (submission.isPresent()) {
            service.deleteSubmission(id);
            return new ResponseEntity<>("Submission deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Submission not found", HttpStatus.NOT_FOUND);
        }
    }
}
