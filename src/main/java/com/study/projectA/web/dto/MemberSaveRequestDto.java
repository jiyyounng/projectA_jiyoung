package com.study.projectA.web.dto;

import com.study.projectA.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private String id;
    private String password;
    private String name;
    private String birth;
    private String gender;
    private String phone;
    private String addr;
    private String email;

    @Builder
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

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .password(password)
                .name(name)
                .birth(birth)
                .gender(gender)
                .phone(phone)
                .addr(addr)
                .email(email)
                .build();
    }
}
