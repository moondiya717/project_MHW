package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.MemberVO;

//url에서 컨트롤러로 갔다가 로그인정보에 대해서 회원정보가 있는지 없는지 url에 다시 돌아가기 전에 확인함
public class LoginInterceptor extends HandlerInterceptorAdapter{ 

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
	    	//request에 있는 세션정보를 가져옴
	        HttpSession session = request.getSession();
	        //세션에 user라는 정보를 추가
	        session.setAttribute("user", user);
	    }
	}
}
