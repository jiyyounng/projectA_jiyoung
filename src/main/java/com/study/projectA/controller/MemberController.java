package com.study.projectA.controller;

import com.study.projectA.entity.Member;
import com.study.projectA.service.MemberService;
import com.study.projectA.web.dto.MemberSaveRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    private Member member;

    @PostMapping("/member/joinMember")
    public Member memberJoin(@RequestBody MemberSaveRequestDto requestDto){
        return memberService.save(requestDto);
    }

    @PostMapping("/member/loginMember")
    public Member memberLogin(@RequestBody MemberSaveRequestDto requestDto, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("login", memberService.login(requestDto));
        //System.out.println(memberService.login(requestDto));
        return memberService.login(requestDto);
    }

    @GetMapping("/member/check")
    public boolean memberIdCheck(@RequestParam("id") String id) {
        return memberService.idCheck(id);
    }
}
