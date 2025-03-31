package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepo extends JpaRepository<Badge, Long> {
}
