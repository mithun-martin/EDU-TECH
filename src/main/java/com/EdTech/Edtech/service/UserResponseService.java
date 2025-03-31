package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.UserResponse;
import com.EdTech.Edtech.repository.UserResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserResponseService {
    @Autowired
    private UserResponseRepo repo;

    public List<UserResponse> getAllUserResponses(){
        return repo.findAll();
    }

    public Optional<UserResponse> getUserResponseById(Long id) {
        return repo.findById(id);
    }

    public UserResponse addUserResponse(UserResponse userResponse) {
        return repo.save(userResponse);
    }

    public UserResponse updateUserResponse(Long id, UserResponse updatedUserResponse) {
        return repo.save(updatedUserResponse);
    }

    public void deleteUserResponse(Long id) {
        repo.deleteById(id);
    }
}
