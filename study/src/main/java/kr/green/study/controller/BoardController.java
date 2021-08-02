package kr.green.study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.study.service.BoardService;
import kr.green.study.service.MemberService;
import kr.green.study.vo.BoardVO;
import kr.green.study.vo.FileVO;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private BoardService boardService;
	private MemberService memberService;
	
	@GetMapping("/list")
	public ModelAndView listGet(ModelAndView mv) {
		ArrayList<BoardVO> list = boardService.getBoardList();
		//System.out.println(list);
		mv.addObject("list", list);
		mv.setViewName("/template/board/list");
		return mv;
	}
	@GetMapping("/detail")
	public ModelAndView detailGet(ModelAndView mv, Integer num) {
		//System.out.println(num);
		boardService.updateViews(num); //게시글조회수 증가
		BoardVO board=boardService.getBoard(num);
		
		//첨부파일 가져오고 addObject로 화면에 보내주기
		ArrayList<FileVO> fList = boardService.getFileList(num);

		mv.addObject("board",board);
		mv.addObject("fList",fList);
		mv.setViewName("/template/board/detail");
		return mv;
	}
	@GetMapping("/register")
	public ModelAndView registerGet(ModelAndView mv) {
		mv.setViewName("/template/board/register");
		return mv;
	}
	@PostMapping("/register")
	public ModelAndView registerPost(ModelAndView mv, BoardVO board,
			MultipartFile []fileList, HttpServletRequest request) throws Exception { //첨부파일 매개변수 넣어서 전달까지 해있는상태
		//System.out.println(board);
//		for(MultipartFile tmp : fileList) {
//			if(tmp != null) {
//				System.out.println(tmp.getOriginalFilename());
//			}
//		}
		MemberVO user = memberService.getMemberByRequest(request);
		boardService.insertBoard(board,fileList,user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@GetMapping("/reply/register")
	public ModelAndView replyRegisterGet(ModelAndView mv, Integer oriNo) {
		mv.addObject("oriNo", oriNo);
		mv.setViewName("/template/board/replyregister");
		return mv;
	}
	@PostMapping("/reply/register")
	public ModelAndView replyRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		MemberVO user = memberService.getMemberByRequest(request);
		boardService.insertReplyBoard(board,user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@GetMapping("/modify")
	public ModelAndView modifayGet(ModelAndView mv, Integer num) {
//		System.out.println(num);
		BoardVO board = boardService.getBoard(num);
		ArrayList<FileVO> fList = boardService.getFileList(num);
		mv.addObject("board",board);
		mv.addObject("fList",fList);
		mv.setViewName("/template/board/modify");
		return mv;
	}
	@PostMapping("/modify")
	public ModelAndView modifyPost(ModelAndView mv, BoardVO board, HttpServletRequest request,
			MultipartFile[] fileList, Integer [] fileNumList) throws Exception {
		//System.out.println(board);
		MemberVO user = memberService.getMemberByRequest(request);
		boardService.updateBoard(board,user, fileList, fileNumList);
		mv.addObject("num",board.getNum());
		mv.setViewName("redirect:/board/detail");
		return mv;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteGet(ModelAndView mv, Integer num, HttpServletRequest request) {
		MemberVO user = memberService.getMemberByRequest(request);
		boardService.deleteBoard(num,user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@ResponseBody
	@GetMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    return boardService.downloadFile(fileName);
	}
}
