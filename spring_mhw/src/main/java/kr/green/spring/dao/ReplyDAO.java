package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.ReplyVO;

public interface ReplyDAO {

	void insertReply(@Param("reply")ReplyVO reply);

}
