package kr.green.study.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.green.study.vo.MemberVO;

public interface MemberDAO {

	//파람을 매개변수가 2개이상일때만 쓰고 1개일때는 생략해 볼 예정
	void insertMember(MemberVO user);

	MemberVO selectUser(String id);

	void keepLogin(@Param("id")String id, 
			@Param("session_id")String session_id, @Param("session_limit")Date session_limit);

	MemberVO selectUserBySession(String session_id);

	ArrayList<MemberVO> selectUserList(@Param("authority")String authority); 

}
