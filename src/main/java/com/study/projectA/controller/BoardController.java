package com.study.projectA.controller;

import com.study.projectA.entity.Board;
import com.study.projectA.entity.Member;
import com.study.projectA.service.BoardService;
import com.study.projectA.web.dto.BoardResponseDto;
import com.study.projectA.web.dto.BoardSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/list")
    public List<Board> boardList() {
       // model.addAttribute("list", boardService.boardList());
        return boardService.boardList() ;
    }

    @PostMapping("/board/save")
    public Long boardRegister(@RequestBody BoardSaveRequestDto params) {
        return boardService.save(params);
    }

    @GetMapping("/board/read")
    public BoardResponseDto boardRead(@RequestParam("no")Long no) {
        return boardService.boardRead(no);
    }

    @PostMapping("/board/update")
    public Long boardUpdate(@RequestParam("no") Long no, @RequestBody BoardSaveRequestDto params) {
        return boardService.boardUpdate(no, params);
    }
    @DeleteMapping("/board/delete")
    public void boardDelete(@RequestParam Long no) {
        boardService.boardDelete(no);
    }

}
