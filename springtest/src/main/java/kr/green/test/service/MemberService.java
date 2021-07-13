package kr.green.test.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.test.vo.MemberVO;

public interface MemberService {

	public MemberVO signin(MemberVO user);

	public void signup(MemberVO user);

	public MemberVO getMember(String id);

	public MemberVO getMember(HttpServletRequest r);
}
