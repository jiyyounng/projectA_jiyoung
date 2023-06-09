package com.study.projectA.controller;

import com.study.projectA.service.MemberService;
import com.study.projectA.web.dto.MemberResponseDto;
import com.study.projectA.web.dto.MemberSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/joinMember")
    public MemberResponseDto memberJoin(@Validated @RequestBody MemberSaveRequestDto requestDto){
        return memberService.save(requestDto);
    }

    @PostMapping("/member/loginMember")
    public  MemberResponseDto memberLogin(@RequestBody MemberSaveRequestDto requestDto) {
        return memberService.login(requestDto);
    }

    @GetMapping("/member/check")
    public boolean memberIdCheck(@RequestParam("id") String id) {
        return memberService.idCheck(id);
    }




}



