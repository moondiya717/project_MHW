package kr.green.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		mv.setViewName("/template/home");
		return mv;
	}
	
	
	@GetMapping(value = "/logout")
	public ModelAndView logout(ModelAndView mv, HttpServletRequest r) {
		r.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}

	
}
