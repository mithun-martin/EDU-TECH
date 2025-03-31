package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.ProgressTracking;
import com.EdTech.Edtech.repository.ProgressTrackingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressTrackingService {

    @Autowired
    private ProgressTrackingRepo repo;

    public List<ProgressTracking> getAllProgressTracking() {
        return repo.findAll();
    }

    public Optional<ProgressTracking> getProgressTrackingById(Long id) {
        return repo.findById(id);
    }

    public ProgressTracking addProgressTracking(ProgressTracking progressTracking) {
        return repo.save(progressTracking);
    }

    public ProgressTracking updateProgressTracking(Long id, ProgressTracking updatedProgress) {
            return repo.save(updatedProgress);

    }

    public void deleteProgressTracking(Long id) {
        repo.deleteById(id);
    }
}
