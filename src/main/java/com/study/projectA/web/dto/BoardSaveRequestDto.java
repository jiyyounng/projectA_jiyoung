package com.study.projectA.web.dto;

import com.study.projectA.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private Long no;
    private String title;
    private String content;
    private Date date;

    public BoardSaveRequestDto(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }
}
