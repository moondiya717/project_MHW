package kr.green.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@GetMapping(value="/member/mypage")
	public ModelAndView mypageGet(ModelAndView mv, String id){
		MemberVO mypage = memberService.getMember(id);
		mv.addObject("mypage", mypage); //정보를 뿌려주기(뿌릴필요없으면 안써도됨)
		mv.setViewName("member/mypage"); //화면이름붙여주기
		return mv;
	}
	@PostMapping(value="/member/mypage") //MemberVO는 화면상입력된 user
	public ModelAndView mypagePost(ModelAndView mv, MemberVO user, HttpServletRequest r) {
		//user는 화면에서 보내온 회원 정보, sessionUser는 세션에 저장된 회원 정보
		//사용자가 악의적으로 화면에서 회원 아이디를 수정후, 회원 정보를 변경하려고 요청할 때
		//회원정보가 바뀌면 안됨.
		//request에 있는 세션 안에 있는 로그인한 회원 정보를 가져옴
		
		//user: 화면에서 보낸 회원 정보, 정상적이라면 바로 수정해도 되지만,
		//		개발자도구를 이용하여 잘못된 정보를 보낼 수 있기 때문에 바로 수정하면 안됨
		//sUser : 현재 로그인된 회원 정보
		//uUser : 업데이트 된 회원 정보로 user의 아이디와 sUser의 아이디가 일치하지 않으면 null,
		//		  일치하면 업데이트된 회원 정보
		MemberVO sUser = memberService.getMember(r);
		MemberVO uUser = memberService.updateMember(user, sUser);
		if(uUser != null) {
			r.getSession().setAttribute("user", uUser);
		}
			mv.setViewName("redirect:/member/mypage");
			return mv;
		
	
	}

}
