package kr.green.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.service.MemberService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/board/list")
	public ModelAndView boardList(ModelAndView mv, Criteria cri) {
		PageMaker pm = new PageMaker();
		cri.setPerPageNum(5); // 한 페이지에 콘텐츠가 2개씩 있도록 
		pm.setCriteria(cri);
		pm.setDisplayPageNum(2); //페이지네이션에 페이지숫자가 2개씩 보이도록
		
		int totalCount = boardService.getTotalCount(cri);
		pm.setTotalCount(totalCount);
		
		pm.calcData();
		//서비스에게 모든 게시글들을 가져오라고 시킴
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		//화면에 모든 게시글을 전송
		mv.addObject("list",list);
		mv.addObject("pm",pm);
		
//		if(list != null) { //리스트가 제대로 값이 전달되는지 확인하기 위한것
//			for(BoardVO tmp : list) {
//				System.out.println(tmp);
//			}
//		}
		mv.setViewName("/template/board/list");
		return mv;
	}
	
	@RequestMapping(value="/board/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer num) { //Integer는 ?넘버가 없어도 실행, int는 ?넘버가 없으면 null값이라서 실행이안되고 에러가 남.
		//게시글을 가져오기 전 조회수를 증가
		//서비스에게 게시글 번호를 주면서 게시글 조회수를 +1증가시키라고 시킴
		boardService.updateViews(num);
		log.info(num);
//		System.out.println(num); //num가 잘 넘어오는지 확인할 것
		//서비스에게 번호를 주면서 게시글을 가져오라고 시킴 => 번호를 줄라면 매개변수를 이용해야함
		BoardVO board = boardService.getBoard(num);
		//가져온 게시글을 화면에 전달, 이름은 board로
		mv.addObject("board",board); //(왼쪽:화면에서 쓸이름, 오른쪽:실제데이터이름)
//		System.out.println(board); //화면에 출력하기 전에 제대로 가져왔는지 확인하기 위한 출력
		mv.setViewName("/template/board/detail");
		return mv;
	}
	
	@RequestMapping(value="/board/register", method=RequestMethod.GET) //등록화면은 GET으로 가져와서, 화면처리는 POST. URI가 너무 길어짐을 방지
	public ModelAndView boardRegisterGet(ModelAndView mv) {		
		mv.setViewName("/template/board/register");
		return mv;
	}
	//화면에서 보내준 제목, 작성자, 내용을 받아서 콘솔에 출력
	@RequestMapping(value="/board/register", method=RequestMethod.POST) //화면처리는 POST. URI가 너무 길어짐을 방지
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		MemberVO user = memberService.getMember(request);
		board.setWriter(user.getId());
//		System.out.println(board); //화면에 BoardVO로 입력한 내용이 콘솔에 잘 들어오는 걸 확인했음
		//서비스에게 게시글 정보(제목, 작성자, 내용)을 주면서 게시글을 등록하라고 시킴
		boardService.insertBoard(board);
		mv.setViewName("redirect:/board/list"); //등록끝나면 main화면으로 바로 이동시키는 redirect:
		return mv;
	}
	
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num, HttpServletRequest request) {		
		BoardVO board = boardService.getBoard(num);
		
		mv.addObject("board",board);
		mv.setViewName("/template/board/modify");
		MemberVO user = memberService.getMember(request);
		if(board != null || board.getWriter().equals(user.getId())) {
			mv.setViewName("redirect:/board/list");
		}
		return mv;
	}
	@RequestMapping(value="/board/modify", method=RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board,HttpServletRequest request) {						
		// detail로 이동			
		mv.addObject("num", board.getNum()); //detail로 넘어가기전에 게시글번호를 같이 가지고 가게 함
		mv.setViewName("redirect:/board/detail");
		
		MemberVO user = memberService.getMember(request);
		if(!user.getId().equals(board.getWriter())) {
			mv.setViewName("redirect:/board/list");
		}else {
			//서비스에게 게시글을 주면서 수정하라고 요청
			boardService.updateBoard(board);
		}
		return mv;
	}
	
	@RequestMapping(value="/board/delete")
	public ModelAndView boardDeleteGet(ModelAndView mv, Integer num,HttpServletRequest request) {
		MemberVO user = memberService.getMember(request);

		//서비스에게 게시글 번호를 주면서 삭제하라고 요청
		boardService.deleteBoard(num, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}
