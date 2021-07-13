package kr.green.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.MemberVO;
	 
public interface MemberDAO {
	public MemberVO signin(@Param("user")MemberVO user);

	public void signup(@Param("user")MemberVO user);

	public MemberVO getMember(@Param("id")String id);

	public void insertMember(MemberVO user);
}
