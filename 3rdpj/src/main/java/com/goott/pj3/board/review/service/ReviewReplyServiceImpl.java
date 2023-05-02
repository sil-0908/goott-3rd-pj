package com.goott.pj3.board.review.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.goott.pj3.board.review.repo.ReviewReplyDAO;
import com.goott.pj3.common.util.reply.ReplyDTO;

@Service
public class ReviewReplyServiceImpl implements ReviewReplyService{

	@Inject
	ReviewReplyDAO reviewReplyDAO;
	
	@Override
	public void write(ReplyDTO dto) {
		reviewReplyDAO.write(dto);
	}

	@Override
	public List<ReplyDTO> getList(ReplyDTO dto) {
		return reviewReplyDAO.getList(dto);
	}

	@Override
	public void replyUpdate(ReplyDTO dto) {
		reviewReplyDAO.replyUpdate(dto);
	}

	@Override
	public void replyDelete(ReplyDTO dto) {
		reviewReplyDAO.replyDelete(dto);
	}
	
}

