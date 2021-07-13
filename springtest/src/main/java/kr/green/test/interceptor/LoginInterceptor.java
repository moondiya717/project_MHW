package kr.green.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.test.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    //ModelMap modelMap = modelAndView.getModelMap();
	    //MemberVO user = (MemberVO)modelMap.get("user");
		//위에 주석처리된 코드를 한줄로 쓰면
		MemberVO user = (MemberVO)modelAndView.getModelMap().get("user"); //바꿔주기(실제로user라는클래스가있기때문에 문제가 생길 수도 있다고 함)
	    
	    System.out.println(user); //가져온정보가 null이면 세션에 정보를 저장
	    
	    if(user != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	    }
	}
}
