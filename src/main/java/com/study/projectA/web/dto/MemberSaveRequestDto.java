package com.study.projectA.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private Long idx;
    private String id;
    private String password;
    private String name;
    private String birth;
    private String gender;
    private String phone;
    private String addr;
    private String email;

    public MemberSaveRequestDto(String id, String password, String name, String birth, String gender, String phone, String addr, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.phone = phone;
        this.addr = addr;
        this.email = email;
    }

    public MemberSaveRequestDto(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
