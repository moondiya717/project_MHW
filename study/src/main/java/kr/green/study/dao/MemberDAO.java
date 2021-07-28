package kr.green.study.dao;

import kr.green.study.vo.MemberVO;

public interface MemberDAO {

	//파람을 매개변수가 2개이상일때만 쓰고 1개일때는 생략해 볼 예정
	void insertMember(MemberVO user);

	MemberVO selectUser(String id); 

}
