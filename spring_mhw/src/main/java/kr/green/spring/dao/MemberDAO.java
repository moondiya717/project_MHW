package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(@Param("id")String id);

	void signup(@Param("user")MemberVO user);

	int updateMember(@Param("user")MemberVO dbUser); 
	//Param과 매개변수 이름을 똑같이 맞춰줄 필요는 없음
	//Param을 붙이지 않으면 매개변수 Mapper.xml에서 user.pw 가 아니라 pw만 쓰면되는 격이지만,
	//멤버변수가 dbUser뒤에 여러개가 나열될 경우에는 Param이 없으면 인식을 못하게되는 문제가 있어서 
	//Param을 쓰고 앞에 객체명 붙여주는게 더 좋음
}
