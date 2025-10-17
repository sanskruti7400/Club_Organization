package com.club.cluborganization.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.club.cluborganization.model.Club;
import com.club.cluborganization.repository.ClubsRepository;

@Service
public class ClubService {

    private final ClubsRepository clubsRepository;

    public ClubService(ClubsRepository clubsRepository) {
        this.clubsRepository = clubsRepository;
    }

    public List<Club> getAllClubs() {
        return clubsRepository.findAll();
    }

    public Optional<Club> getClubById(Long id) {
        return clubsRepository.findById(id);
    }

    public Club saveClub(Club club) {
        return clubsRepository.save(club);
    }

    public void deleteClub(Long id) {
        clubsRepository.deleteById(id);
    }
}
