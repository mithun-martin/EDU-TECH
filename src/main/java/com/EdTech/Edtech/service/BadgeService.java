package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.Badge;
import com.EdTech.Edtech.repository.BadgeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BadgeService {
    @Autowired
    private BadgeRepo repo;

    public List<Badge> getAllBadges() { return repo.findAll(); }

    public Optional<Badge> getBadgeById(Long id) { return repo.findById(id); }

    public Badge addBadge(Badge badge) { return repo.save(badge); }

    public void deleteBadge(Long id) { repo.deleteById(id); }
}
