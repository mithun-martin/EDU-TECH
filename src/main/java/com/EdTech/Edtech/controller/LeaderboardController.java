package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.Leaderboard;
import com.EdTech.Edtech.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
public class LeaderboardController {

    @Autowired
    private LeaderboardService service;

    @GetMapping
    public ResponseEntity<List<Leaderboard>> getLeaderboard() {
        return ResponseEntity.ok(service.getAllLeaderboard());
    }

    @PostMapping
    public ResponseEntity<Leaderboard> addLeaderboardEntry(@RequestBody Leaderboard leaderboard) {
        return ResponseEntity.ok(service.addLeaderboardEntry(leaderboard));
    }
}
