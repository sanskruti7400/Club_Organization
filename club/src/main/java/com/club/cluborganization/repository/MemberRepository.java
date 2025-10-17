package com.club.cluborganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.cluborganization.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

