package kr.green.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.study.pagination.Criteria;
import kr.green.study.pagination.PageMaker;
import kr.green.study.service.MemberService;
import kr.green.study.service.ReplyService;
import kr.green.study.vo.MemberVO;
import kr.green.study.vo.ReplyVO;
import lombok.AllArgsConstructor;

//resController인 이유 : ajax로 모든걸 처리하려고
@RestController
@AllArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
	private ReplyService replyService;
	private MemberService memberService;
	
	@PostMapping("/add")
	public String addPost(@RequestBody ReplyVO reply, HttpServletRequest request) {
//		System.out.println(reply);
		MemberVO user = memberService.getMemberByRequest(request);
//		return reply.toString();
		return replyService.insertReply(reply,user);
	}
	@GetMapping("/list/{page}/{rp_bd_num}")
	public Map<String, Object> listGet(
		@PathVariable("page") int page, @PathVariable("rp_bd_num") int rp_bd_num){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Criteria cri = new Criteria(page, 5); //댓글 5개씩
		ArrayList<ReplyVO> list = replyService.getReplyList(rp_bd_num, cri);
		int totalCount = replyService.getTotalCount(rp_bd_num);
		map.put("list", list);
		map.put("pm", new PageMaker(totalCount, 5, cri));
		return map;
	}
	
	@PostMapping("/mod") //@RequestBody를쓰면 화면에서 json형식으로 보내야함
	public String modPost(@RequestBody ReplyVO reply, HttpServletRequest request) {
		MemberVO user = memberService.getMemberByRequest(request);
		return replyService.modifyReply(reply,user);
	}
	
	@PostMapping("/del") //@RequestBody를쓰면 화면에서 json형식이 아니니까 넣으면 에러남
	public String delPost(Integer rp_num, HttpServletRequest request) {
		MemberVO user = memberService.getMemberByRequest(request);
		return replyService.deleteReply(rp_num,user);
	}
}
