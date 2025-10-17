package com.club.cluborganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.cluborganization.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
