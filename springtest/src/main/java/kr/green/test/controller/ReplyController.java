package kr.green.test.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.green.test.service.ReplyService;
import kr.green.test.vo.ReplyVO;
import lombok.AllArgsConstructor;

//@Controller // 화면이나 redirect,일반url 등으로 이동할 수 있게만드는 메소드 추가 가능.
@RestController	//실제 데이터를 리턴하도록되어있어서 일반url사용X, responseBody안붙여도 화면으로 데이터 전송가능
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService replyService; //1. @Autowired 2.@AllArgsConstructor 둘중하나해야됨
	
	@PostMapping("/reply/ins")
	public String replyInsPost(@RequestBody ReplyVO rvo) {
		return replyService.insertReply(rvo) == 0? "FAIL" : "SUCCESS";
	}
	
}
