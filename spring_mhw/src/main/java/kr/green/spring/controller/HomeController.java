package kr.green.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import lombok.Data;

@Controller
public class HomeController {
    @Autowired
    MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {		
		mv.setViewName("home");
		mv.addObject("name","몬스터주식회사");
        System.out.println(memberService.getMember("abc123"));
		return mv;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv, UserVo user,
			@RequestParam("hobby") String[] hobby) {		
		mv.setViewName("signin");
		System.out.println("id : " + user.getId());
		System.out.println("pw : " + user.getPw());
		for(String tmp : hobby) {
		System.out.println("취미: " + tmp);
		}

		return mv;
	}
    
    @RequestMapping(value="/")
    public ModelAndView main(ModelAndView mv) throws Exception{
        mv.setViewName("/main/home");
        mv.addObject("setHeader", "타일즈테스트");
        System.out.println(memberService.getEmail("12345678"));
        return mv;
    }

}
@Data
class UserVo{
	private String id;
	private String pw;	
}
