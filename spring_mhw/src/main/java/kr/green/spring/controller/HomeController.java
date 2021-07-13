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
public class HomeController {
    @Autowired
    MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {		
		mv.setViewName("home");

		return mv;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv) {		
		mv.setViewName("signin");
		return mv;
		}
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signinPost(ModelAndView mv, MemberVO user) {		
		
		//서비스에게 아이디와 비밀번호를 전달하면 
		//해당 정보가 DB에 있으면 회원정보를 반환, 없으면 null을 반환
		MemberVO dbUser = memberService.signin(user);
		//회원 정보가 있으면 => 로그인에 성공하면 
		if(dbUser != null) {
			//작업이 다 끝난 후 URI가 redirect:/ 주소로 이동 /만쓰면 /으로 감
			//redirect:내가원하는 URI => redirect는 다른 URI를 실행시킴
			mv.setViewName("redirect:/");
		// 회원정보가 없으면 => 일치하는 아이디가 없던지, 비밀번호가 잘못되던지 
		//				 =>로그인실패		
		}else {
			mv.setViewName("redirect:/signin");
		}
		mv.addObject("user",dbUser);
		return mv;
		}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {		
		mv.setViewName("signup");
		return mv;
		}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {		
		System.out.println(user);
		//서비스에게 회원 정보를 주면서 회원가입하라고 일을 시키고, 
		//회원가입이 성공하면 true, 실패하면 false를 알려달라고 요청
		boolean isSignup = memberService.signup(user);
		
		//회원가입에 성공하면 메인으로 실패하면 회원가입 페이지로 이동
		if(isSignup) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(ModelAndView mv, HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
		}
}
