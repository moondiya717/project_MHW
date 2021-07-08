package kr.green.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;


@Controller
public class HomeController {
    @Autowired
    MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {		
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView board(ModelAndView mv) {		
		mv.setViewName("board");
		return mv;
	}

	
}
