package com.project.lms.service;

import com.project.lms.entity.Member;

import java.util.List;

public interface IMemberService {
    List<Member> getAll();
    Member getByLogin(String login);
    Member createMember(Member member);
}
