package com.study.projectA.web.dto;

import com.study.projectA.entity.Board;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BoardResponseDto {
    private Long no;
    private String title;
    private String content;
    private Date date;

    public BoardResponseDto(Board entity) {
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.date = entity.getDate();
    }
}
