package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.ProgressTracking;
import com.EdTech.Edtech.service.ProgressTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/progress")
public class ProgressTrackingController {
    @Autowired
    private ProgressTrackingService service;

    // ✅ Get all progress tracking records
    @GetMapping
    public List<ProgressTracking> getAllProgressTracking() {
        return service.getAllProgressTracking();
    }

    // ✅ Get progress tracking by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProgressTracking>> getProgressTrackingById(@PathVariable Long id) {
        Optional<ProgressTracking> progress = service.getProgressTrackingById(id);
        if (progress.isPresent()) {
            return new ResponseEntity<>(progress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Add a new progress tracking record
    @PostMapping
    public ProgressTracking addProgressTracking(@RequestBody ProgressTracking newProgress) {
        return service.addProgressTracking(newProgress);
    }

    // ✅ Update an existing progress tracking record
    @PutMapping("/{id}")
    public ResponseEntity<ProgressTracking> updateProgressTracking(@PathVariable Long id, @RequestBody ProgressTracking updatedProgress) {
        Optional<ProgressTracking> existingProgress = service.getProgressTrackingById(id);
        if (existingProgress.isPresent()) {
            return new ResponseEntity<>(service.updateProgressTracking(id, updatedProgress), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Delete a progress tracking record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProgressTracking(@PathVariable Long id) {
        Optional<ProgressTracking> progress = service.getProgressTrackingById(id);
        if (progress.isPresent()) {
            service.deleteProgressTracking(id);
            return new ResponseEntity<>("ProgressTracking deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ProgressTracking not found", HttpStatus.NOT_FOUND);
        }
    }
}
