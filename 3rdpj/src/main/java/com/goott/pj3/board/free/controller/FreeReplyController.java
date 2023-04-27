package com.goott.pj3.board.free.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goott.pj3.board.free.service.FreeReplyService;
import com.goott.pj3.common.util.reply.ReplyDTO;

@Controller
@RequestMapping("freeReply/**")
public class FreeReplyController {

	@Autowired
	FreeReplyService freeReplyService;
	
	@PostMapping("write")
	public String replyWrite(ReplyDTO dto, HttpSession session) {
		dto.setR_writer((String)session.getAttribute("user_id"));
		freeReplyService.write(dto);
		return "redirect:/free/detail/"+dto.getFree_idx();
	}
	
	@GetMapping("getList")
	@ResponseBody
	public List<ReplyDTO> getList(ReplyDTO dto){
		return freeReplyService.getList(dto);
	}
	
	@PostMapping("update")
	@ResponseBody
	public String replyUpdate(ReplyDTO dto) {
		freeReplyService.replyUpdate(dto);
		return "redirect:/free/detail/"+dto.getFree_idx();
	}
	
	@PostMapping("delete")
	@ResponseBody
	public String replyDelete (ReplyDTO dto) {
		freeReplyService.replyDelete(dto);
		return "redirect:/free/detail/"+dto.getFree_idx();
	}
	
}
