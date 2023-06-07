package com.study.projectA.web.dto;

import com.study.projectA.entity.Member;
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

}
