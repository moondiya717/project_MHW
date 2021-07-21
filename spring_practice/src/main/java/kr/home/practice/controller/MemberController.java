package kr.home.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.home.practice.service.MemberService;
import kr.home.practice.vo.MemberVO;


@Controller
public class MemberController {
		
    @Autowired
    MemberService memberService;
    
    @GetMapping(value="/member/signup")
    public ModelAndView signupGet(ModelAndView mv) {
        mv.setViewName("/member/signup");
        return mv;
    }
    @PostMapping(value="/member/signup")
    public ModelAndView signupPost(ModelAndView mv, MemberVO user) {
        System.out.println(user);
        boolean isSignup = memberService.signup(user);
        if(isSignup) {
        	mv.setViewName("redirect:/");        	
        }else {
        	mv.setViewName("redirect:/member/signup");
        }
        return mv;
    }
    
}
