package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.Assignment;
import com.EdTech.Edtech.repository.AssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepo repo;

    // ✅ Get all assignments
    public List<Assignment> getAllAssignments() {
        return repo.findAll();
    }

    // ✅ Get assignment by ID
    public Optional<Assignment> getAssignmentById(Long id) {
        return repo.findById(id);
    }

    // ✅ Add a new assignment
    public Assignment addAssignment(Assignment newAssignment) {
        return repo.save(newAssignment);
    }

    // ✅ Update an existing assignment
    public Assignment updateAssignment(Long id, Assignment updatedAssignment) {
        return repo.save(updatedAssignment); // Saves new if not found, updates if found
    }

    // ✅ Delete an assignment by ID
    public String deleteAssignment(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Assignment deleted successfully";
        } else {
            return "No assignment found with this ID";
        }
    }
}
