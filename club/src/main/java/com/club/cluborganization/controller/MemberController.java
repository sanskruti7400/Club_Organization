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

import com.club.cluborganization.model.Member;
import com.club.cluborganization.repository.MemberRepository;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member details) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member != null) {
            member.setName(details.getName());
            member.setDepartment(details.getDepartment());
            member.setYear(details.getYear());
            member.setContact(details.getContact());
            member.setJoinDate(details.getJoinDate());
            member.setUser(details.getUser());
            return memberRepository.save(member);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }
}
