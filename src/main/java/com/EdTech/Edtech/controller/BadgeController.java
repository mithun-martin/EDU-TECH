package com.EdTech.Edtech.controller;

import com.EdTech.Edtech.model.Badge;
import com.EdTech.Edtech.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/badges")
public class BadgeController {
    @Autowired
    private BadgeService service;

    // ✅ Get all badges
    @GetMapping
    public List<Badge> getAllBadges() {
        return service.getAllBadges();
    }

    // ✅ Get badge by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Badge>> getBadgeById(@PathVariable Long id) {
        Optional<Badge> badge = service.getBadgeById(id);
        if (badge.isPresent()) {
            return new ResponseEntity<>(badge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Add a new badge
    @PostMapping
    public Badge addBadge(@RequestBody Badge newBadge) {
        return service.addBadge(newBadge);
    }



    // ✅ Delete a badge by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBadge(@PathVariable Long id) {
        Optional<Badge> badge = service.getBadgeById(id);
        if (badge.isPresent()) {
            service.deleteBadge(id);
            return new ResponseEntity<>("Badge deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Badge not found", HttpStatus.NOT_FOUND);
        }
    }
}
