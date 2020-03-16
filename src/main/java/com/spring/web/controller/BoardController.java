package com.spring.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.domain.BoardEnty;
import com.spring.web.service.BoardService;

@Controller
public class BoardController {
    
    @Autowired
    BoardService boardService;
    
    @RequestMapping(value="/boardListView", method={RequestMethod.POST,RequestMethod.GET})
    public String boardIndex(Model model){
        
        List<BoardEnty> listBoard = boardService.getBoardList();
        model.addAttribute("listBoard" ,listBoard);
        
        return "boardListView";
    }
    
    @RequestMapping(value="/boardWriteView", method={RequestMethod.POST,RequestMethod.GET})
    public String boardWriteView(){
       
        return "boardWriteView";
    }
    
    @RequestMapping(value="/boardWriteAction", method={RequestMethod.POST,RequestMethod.GET})
    public String boardWriteAction(HttpServletRequest req){
        
        BoardEnty boardEnty= new BoardEnty();
        boardEnty.setSubject(req.getParameter("subject"));
        boardEnty.setWname(req.getParameter("wname"));
        boardEnty.setContent(req.getParameter("content"));
        boardEnty.setPasswd("123");
        boardEnty.setReadcnt(0);
        boardService.insertBoardContent(boardEnty);
        
        return "redirect:/boardListView";
    }
    
    @RequestMapping(value="/boardReadView", method={RequestMethod.POST})
    public String boardReadView(Model model,HttpServletRequest req){
       
        BoardEnty boardEnty = boardService.getBoardInfo((Integer.parseInt(req.getParameter("bbsno"))));
        model.addAttribute("boardEnty" ,boardEnty);
        
        return "boardReadView";
    }
}
