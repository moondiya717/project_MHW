package kr.home.practice.service;

import kr.home.practice.vo.MemberVO;

public interface MemberService {
	
    public String getEmail(String id);

	public boolean signup(MemberVO user);
}