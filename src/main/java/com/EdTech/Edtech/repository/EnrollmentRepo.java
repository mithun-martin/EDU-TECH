package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment,Long> {
}
