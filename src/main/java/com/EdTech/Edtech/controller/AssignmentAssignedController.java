package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.AssignmentAssigned;
import com.EdTech.Edtech.service.AssignmentAssignedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assignments-assigned")
public class AssignmentAssignedController {
    @Autowired
    private AssignmentAssignedService service;

    // ✅ Get all assignments
    @GetMapping
    public List<AssignmentAssigned> getAllAssignments() {
        return service.getAllAssignments();
    }

    // ✅ Get assignment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AssignmentAssigned>> getAssignmentById(@PathVariable Long id) {
        Optional<AssignmentAssigned> assignment = service.getAssignmentById(id);
        return assignment.isPresent() ? new ResponseEntity<>(assignment, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // ✅ Add a new assignment
    @PostMapping
    public AssignmentAssigned addAssignment(@RequestBody AssignmentAssigned newAssignment) {
        return service.addAssignment(newAssignment);
    }

    // ✅ Update an assignment
    @PutMapping("/{id}")
    public ResponseEntity<AssignmentAssigned> updateAssignment(@PathVariable Long id, @RequestBody AssignmentAssigned updatedAssignment) {
        Optional<AssignmentAssigned> assignment = service.getAssignmentById(id);
        return assignment.isPresent() ? new ResponseEntity<>(service.updateAssignment(id, updatedAssignment), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // ✅ Delete an assignment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable Long id) {
        Optional<AssignmentAssigned> assignment = service.getAssignmentById(id);
        if (assignment.isPresent()) {
            service.deleteAssignment(id);
            return new ResponseEntity<>("Assignment deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Assignment not found", HttpStatus.NOT_FOUND);
        }
    }
}
