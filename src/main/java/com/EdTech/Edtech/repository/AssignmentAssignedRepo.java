package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.AssignmentAssigned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentAssignedRepo extends JpaRepository<AssignmentAssigned, Long> {
}
