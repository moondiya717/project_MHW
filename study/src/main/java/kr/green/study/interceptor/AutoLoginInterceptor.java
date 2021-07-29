package kr.green.study.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.green.study.service.MemberService;
import kr.green.study.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception{
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user"); //LoginInterceptor파일에 ""안에있던 이름을 따라야함
		
		//세션에 회원정보가 있으면 자동 로그인 기능을 활용할 필요가 없음, 
		//세션에 회원정보가 없으면 자동 로그인을 해야하는지 확인해야 함 
		if(user == null) {
			//loginCookie 정보를 가져와서 정보가 있으면 자동로그인을 시도하고, 없으면 안함
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) { //자동로그인을 설정했을 때(=자동로그인쿠기정보가있는상태), 자동로그인 해야 함
				user = memberService.getMemberByCookie(loginCookie.getValue());
				if(user != null) {
					session.setAttribute("user", user);
				}
			}
		}
		return true;
	}
}
