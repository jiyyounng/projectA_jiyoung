package com.study.projectA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String title;
    private String content;
    private Date date;

    @Builder
    public Board(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public void update(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

}
