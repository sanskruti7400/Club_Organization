package com.club.cluborganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.cluborganization.model.Event;

public interface EventsRepository extends JpaRepository<Event, Long> {
}

