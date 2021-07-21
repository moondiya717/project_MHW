package kr.green.spring.service;

import org.springframework.stereotype.Service;

import kr.green.spring.dao.ReplyDAO;
import kr.green.spring.vo.ReplyVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImp implements ReplyService{
	private ReplyDAO replyDao;

	@Override
	public void insertReply(ReplyVO reply) {
		replyDao.insertReply(reply);
		
	}
	
}
