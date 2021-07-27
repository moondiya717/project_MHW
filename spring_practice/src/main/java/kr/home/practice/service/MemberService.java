package kr.home.practice.service;

import javax.servlet.http.HttpServletRequest;

import kr.home.practice.vo.MemberVO;

public interface MemberService {
	
    public String getEmail(String id);

	public boolean signup(MemberVO user);

	public MemberVO signin(MemberVO user);

	public MemberVO getMember(String id);

	public MemberVO getMember(HttpServletRequest request);

	public MemberVO updateMember(MemberVO user);

}