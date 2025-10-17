package com.club.cluborganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.cluborganization.model.Club;

public interface ClubsRepository extends JpaRepository<Club, Long> {
}
