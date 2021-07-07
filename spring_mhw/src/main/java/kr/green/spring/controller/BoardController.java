package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list")
	public ModelAndView boardList(ModelAndView mv) {
		//서비스에게 모든 게시글들을 가져오라고 시킴
		ArrayList<BoardVO> list = boardService.getBoardList();
		//화면에 모든 게시글을 전송
		mv.addObject("list",list);
		if(list != null) {
			for(BoardVO tmp : list) {
				System.out.println(tmp);
			}
		}
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping(value="/board/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer num) { //Integer는 ?넘버가 없어도 실행, int는 ?넘버가 없으면 null값이라서 실행이안되고 에러가 남.
		System.out.println(num); //num가 잘 넘어오는지 확인할 것
		//서비스에게 번호를 주면서 게시글을 가져오라고 시킴 => 번호를 줄라면 매개변수를 이용해야함
		BoardVO board = boardService.getBoard(num);
		//가져온 게시글을 화면에 전달, 이름은 board로
		mv.addObject("board",board); //(왼쪽:화면에서 쓸이름, 오른쪽:실제데이터이름)
//		System.out.println(board); //화면에 출력하기 전에 제대로 가져왔는지 확인하기 위한 출력
		mv.setViewName("board/detail");
		return mv;
	}
}
