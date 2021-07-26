package kr.green.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.ReplyVO;

public interface ReplyDAO {

	void insertReply(@Param("rvo")ReplyVO rvo);

	ArrayList<ReplyVO> getReplyList(@Param("rp_bd_num")int rp_bd_num, @Param("cri")Criteria cri);

	int getTotalCount(@Param("rp_bd_num")int rp_bd_num);

	ReplyVO getReply(@Param("rp_num")int rp_num);

	int updateReply(@Param("reply")ReplyVO dbReply); //오른쪽에 매개변수이름이랑 꼭 같을 필요없음, param에있는 이름기억해서 그걸로 mapper에서 사용하는 것 뿐

}
