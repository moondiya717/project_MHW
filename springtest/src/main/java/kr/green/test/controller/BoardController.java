package kr.green.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
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
	public ModelAndView boardList(ModelAndView mv, Criteria cri) {
		PageMaker pm = new PageMaker();
		cri.setPerPageNum(2);
		pm.setCriteria(cri);
		pm.setDisplayPageNum(2);
		
		int totalCount = boardService.getTotalCount(cri);
		pm.setTotalCount(totalCount);
		pm.calcData(); //무슨데이터 계산?
		
		ArrayList<BoardVO> list= boardService.getBoardList(cri);
		//cri넣어준이유, type이랑 search도 같이 가지고있는게 좋으니까!
		mv.addObject("list",list);
		mv.addObject("pm",pm);
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
		boardService.insertBoard(board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@RequestMapping(value ="/board/edit", method = RequestMethod.GET)
	public ModelAndView boardEditGet(ModelAndView mv, Integer num) {
		log.info("/board/edit :" +num);
		BoardVO edit = boardService.getBoard(num);
		mv.addObject("edit",edit);
		mv.setViewName("board/edit");
		return mv;
	}
	@RequestMapping(value ="/board/edit", method = RequestMethod.POST) 
	public ModelAndView boardEditPost(ModelAndView mv, BoardVO board) {
		log.info("/board/modify:POST : " + board); //........?
		int res = boardService.updateBoard(board);
		String msg = res != 0? board.getNum()+ "번 게시글이 수정되었습니다." : "없는 게시글입니다.";
		mv.addObject("msg",msg);
		mv.addObject("num", board.getNum());
		mv.setViewName("redirect:/board/detail");
		return mv;
	}
	

	@RequestMapping(value ="/board/delete", method=RequestMethod.POST)
	public ModelAndView boardDelete(ModelAndView mv, Integer num) {
		log.info("/board/delete : "+ num);
		int res = boardService.deleteBoard(num);
		if(res != 0) {
			mv.addObject("msg",num+"번 게시글을 삭제했습니다."); //mv.addObject는 setViewName에게 보내는 것
		}else {
			mv.addObject("msg", "게시글이 없거나 이미 삭제되었습니다.");
		}
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
}
