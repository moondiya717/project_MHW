package kr.green.study.service;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.green.study.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO user);

	MemberVO signin(MemberVO user);

	Object getMember(String id);

	void signout(HttpServletRequest request, HttpServletResponse response);

	void keepLogin(String id, String id2, Date date);

	MemberVO getMemberByCookie(String value);

	MemberVO getMemberByRequest(HttpServletRequest request);

	ArrayList<MemberVO> getMemberList(MemberVO user);

	//혹시 실패할 수도 있으니까 결과를 확인하기 위해서 리턴타입을 바꿨음
	boolean updateAuthority(MemberVO user, MemberVO loginUser);
}
