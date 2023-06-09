package com.study.projectA.service;

import com.study.projectA.entity.Board;
import com.study.projectA.entity.BoardRepository;
import com.study.projectA.web.dto.BoardResponseDto;
import com.study.projectA.web.dto.BoardSaveRequestDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    @Transactional
    public BoardResponseDto boardRead(Long no) {
        Board entity = boardRepository.findById(no).orElseThrow(()-> new NoSuchElementException("없어요"));;
        return new BoardResponseDto(entity);
    }

    @Transactional
    public BoardResponseDto boardSave(BoardSaveRequestDto requestDto) {
        Board entity = new Board(requestDto);
        boardRepository.save(entity);
        return new BoardResponseDto(entity);
    }

    @Transactional
    public Long boardUpdate(Long no, BoardSaveRequestDto requestDto) {
        Board entity = boardRepository.findById(no).orElseThrow(()-> new NoSuchElementException("없어요"));
        entity.update(requestDto);
        return no;
    }

    @Transactional
    public void boardDelete(Long no) {
         boardRepository.deleteById(no);
    }
}

