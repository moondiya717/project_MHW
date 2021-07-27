package kr.green.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

//url에서 컨트롤러로 갔다가 로그인정보에 대해서 회원정보가 있는지 없는지 url에 다시 돌아가기 전에 확인함
public class LoginInterceptor extends HandlerInterceptorAdapter{ 

	@Autowired
	MemberService memberService;
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		//mv.addObject("user",)으로 정보를 전달한 내용이 있으면 가져오는 코드 
	    ModelMap modelMap = modelAndView.getModelMap(); 
	    MemberVO user = (MemberVO)modelMap.get("user"); //<- "user" 따옴표안에있는 내용을 addObject랑 맞춰야징

	    if(user != null) { //회원정보가 있으면
	    	//System.out.println(user.getUseCookie());
	    	//request에 있는 세션정보를 가져옴
	    	HttpSession session = request.getSession();

	    	//로그인 유지를 해야하는 상황
	    	if(user.getUseCookie() != null) {
	    		//쿠키생성
	    		Cookie loginCookie = new Cookie("loginCookie", session.getId());
	    		loginCookie.setPath("/");
	    		//쿠키 유지시간 (초단위)
	    		int day =7;
	    		int amount = 60*60*24*day;
	    		loginCookie.setMaxAge(amount); //7일동안 유지될 수 있도록 시간계산을 임의로했음(60.60.24-하루)
	    		response.addCookie(loginCookie);
	    		//현재 시간에서 유지시간을 더한 날짜를 구함(로그인 시간을 기준으로 7일 뒤)
	    		Date session_limit = new Date(System.currentTimeMillis() + (1000*amount)); //1000miliseconds * amount
	    		//System.out.println(session.getId());
	    		memberService.keeplogin(user.getId(), session.getId(), session_limit);
	    	}
	        //세션에 user라는 정보를 추가, 로그인유지하는 코드 //나중에 주석풀어야돼 기능추가테스트하고
	        session.setAttribute("user", user);
	    }
	}
}
