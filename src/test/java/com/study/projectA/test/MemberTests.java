package com.study.projectA.test;

import com.study.projectA.entity.Member;
import com.study.projectA.entity.MemberRepository;
import com.study.projectA.web.dto.MemberResponseDto;
import com.study.projectA.web.dto.MemberSaveRequestDto;
import org.antlr.v4.runtime.misc.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTests {

    @Autowired
    MemberRepository memberRepository;


    // 회원가입 insert 테스트
    /*
    @Test
    void save() {
        Member params = Member.builder()
                .id("abc1")
                .password("1234")
                .name("abc")
                .birth("1999-08-10")
                .gender("여자")
                .phone("010-1234-5678")
                .addr("경기도 과천시")
                .email("abc1@gmail.com")
                .build();
        memberRepository.save(params);

    }
    */


}
