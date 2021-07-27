package kr.green.test.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	MemberService memberService;
	
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
	    
	    if(user != null) { //회원정보가 있고
	    	//System.out.println(user.getUseCookie()); //가져온정보가 null이면 세션에 정보를 저장
	        HttpSession session = request.getSession();
	        
	        if(user.getUseCookie() != null) {
	        	Cookie loginCookie = new Cookie("loginCookie", session.getId());
	        	int amount = 60*60*24*7;
	        	loginCookie.setPath("/");
	        	loginCookie.setMaxAge(60*60*24*7); //60초 60번(=한시간) 24시간 7일
	        	response.addCookie(loginCookie);
	        	memberService.keepLogin(user.getId(), session.getId(), 
	        			new Date(System.currentTimeMillis() + amount * 1000));
	        }
	        session.setAttribute("user", user);
	    }
	}
}
