package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.Enrollment;
import com.EdTech.Edtech.repository.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    EnrollmentRepo repo;

    // ✅ Get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return repo.findAll();
    }

    // ✅ Get enrollment by ID
    public Optional<Enrollment> getEnrollmentById(Long id) {
        return repo.findById(id);
    }

    // ✅ Add a new enrollment
    public Enrollment addEnrollment(Enrollment newEnrollment) {
        return repo.save(newEnrollment);
    }

    // ✅ Update an existing enrollment
    public Enrollment updateEnrollment(Long id, Enrollment updatedEnrollment) {
        return repo.save(updatedEnrollment); // Saves new if not found, updates if found
    }

    // ✅ Delete an enrollment by ID
    public String deleteEnrollment(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Enrollment deleted successfully";
        } else {
            return "No enrollment found with this ID";
        }
    }
}
