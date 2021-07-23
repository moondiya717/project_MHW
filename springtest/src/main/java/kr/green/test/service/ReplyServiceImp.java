package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kr.green.test.dao.ReplyDAO;
import kr.green.test.vo.ReplyVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImp implements ReplyService{
	private ReplyDAO replyDao;

	@Override
	public int insertReply(ReplyVO rvo) {
		if(rvo.getRp_me_id() == null || rvo.getRp_me_id().length() == 0) {
			return 0;
		}
		replyDao.insertReply(rvo);
		return 1;
	}

	@Override
	public ArrayList<ReplyVO> getReplyList(int rp_bd_num) {		
		return replyDao.getReplyList(rp_bd_num);
	}
}
