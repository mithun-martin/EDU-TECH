package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.Assignment;
import com.EdTech.Edtech.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService service;

    // ✅ Get all assignments
    @GetMapping
    public List<Assignment> getAllAssignments() {
        return service.getAllAssignments();
    }

    // ✅ Get assignment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Assignment>> getAssignmentById(@PathVariable Long id) {
        Optional<Assignment> assignment = service.getAssignmentById(id);
        if (assignment.isPresent()) {
            return new ResponseEntity<>(assignment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Add a new assignment
    @PostMapping
    public Assignment addAssignment(@RequestBody Assignment newAssignment) {
        return service.addAssignment(newAssignment);
    }

    // ✅ Update an existing assignment
    @PutMapping("/{id}")
    public Assignment updateAssignment(@PathVariable Long id, @RequestBody Assignment updatedAssignment) {
        return service.updateAssignment(id, updatedAssignment);
    }

    // ✅ Delete an assignment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable Long id) {
        Optional<Assignment> assignment = service.getAssignmentById(id);
        if (assignment.isPresent()) {
            service.deleteAssignment(id);
            return new ResponseEntity<>("Assignment deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Assignment not found", HttpStatus.NOT_FOUND);
        }
    }
}
