package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.AssignmentSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentSubmissionRepo extends JpaRepository<AssignmentSubmission, Long> {
}
