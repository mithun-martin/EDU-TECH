package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment,Long> {
}
