package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.domain.BoardEnty;
import com.spring.web.mapper.BoardMapper;

@Service
public class BoardService {
    
    @Autowired
    BoardMapper boardMapper;
    
    public List<BoardEnty> getBoardList(){
        
        return boardMapper.getBoardList();
    }
    
    public BoardEnty getBoardInfo(int bbsno){
        
        return boardMapper.getBoardInfo(bbsno);
    }
    
    public int insertBoardContent(BoardEnty boardEnty){
        
        return boardMapper.insertBoardContent(boardEnty);
    }
}
