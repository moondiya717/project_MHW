package kr.green.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.BoardService;
import kr.green.test.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
//컨트롤러 밑에 @RequestMapping(value="/board/*")라고하면 아래는 /board를 생략해도되고, 모두 /board를 기본으로 갖고 시작함

public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value ="/board/list")
	public ModelAndView boardList(ModelAndView mv) {
		ArrayList<BoardVO> list= boardService.getBoardList();
		mv.addObject("list",list);
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping(value ="/board/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer num) {
		boardService.updateViews(num);
		
		BoardVO detail = boardService.getBoard(num);
		mv.addObject("detail",detail);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping(value ="/board/write", method = RequestMethod.GET)
	public ModelAndView boardWriteGet(ModelAndView mv) {					
		mv.setViewName("board/write");
		return mv;
	}
	@RequestMapping(value ="/board/write", method = RequestMethod.POST)
	public ModelAndView boardWritePost(ModelAndView mv, BoardVO board) {
		log.info(board);
		boardService.insertBoard(board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
}
