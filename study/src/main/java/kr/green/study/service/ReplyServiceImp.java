package kr.green.study.service;

import org.springframework.stereotype.Service;

import kr.green.study.dao.BoardDAO;
import kr.green.study.dao.ReplyDAO;
import kr.green.study.vo.BoardVO;
import kr.green.study.vo.MemberVO;
import kr.green.study.vo.ReplyVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImp implements ReplyService {
	private ReplyDAO replyDao;
	private BoardDAO boardDao;

	@Override
	public String insertReply(ReplyVO reply, MemberVO user) {
		if(reply == null || reply.getRp_bd_num() <=0 || user== null) {
			return "FAIL";
		}
		BoardVO board = boardDao.selectBoard(reply.getRp_bd_num()); //비정상적인 접근을 막기위해서 추가했음
		if(board == null || board.getType().equals("IMAGE")) {
			return "FAIL";
		}
		reply.setRp_me_id(user.getId()); //앞에서 게시글번호, 내용 받는거 봤으니까, DB에 필수인 유저만 입력해주면 됨
		replyDao.insertReply(reply);
		return "OK"; 
	}
}
