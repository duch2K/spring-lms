package com.project.lms.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.lms.entity.Member;
import com.project.lms.repository.MemberRepository;
import com.project.lms.service.IMemberService;

@Service
public class MemberService implements IMemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public boolean checkByLoginAndPassword(String login, String password) {
        return memberRepository.existsMemberByLoginAndPassword(login, password);
    }

    @Override
    public Member getByLogin(String login) {
        return memberRepository.getMemberByLogin(login);
    }
}
