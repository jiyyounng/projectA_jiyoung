package com.study.projectA.test;

import com.study.projectA.entity.Board;
import com.study.projectA.entity.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save() {
        Board params = Board.builder()
                .title("제목4")
                .content("내용4")
                .date(new Date())
                .build();

        boardRepository.save(params);

    }
}
