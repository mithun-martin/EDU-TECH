package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.Leaderboard;
import com.EdTech.Edtech.repository.LeaderboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {
    @Autowired
    private LeaderboardRepo repo;

    public List<Leaderboard> getAllLeaderboard() { return repo.findAll(); }

    public Leaderboard addLeaderboardEntry(Leaderboard leaderboard) { return repo.save(leaderboard); }
}
