package kr.green.study.service;

import org.springframework.stereotype.Service;

import kr.green.study.dao.ReplyDAO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImp implements ReplyService {
	private ReplyDAO replyDao;
}
