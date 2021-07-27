package kr.green.test.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle( //컨트롤러가기전에 자동로그인인지 아닌지 체크
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler)
	    throws Exception {
	    HttpSession session = request.getSession();
	    MemberVO user = (MemberVO)session.getAttribute("user");
	    if(user == null) {
	        Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
	        if(loginCookie !=null) {
	        	user = memberService.getMemberByCookie(loginCookie.getValue());//어차피 user가 null인 경우가 전제조건이라서 새로운 객체 만들어도되지만 user를 재사용 
	        	if(user!=null) {
	        		session.setAttribute("user", user);
	        	}
	        }
	    }
	    return true;
	}
}
