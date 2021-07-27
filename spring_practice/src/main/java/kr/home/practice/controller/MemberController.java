package kr.home.practice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.home.practice.service.MemberService;
import kr.home.practice.vo.MemberVO;


@Controller
@RequestMapping(value="/member/*")
public class MemberController {
		
    @Autowired
    MemberService memberService;
    
    @GetMapping(value="/signup")
    public ModelAndView signupGet(ModelAndView mv) {
        mv.setViewName("/member/signup");
        return mv;
    }
    @PostMapping(value="/signup")
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
    
    @GetMapping(value="/signin")
    public ModelAndView signinGet(ModelAndView mv) {
    	mv.setViewName("/member/signin");	
    	return mv;
    }
    @PostMapping(value="/signin")
    public ModelAndView signinPost(ModelAndView mv, MemberVO user) {  	
    	//System.out.println(user);
    	MemberVO dbUser = memberService.signin(user); //signin메소드로 user값 넣었을때 나오는 값을 dbUser에 저장
    	if(dbUser != null) {
    		mv.setViewName("redirect:/");	    		
    	}else {
    		mv.setViewName("redirect:/member/signin");
    	}    	
    	return mv;
    }
    
    @GetMapping(value="/mypage")
    public ModelAndView mypageGet(ModelAndView mv, String id) {
    	MemberVO user = memberService.getMember(id);
    	mv.addObject("user", user);
        mv.setViewName("/member/mypage");
    	return mv;
    }
    @PostMapping(value="/mypage") //request에서하는건 로그인이유지된 상태라서, getByID뭐이런거 사용해서 해야한대
    public ModelAndView mypagePost(ModelAndView mv, MemberVO user, HttpServletRequest request) {    		
        MemberVO sessionUserInfo = memberService.getMember(request);
        if(sessionUserInfo != null || sessionUserInfo.getId().equals(user.getId())) {
        	MemberVO updateUser = memberService.updateMember(user);
        	if(updateUser !=null) {
        		request.getSession().setAttribute("user",updateUser);
        	}
        }
    	mv.setViewName("redirect:/member/mypage");
    	return mv;
    }
}
