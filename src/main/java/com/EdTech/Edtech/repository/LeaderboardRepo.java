package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardRepo extends JpaRepository<Leaderboard, Long> {
}
