package com.goott.pj3.board.free.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.goott.pj3.board.free.repo.FreeReplyDAO;
import com.goott.pj3.common.util.reply.ReplyDTO;

@Service
public class FreeReplyServiceImpl implements FreeReplyService{

	@Inject
	FreeReplyDAO freeReplyDAO;

	@Override
	public void write(ReplyDTO dto) {
		freeReplyDAO.write(dto);
	}

	@Override
	public List<ReplyDTO> getList(ReplyDTO dto) {
		return freeReplyDAO.getList(dto);
	}

	@Override
	public void replyUpdate(ReplyDTO dto) {
		freeReplyDAO.replyUpdate(dto);
	}

	@Override
	public void replyDelete(ReplyDTO dto) {
		freeReplyDAO.replyDelete(dto);
	}
}
