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
		mv.addObject("list",list);
		mv.setViewName("board/list");
		return mv;
	}

	@RequestMapping(value = "/board/detail")
	public ModelAndView getDetail(ModelAndView mv, Integer num) {
		BoardVO detail = boardService.getDetail(num);
		mv.addObject("detail",detail);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping(value = "/board/delete")
	public ModelAndView boardDelete(ModelAndView mv, Integer num) {
		BoardVO delete = boardService.boardDelete(num);
		mv.addObject("delete",delete);
		mv.setViewName("board/delte");
		return mv;
	}
}
