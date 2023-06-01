package com.study.projectA.service;

import com.study.projectA.entity.Member;
import com.study.projectA.entity.MemberRepository;
import com.study.projectA.web.dto.MemberSaveRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member login(MemberSaveRequestDto requestDto) {

        // dto -> entity
        Member entity = requestDto.toEntity();

        // 회원 엔티티 객체 생성 및 조회
        Member member = memberRepository.findById(entity.getId()).orElseThrow();

        return member;
    }

    @Transactional
    public Member save(MemberSaveRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity());
    }


    @Transactional
    public boolean idCheck(String id) {
        return memberRepository.existsById(id);
    }

}
