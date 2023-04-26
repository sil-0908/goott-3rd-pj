package com.goott.pj3.board.qna.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.goott.pj3.common.util.auth.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goott.pj3.board.qna.service.QnaReplyService;
import com.goott.pj3.common.util.reply.ReplyDTO;

@Controller
@RequestMapping("qnaReply/**")
public class QnaReplyController {

	@Autowired
	QnaReplyService qnaReplyService;

	@Auth(role = Auth.Role.ADMIN)
	@PostMapping("write")
	public String replyWrite(ReplyDTO dto, HttpSession session) {
		dto.setR_writer((String)session.getAttribute("user_id"));
		qnaReplyService.write(dto);
		return "redirect:/qna/detail/"+dto.getQna_idx();
	}
	
	@GetMapping("getList")
	@ResponseBody
	public List<ReplyDTO> getList(ReplyDTO dto){
		return qnaReplyService.getList(dto);
	}

	@Auth(role = Auth.Role.ADMIN)
	@PostMapping("update")
	@ResponseBody
	public String replyUpdate(ReplyDTO dto) {
		qnaReplyService.replyUpdate(dto);
		return "redirect:/qna/detail/"+dto.getQna_idx();
	}

	@Auth(role = Auth.Role.ADMIN)
	@PostMapping("delete")
	@ResponseBody
	public String replyDelete (ReplyDTO dto) {
		qnaReplyService.replyDelete(dto);
		return "redirect:/qna/detail/"+dto.getQna_idx();
	}
	
}
