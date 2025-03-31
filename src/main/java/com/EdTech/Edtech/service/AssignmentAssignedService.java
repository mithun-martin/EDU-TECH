package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.AssignmentAssigned;
import com.EdTech.Edtech.repository.AssignmentAssignedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentAssignedService {
    @Autowired
    private AssignmentAssignedRepo repo;

    public List<AssignmentAssigned> getAllAssignments() {
        return repo.findAll();
    }

    public Optional<AssignmentAssigned> getAssignmentById(Long id) {
        return repo.findById(id);
    }

    public AssignmentAssigned addAssignment(AssignmentAssigned assignment) {
        return repo.save(assignment);
    }

    public AssignmentAssigned updateAssignment(Long id, AssignmentAssigned updatedAssignment) {
        return repo.save(updatedAssignment);
    }

    public void deleteAssignment(Long id) {
        repo.deleteById(id);
    }
}
