package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.Enrollment;
import com.EdTech.Edtech.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService service;

    // ✅ Get all enrollments
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return service.getAllEnrollments();
    }

    // ✅ Get enrollment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Enrollment>> getEnrollmentById(@PathVariable Long id) {
        Optional<Enrollment> enrollment = service.getEnrollmentById(id);
        if (enrollment.isPresent()) {
            return new ResponseEntity<>(enrollment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Add a new enrollment
    @PostMapping
    public Enrollment addEnrollment(@RequestBody Enrollment newEnrollment) {
        return service.addEnrollment(newEnrollment);
    }

    // ✅ Update an existing enrollment
    @PutMapping("/{id}")
    public Enrollment updateEnrollment(@PathVariable Long id, @RequestBody Enrollment updatedEnrollment) {
        return service.updateEnrollment(id, updatedEnrollment);
    }

    // ✅ Delete an enrollment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long id) {
        Optional<Enrollment> enrollment = service.getEnrollmentById(id);
        if (enrollment.isPresent()) {
            service.deleteEnrollment(id);
            return new ResponseEntity<>("Enrollment deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Enrollment not found", HttpStatus.NOT_FOUND);
        }
    }
}
