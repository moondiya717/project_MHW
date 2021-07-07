package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/board/register", method=RequestMethod.GET) //등록화면은 GET으로 가져와서, 화면처리는 POST. URI가 너무 길어짐을 방지
	public ModelAndView boardRegisterGet(ModelAndView mv) {		
		mv.setViewName("board/register");
		return mv;
	}
	//화면에서 보내준 제목, 작성자, 내용을 받아서 콘솔에 출력
	@RequestMapping(value="/board/register", method=RequestMethod.POST) //화면처리는 POST. URI가 너무 길어짐을 방지
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board) {
//		System.out.println(board); //화면에 BoardVO로 입력한 내용이 콘솔에 잘 들어오는 걸 확인했음
		//서비스에게 게시글 정보(제목, 작성자, 내용)을 주면서 게시글을 등록하라고 시킴
		boardService.insertBoard(board);
		mv.setViewName("redirect:/board/list"); //등록끝나면 main화면으로 바로 이동시키는 redirect:
		return mv;
	}
}
