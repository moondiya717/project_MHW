package kr.green.test.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.BoardService;
import kr.green.test.service.MemberService;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;
import kr.green.test.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
//컨트롤러 밑에 @RequestMapping(value="/board/*")라고하면 아래는 /board를 생략해도되고, 모두 /board를 기본으로 갖고 시작함

public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value ="/board/list")
	public ModelAndView boardList(ModelAndView mv, String msg, Criteria cri) {
		cri.setPerPageNum(2); //게시글을 가져오기전에 2개로 설정을 해두고 게시물을 가져오도록 해야 함 
		ArrayList<BoardVO> list= boardService.getBoardList(cri);
		//현재 페이지 정보(검색타입, 검색어)에 대한 총 게시글 수를 가져와야 함
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 2, cri);
		pm.setCriteria(cri);
		pm.setDisplayPageNum(2);
		pm.setTotalCount(totalCount);
		pm.calcData(); //무슨데이터 계산?	
		
		mv.addObject("list",list);
		mv.addObject("pm",pm);
		mv.addObject("msg",msg);
		mv.setViewName("/template/board/list");
		return mv;
	}
	
	@RequestMapping(value ="/board/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer num) {
		boardService.updateViews(num);
		BoardVO detail = boardService.getBoard(num);
		mv.addObject("detail",detail);
		
		ArrayList<FileVO> fileList = boardService.getFileList(num);
		mv.addObject("fileList",fileList);
		log.info(fileList);	
		mv.setViewName("/template/board/detail");
		return mv;
	}
	
	@RequestMapping(value ="/board/write", method = RequestMethod.GET)
	public ModelAndView boardWriteGet(ModelAndView mv) {					
		mv.setViewName("/template/board/write");
		return mv;
	}
	@RequestMapping(value ="/board/write", method = RequestMethod.POST)
	public ModelAndView boardWritePost(ModelAndView mv, BoardVO board, HttpServletRequest r, 
										MultipartFile [] files) {
		MemberVO user = memberService.getMember(r);
		boardService.insertBoard(board, user, files);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@RequestMapping(value ="/board/edit", method = RequestMethod.GET)
	public ModelAndView boardEditGet(ModelAndView mv, Integer num) {
		log.info("/board/edit :" +num);
		BoardVO edit = boardService.getBoard(num);
		mv.addObject("edit",edit);
		mv.setViewName("/template/board/edit");
		return mv;
	}
	@RequestMapping(value ="/board/edit", method = RequestMethod.POST) 
	public ModelAndView boardEditPost(ModelAndView mv, BoardVO board, HttpServletRequest r) {
		MemberVO user = memberService.getMember(r);
		int res = boardService.updateBoard(board,user);

		String msg="";
		mv.setViewName("redirect:/board/detail");
		if(res==1) {
			msg = board.getNum()+"번 게시글이 수정되었습니다."; 
		}else if(res == 0) {
			msg = "없는 게시글입니다.";
		}else if(res == -1) {
			msg = "잘못된 접근입니다.";
			mv.setViewName("redirect:/board/list");
		}
		mv.addObject("msg",msg);
		mv.addObject("num", board.getNum());
		return mv;
	}
	

	@RequestMapping(value ="/board/delete")
	public ModelAndView boardDelete(ModelAndView mv, Integer num, HttpServletRequest r) {
		MemberVO user = memberService.getMember(r);
		int res = boardService.deleteBoard(num, user);
		if(res == 1) {
			mv.addObject("msg",num+"번 게시글을 삭제했습니다."); //mv.addObject는 setViewName에게 보내는 것
		}else if(res == 0){
			mv.addObject("msg", "게시글이 없거나 이미 삭제되었습니다.");
		}else if(res==-1) {
			mv.addObject("msg", "잘못된 접근입니다.");	
		}			
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
		return boardService.downloadFile(fileName);

	}
}
