package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.User;
import com.EdTech.Edtech.model.UserRole;
import com.EdTech.Edtech.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> getUsersByRole(String role) {
        try {
            UserRole userRole = UserRole.valueOf(role.toUpperCase()); // Convert safely
            return userRepository.findByRole(userRole);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    public String registerUser(User user) {
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String loginUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            return "Login successful!";
        }
        return "Invalid email or password!";
    }

}
