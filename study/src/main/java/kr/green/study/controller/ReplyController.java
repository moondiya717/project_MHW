package kr.green.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.study.service.ReplyService;
import lombok.AllArgsConstructor;

//resController인 이유 : ajax로 모든걸 처리하려고
@RestController
@AllArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
	private ReplyService replyService;
	
}
