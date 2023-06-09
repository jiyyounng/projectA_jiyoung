package com.study.projectA.controller;

import com.study.projectA.entity.Board;
import com.study.projectA.service.BoardService;
import com.study.projectA.web.dto.BoardResponseDto;
import com.study.projectA.web.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public List<Board> boardList() {
        return boardService.boardList() ;
    }

    @GetMapping("/board/read")
    public BoardResponseDto boardRead(@RequestParam Long no) {
        return boardService.boardRead(no);
    }

    @PostMapping("/board/save")
    public BoardResponseDto boardRegister(@RequestBody BoardSaveRequestDto requestDto) {
        return boardService.boardSave(requestDto);
    }

    @PostMapping("/board/update")
    public Long boardUpdate(@RequestParam Long no, @RequestBody BoardSaveRequestDto requestDto) {
        return boardService.boardUpdate(no, requestDto);
    }
    @DeleteMapping("/board/delete")
    public void boardDelete(@RequestParam Long no) {
        boardService.boardDelete(no);
    }

}
