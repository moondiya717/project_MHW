package kr.green.spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.green.spring.service.ReplyService;
import kr.green.spring.vo.ReplyVO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReplyController {

	private ReplyService replyService;
	
	@PostMapping(value="/reply/ins")	
	public String test(@RequestBody ReplyVO reply) {
		replyService.insertReply(reply);
		return "ok";
	}
}
