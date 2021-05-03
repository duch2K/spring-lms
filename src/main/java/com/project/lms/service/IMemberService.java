package com.project.lms.service;

import com.project.lms.entity.Member;

public interface IMemberService {
    boolean checkByLoginAndPassword(String login, String password);
    Member getByLogin(String login);
}
