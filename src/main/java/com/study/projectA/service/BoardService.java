package com.study.projectA.service;

import com.study.projectA.entity.Board;
import com.study.projectA.entity.BoardRepository;
import com.study.projectA.web.dto.BoardResponseDto;
import com.study.projectA.web.dto.BoardSaveRequestDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    @Transactional
    public Long save(BoardSaveRequestDto requestDto) {return boardRepository.save(requestDto.toEntity()).getNo();}

    @Transactional
    public BoardResponseDto boardRead(Long no) {
        Board entity = boardRepository.findById(no).orElseThrow();
        return new BoardResponseDto(entity);
    }

    @Transactional
    public Long boardUpdate(Long no, BoardSaveRequestDto params) {
        Board entity = boardRepository.findById(no).orElseThrow();
        entity.update(params.getTitle(), params.getContent(), new Date());
        return no;
    }

    @Transactional
    public void boardDelete(Long no) {
        //Board entity = boardRepository.findById(no).orElseThrow();
         boardRepository.deleteById(no);
    }
}

