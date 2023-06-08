package com.study.projectA.test;

import com.study.projectA.entity.Board;
import com.study.projectA.entity.BoardRepository;
import com.study.projectA.service.BoardService;
import com.study.projectA.web.dto.BoardSaveRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BoardTests {

    @InjectMocks
    BoardService boardService;

    @Mock
    BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 작성 테스트")
    void save() {
        BoardSaveRequestDto requestDto = new BoardSaveRequestDto( "테스트 제목", "테스트 내용", new Date());
        Board board = new Board(requestDto);
        boardService.boardSave(requestDto);
        boardRepository.save(board);

        assertEquals("테스트 제목", board.getTitle());
    }


}
