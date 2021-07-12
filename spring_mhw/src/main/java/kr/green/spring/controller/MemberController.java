package kr.green.spring.controller;

import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView memberMypageGet(ModelAndView mv) {
		//서비스에게 아이디를 주면서 회원 정보를 가져오라고 시킴.
		
		mv.setViewName("/member/mypage");
		return mv;
	}
	@RequestMapping(value = "/member/mypage", method = RequestMethod.POST)
	public ModelAndView memberMypagePost(ModelAndView mv, MemberVO user, HttpServletRequest request) {
		//request에 있는 세션 안에 있는 로그인한 회원 정보를 가져옴
		MemberVO sessionUser = memberService.getMember(request);
		//세션에 로그인한 회원 정보가 있고, 세션에 있는 아이디와 수정할 아이디가 같으면 회원 정보 수정함
		//개발자도구를 열어서 직접 회원정보를 수정하는 것을 막아주는 역할을 함
		if(sessionUser != null && sessionUser.getId().equals(user.getId())) {
		MemberVO updateUser = memberService.updateMember(user);
			if(updateUser !=null) {
				request.getSession().setAttribute("user", updateUser);
			}
		}
		mv.setViewName("redirect:/member/mypage");
		return mv;
	}
}
