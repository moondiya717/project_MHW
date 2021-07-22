package kr.home.practice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.home.practice.service.BoardService;
import kr.home.practice.vo.BoardVO;
import kr.home.practice.vo.MemberVO;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
		
    @Autowired
    BoardService boardService;
    
    @RequestMapping(value="/list")
    public ModelAndView listGet(ModelAndView mv) {
    	ArrayList <BoardVO> list = boardService.getBoardList();  	
    	mv.addObject("list", list);    		
        mv.setViewName("/board/list");
        return mv;
    }
    
}
