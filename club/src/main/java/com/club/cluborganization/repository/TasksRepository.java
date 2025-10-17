package com.club.cluborganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.cluborganization.model.Task;

public interface TasksRepository extends JpaRepository<Task, Long> {
}

