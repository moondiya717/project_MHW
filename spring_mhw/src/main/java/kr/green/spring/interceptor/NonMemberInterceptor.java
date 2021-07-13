package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class NonMemberInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		//세션에있는 유저정보를 가져오기(유저정보가 있기만하면 됨=로그인 유/무만)
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user"); //설정한 이름에따라 ""을 넣음
		if(user != null) { //로그인한사람들은 메인으로가라(회원가입이랑 로그인으로 가지말고)
			response.sendRedirect(request.getContextPath()+"/");
			//false는 원래가려던 url로 갈 수 없게 함
			return false;
		}
		return true;
	}
}