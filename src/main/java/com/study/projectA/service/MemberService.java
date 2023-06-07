package com.study.projectA.service;

import com.study.projectA.entity.Member;
import com.study.projectA.entity.MemberRepository;
import com.study.projectA.web.dto.MemberResponseDto;
import com.study.projectA.web.dto.MemberSaveRequestDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto login(MemberSaveRequestDto requestDto) {
        Member entity = memberRepository.findById(requestDto.getId()).orElseThrow();
        return new MemberResponseDto(entity);
    }

    @Transactional
    public MemberResponseDto save(MemberSaveRequestDto requestDto) {
        Member entity = new Member(requestDto);
        memberRepository.save(entity);
        return new MemberResponseDto(entity);
    }

    @Transactional
    public boolean idCheck(String id) {
        return memberRepository.existsById(id);
    }

}
