package com.study.projectA.test;

import com.study.projectA.entity.Member;

import com.study.projectA.entity.MemberRepository;
import com.study.projectA.service.MemberService;
import com.study.projectA.web.dto.MemberSaveRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MemberTests {

    @Mock
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입 테스트")
    void join() {
        MemberSaveRequestDto requestDto = new MemberSaveRequestDto("test1", "test1", "test1", "19990810", "여", "01011112222", "경기도", "test1@naver.com");
        Member member = new Member(requestDto);
        memberRepository.save(member);

        assertEquals("test1@naver.com", member.getEmail());
    }

    @Test
    @DisplayName("회원 로그인")
    void login(){
        MemberSaveRequestDto member = new MemberSaveRequestDto("aa","aa");
        String id = "aa";
        memberRepository.findById(id);

        assertEquals("aa", member.getId());
    }




}
