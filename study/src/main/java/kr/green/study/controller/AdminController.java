package kr.green.study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.study.pagination.Criteria;
import kr.green.study.pagination.PageMaker;
import kr.green.study.service.MemberService;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
	
	MemberService memberService;
	
	@GetMapping("/user/list")
	public ModelAndView userListGet(ModelAndView mv, HttpServletRequest request, Criteria cri) {
		MemberVO user = memberService.getMemberByRequest(request);
		cri.setPerPageNum(1);
		ArrayList<MemberVO> list = memberService.getMemberList(user, cri);
		
		int totalCount =3;
		PageMaker pm = new PageMaker(totalCount, 5, cri); //(?, 5씩한페이지, 페이지정보)
		
		//System.out.println(pm);
		
		mv.addObject("list",list);
		mv.addObject("pm",pm);
		mv.setViewName("/template/admin/user/list");
		return mv;
	}
	//ajax는 메소드쓸때 responsebody꼭 써줘야함
	@ResponseBody
	@PostMapping("/user/mod") //혹시라도 잘못된 접근을 할 수 있을까바 request추가해줬음
	public String userModePost(@RequestBody MemberVO user, HttpServletRequest request){
		MemberVO loginUser = memberService.getMemberByRequest(request);
		
		return memberService.updateAuthority(user, loginUser)? "OK" : "FAIL";
	}
}
