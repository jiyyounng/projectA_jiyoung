package com.study.projectA.web.dto;

import com.study.projectA.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private Long no;
    private String title;
    private String content;
    private Date date;

    @Builder
    public BoardSaveRequestDto(Long no, String title, String content, Date date) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .date(new Date())
                .build();
    }

}
