package kr.home.practice.dao;

import org.apache.ibatis.annotations.Param;

import kr.home.practice.vo.MemberVO;
 
public interface MemberDAO {
    public String getEmail(@Param("id")String id);

	public void signup(@Param("user")MemberVO user);

	public Object getMember(@Param("id")String id);
}
