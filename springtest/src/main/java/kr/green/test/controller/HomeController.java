package kr.green.test.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	
	
	 //@GetMapping이 @RequestMapping대신 쓰면서 method = RequestMethod.GET 쓴거랑 같은 효과
	@GetMapping(value = "/")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("/template/home");
		return mv;
	}
		
	@GetMapping(value = "/logout")
	public ModelAndView logout(ModelAndView mv,
			HttpServletRequest rq,
			HttpServletResponse rp) {
		MemberVO user = memberService.getMember(rq);
		rq.getSession().removeAttribute("user");
		rq.getSession().invalidate();
		Cookie loginCookie = WebUtils.getCookie(rq, "loginCookie");
		if(loginCookie != null) {
			loginCookie.setPath("/");
			loginCookie.setMaxAge(0);
			rp.addCookie(loginCookie);
	
			memberService.keepLogin(user.getId(), "none", new Date());		
		}		
		mv.setViewName("redirect:/");
		return mv;
	}	
}
