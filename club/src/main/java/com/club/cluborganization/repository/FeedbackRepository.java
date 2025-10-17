package com.club.cluborganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.cluborganization.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
