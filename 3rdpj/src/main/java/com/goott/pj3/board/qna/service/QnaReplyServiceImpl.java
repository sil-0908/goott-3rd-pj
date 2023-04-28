package com.goott.pj3.board.qna.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.goott.pj3.board.free.repo.FreeReplyDAO;
import com.goott.pj3.board.qna.repo.QnaReplyDAO;
import com.goott.pj3.common.util.reply.ReplyDTO;

@Service
public class QnaReplyServiceImpl implements QnaReplyService{

	@Inject
	QnaReplyDAO qnaReplyDAO;

	@Override
	public void write(ReplyDTO dto) {
		qnaReplyDAO.write(dto);
	}

	@Override
	public List<ReplyDTO> getList(ReplyDTO dto) {
		return qnaReplyDAO.getList(dto);
	}

	@Override
	public void replyUpdate(ReplyDTO dto) {
		qnaReplyDAO.replyUpdate(dto);
	}

	@Override
	public void replyDelete(ReplyDTO dto) {
		qnaReplyDAO.replyDelete(dto);
	}
}
