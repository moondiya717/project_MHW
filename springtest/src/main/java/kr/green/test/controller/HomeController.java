package kr.green.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	
	
	 //@GetMapping이 @RequestMapping대신 쓰면서 method = RequestMethod.GET 쓴거랑 같은 효과
	@GetMapping(value = "/")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("home");
		return mv;
	}
	
	@GetMapping(value = "/signin")
	public ModelAndView signinGet(ModelAndView mv) {
		mv.setViewName("signin");
		return mv;
	}
	@PostMapping(value = "/signin")
	public ModelAndView signinPOST(ModelAndView mv, MemberVO user) {
		MemberVO loginUser = memberService.signin(user);
		if(loginUser !=null) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/signin");
		}
		mv.addObject("user",loginUser);
		return mv;
		}

	@GetMapping(value = "/signup")
	public ModelAndView signupGet(ModelAndView mv) {
//		MemberVO user = new MemberVO(); //NullPointerException 알아본다고 추가한거라 지워야오류안남
//		System.out.println(user.getId().trim().length());
		mv.setViewName("signup");
		return mv;
	}
	/* 매개변수 user를 하면 객체가 생성된 후, 화면에서 전달한 name과 일치하는 뱐수명을 가진
	 * 멤버 변수의 setter를 이용하여 값을 재설정
	 * 일반적으로 매개변수는 객체를 자동으로 생성하는 건 아니다.*/	
	@PostMapping(value = "/signup")
	public ModelAndView signupPOST(ModelAndView mv,MemberVO user) {
		memberService.signup(user);
			mv.setViewName("redirect:/");
		return mv;
	}
	


}
