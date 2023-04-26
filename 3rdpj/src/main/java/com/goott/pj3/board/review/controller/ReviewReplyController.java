package com.goott.pj3.board.review.controller;

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
import com.goott.pj3.board.review.service.ReviewReplyService;
import com.goott.pj3.common.util.ReplyDTO;

@Controller
@RequestMapping("ReviewReply/**")
public class ReviewReplyController {

	@Autowired
	ReviewReplyService reviewReplyService;
	
	@PostMapping("write")
	public String replyWrite(ReplyDTO dto, HttpSession session) {
		dto.setR_writer((String)session.getAttribute("user_id"));
		reviewReplyService.write(dto);
		return "redirect:/review/detail/"+dto.getReview_idx();
	}
	
	@GetMapping("getList")
	@ResponseBody
	public List<ReplyDTO> getList(ReplyDTO dto){
		return reviewReplyService.getList(dto);
	}
	
	@PostMapping("update")
	@ResponseBody
	public String replyUpdate(ReplyDTO dto) {
		reviewReplyService.replyUpdate(dto);
		return "redirect:/review/detail/"+dto.getReview_idx();
	}
	
	@PostMapping("delete")
	@ResponseBody
	public String replyDelete (ReplyDTO dto) {
		reviewReplyService.replyDelete(dto);
		return "redirect:/review/detail/"+dto.getReview_idx();
	}
	
}
