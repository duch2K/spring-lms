package com.project.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.lms.entity.Member;
import com.project.lms.service.implement.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    // GET
    @GetMapping("")
    public List<Member> getAllMembers() {
        return memberService.getAll();
    }

//    @GetMapping("")
//    public Member getMember(@RequestParam("login") String login) {
//        return memberService.getByLogin(login);
//    }

    @PostMapping("/create")
    public Member createNewMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }
}
