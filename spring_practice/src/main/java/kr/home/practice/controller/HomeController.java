package kr.home.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.home.practice.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		
    @Autowired
    MemberService memberService;
    
    @RequestMapping(value="/")
    public ModelAndView home(ModelAndView mv) {
        mv.setViewName("/home");
        mv.addObject("home", "home");
        System.out.println(memberService.getEmail("art"));
        return mv;
    }
}
