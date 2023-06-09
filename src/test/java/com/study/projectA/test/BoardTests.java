package com.study.projectA.test;

import com.study.projectA.entity.Board;
import com.study.projectA.entity.BoardRepository;
import com.study.projectA.web.dto.BoardSaveRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BoardTests {

    @Mock
    BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 작성 테스트")
    void testSave() {
        BoardSaveRequestDto requestDto = new BoardSaveRequestDto( "테스트 제목", "테스트 내용", new Date());
        Board board = new Board(requestDto);
        boardRepository.save(board);

        assertEquals("테스트 제목", board.getTitle());
    }

    @Test
    @DisplayName("게시글 목록 조회 테스트")
    void testGetList() {

        Board board1 = new Board(new BoardSaveRequestDto("제목 1", "내용 1", new Date()));
        Board board2 = new Board(new BoardSaveRequestDto("제목 2", "내용 2", new Date()));
        Board board3 = new Board(new BoardSaveRequestDto("제목 3", "내용 3", new Date()));

        boardRepository.save(board1);
        boardRepository.save(board2);
        boardRepository.save(board3);

        List<Board> boardList = new ArrayList<>();
        boardList.add(board1);
        boardList.add(board2);
        boardList.add(board3);

        boardRepository.findAll();

        assertEquals(3, boardList.size());

        assertEquals("제목 1", boardList.get(0).getTitle());
        assertEquals("내용 1", boardList.get(0).getContent());


        assertEquals("제목 2", boardList.get(1).getTitle());
        assertEquals("내용 2", boardList.get(1).getContent());


        assertEquals("제목 3", boardList.get(2).getTitle());
        assertEquals("내용 3", boardList.get(2).getContent());

    }


}
