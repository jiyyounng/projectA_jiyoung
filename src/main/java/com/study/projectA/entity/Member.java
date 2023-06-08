package com.study.projectA.entity;

import com.study.projectA.web.dto.MemberSaveRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 2, max = 10, message = "아이디는 2자 이상 10자 이하로 입력해주세요.")
    private String id;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
    private String password;

    private String name;
    private String birth;
    private String gender;

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phone;
    private String addr;

    @NotBlank(message = "이메일 주소를 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String email;

    public Member(MemberSaveRequestDto requestDto) {
        this.id = requestDto.getId();
        this.password = requestDto.getPassword();
        this.name = requestDto.getName();
        this.birth = requestDto.getBirth();
        this.gender = requestDto.getGender();
        this.phone = requestDto.getPhone();
        this.addr = requestDto.getAddr();
        this.email = requestDto.getEmail();
    }

    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
