package com.club.cluborganization.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.club.cluborganization.model.Member;
import com.club.cluborganization.repository.MemberRepository;

@Service
public class MembersService {

    private final MemberRepository membersRepository;

    public MembersService(MemberRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    public List<Member> getAllMembers() {
        return membersRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return membersRepository.findById(id);
    }

    public Member saveMember(Member member) {
        return membersRepository.save(member);
    }

    public void deleteMember(Long id) {
        membersRepository.deleteById(id);
    }
}
