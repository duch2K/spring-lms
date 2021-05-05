package com.project.lms.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.lms.entity.Member;
import com.project.lms.repository.MemberRepository;
import com.project.lms.service.IMemberService;

import java.util.List;

@Service
public class MemberService implements IMemberService, UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Member> getAll() {
        return memberRepository.getMembersBy();
    }

    @Override
    public Member getByLogin(String login) {
        return memberRepository.getMemberByLogin(login);
    }

    @Override
    public Member createMember(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberRepository.saveAndFlush(member);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Member member = memberRepository.findByLogin(login);

        if (member == null) {
            throw new UsernameNotFoundException("Member by login=" + login + " not found!");
        }
        return member;
    }
}
