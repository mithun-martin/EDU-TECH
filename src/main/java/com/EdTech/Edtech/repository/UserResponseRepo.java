package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponseRepo extends JpaRepository<UserResponse, Long> {
}
