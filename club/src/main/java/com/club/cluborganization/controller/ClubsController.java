package com.club.cluborganization.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.cluborganization.model.Club;
import com.club.cluborganization.repository.ClubsRepository;

@RestController
@RequestMapping("/clubs")
public class ClubsController {

    private final ClubsRepository clubsRepository;

    public ClubsController(ClubsRepository clubsRepository) {
        this.clubsRepository = clubsRepository;
    }

    @GetMapping
    public List<Club> getAllClubs() {
        return clubsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Club getClubById(@PathVariable Long id) {
        return clubsRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Club createClub(@RequestBody Club club) {
        return clubsRepository.save(club);
    }

    @PutMapping("/{id}")
    public Club updateClub(@PathVariable Long id, @RequestBody Club details) {
        Club club = clubsRepository.findById(id).orElse(null);
        if (club != null) {
            club.setName(details.getName());
            club.setDescription(details.getDescription());
            return clubsRepository.save(club);
        }
        return null; // or throw exception
    }

    @DeleteMapping("/{id}")
    public void deleteClub(@PathVariable Long id) {
        clubsRepository.deleteById(id);
    }
}
