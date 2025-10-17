package com.club.cluborganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.cluborganization.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
