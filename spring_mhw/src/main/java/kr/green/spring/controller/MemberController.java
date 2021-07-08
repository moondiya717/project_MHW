package kr.green.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
	
	@RequestMapping(value = "/member/mypage", method = RequestMethod.GET)
	public ModelAndView memberMypageGet(ModelAndView mv, String id) {
		//서비스에게 아이디를 주면서 회원 정보를 가져오라고 시킴.
		MemberVO user = memberService.getMember(id);
		mv.addObject("user",user);
		mv.setViewName("/member/mypage");
		return mv;
	}
	@RequestMapping(value = "/member/mypage", method = RequestMethod.POST)
	public ModelAndView memberMypagePost(ModelAndView mv, MemberVO user) {	
//		System.out.println(user);
		//서비스에게 회원 정보를 주면서 수정하라고 요청
		memberService.updateMember(user);
		mv.setViewName("redirect:/member/mypage");
		return mv;
	}
}
