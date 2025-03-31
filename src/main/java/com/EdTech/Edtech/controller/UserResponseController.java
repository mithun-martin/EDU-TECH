package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.UserResponse;
import com.EdTech.Edtech.service.UserResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responses")
public class UserResponseController {
    @Autowired
    private UserResponseService service;

    @GetMapping
    public List<UserResponse> getAllUserResponses() {
        return service.getAllUserResponses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponse>> getUserResponseById(@PathVariable Long id) {
        Optional<UserResponse> response = service.getUserResponseById(id);
        if (response.isPresent()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public UserResponse addUserResponse(@RequestBody UserResponse newUserResponse) {
        return service.addUserResponse(newUserResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUserResponse(@PathVariable long id, @RequestBody UserResponse updatedUserResponse) {
        Optional<UserResponse> response = service.getUserResponseById(id);
        if (response.isPresent()) {
            return new ResponseEntity<>(updatedUserResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserResponse(@PathVariable Long id) {
        Optional<UserResponse> response = service.getUserResponseById(id);
        if (response.isPresent()) {
            service.deleteUserResponse(id);
            return new ResponseEntity<>("UserResponse deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("UserResponse not found", HttpStatus.NOT_FOUND);
        }
    }
}
