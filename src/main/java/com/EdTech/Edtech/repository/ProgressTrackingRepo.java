package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.ProgressTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressTrackingRepo extends JpaRepository<ProgressTracking, Long> {
}
