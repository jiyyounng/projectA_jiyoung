package com.study.projectA.entity;

import com.study.projectA.web.dto.BoardSaveRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String title;
    private String content;
    private Date date;

    public Board(BoardSaveRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.date = new Date();
    }

    public void update(BoardSaveRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.date = new Date();
    }

}
