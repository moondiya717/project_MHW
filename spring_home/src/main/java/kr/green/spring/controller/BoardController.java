package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {
    @Autowired
    BoardService boardService;
	
	@RequestMapping(value = "/board/list")
	public ModelAndView getBoard(ModelAndView mv) {		
		ArrayList<BoardVO> list = boardService.getBoardList();
		log.info(list);
		mv.addObject("list",list);
		mv.setViewName("board/list");
		return mv;
	}

	
}
