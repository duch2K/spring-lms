package com.project.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.lms.entity.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsMemberByLoginAndPassword(String login, String password);
    Member getMemberByLogin(String login);
    Member findByLogin(String login);
    List<Member> getMembersBy();
}
