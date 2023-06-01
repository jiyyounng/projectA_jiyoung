package com.study.projectA.web.dto;

import com.study.projectA.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private String id;
    private String password;
    private String name;
    private String birth;
    private String gender;
    private String phone;
    private String addr;
    private String email;

    public MemberResponseDto(Member entity) {
        this.id = entity.getId();
        this.password = entity.getPassword();
        this.name = entity.getName();
        this.birth = entity.getBirth();
        this.gender = entity.getGender();
        this.phone = entity.getPhone();
        this.addr = entity.getAddr();
        this.email = entity.getEmail();
    }

}