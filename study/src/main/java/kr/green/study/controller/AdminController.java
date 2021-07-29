package kr.green.study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.green.study.service.MemberService;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
	
	MemberService memberService;
	
	@GetMapping("/user/list")
	public ModelAndView testGet(ModelAndView mv, HttpServletRequest request) {
		MemberVO user = memberService.getMemberByRequest(request);
		//내 등급보다 낮은 admin의 회원정보를 가져와야 함
		ArrayList<MemberVO> list = memberService.getMemberList(user);
		mv.addObject("list",list);
		mv.setViewName("/template/admin/user/list");
		return mv;
	}
}
