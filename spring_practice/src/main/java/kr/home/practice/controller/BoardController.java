package kr.home.practice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.home.practice.service.BoardService;
import kr.home.practice.vo.BoardVO;

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
    
    @GetMapping(value="/detail")
    public ModelAndView detailGet(ModelAndView mv, Integer num) {
    	BoardVO detail = boardService.getBoardDetail(num);
    	mv.addObject("detail", detail);    		
        mv.setViewName("/board/detail");
        return mv;
    }
    
    @GetMapping(value="/register")
    public ModelAndView registerGet(ModelAndView mv) {
        mv.setViewName("/board/register");
        return mv;
    }
    @PostMapping(value="/register")
    public ModelAndView registerPost(ModelAndView mv, BoardVO board) {
    	boardService.registerBoard(board);    	
    	mv.setViewName("redirect:/board/list");    		
        return mv;
    }
}
