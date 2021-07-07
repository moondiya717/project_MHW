package kr.green.spring.service;

import kr.green.spring.vo.*;

public interface MemberService {

	public MemberVO signin(MemberVO user);
	public boolean signup(MemberVO user);
	public MemberVO getMember(String id);
}
