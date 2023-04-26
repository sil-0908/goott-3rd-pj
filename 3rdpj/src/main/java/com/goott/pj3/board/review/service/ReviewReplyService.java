package com.goott.pj3.board.review.service;

import java.util.List;

import com.goott.pj3.common.util.reply.ReplyDTO;

public interface ReviewReplyService {

	void write(ReplyDTO dto);

	List<ReplyDTO> getList(ReplyDTO dto);

	void replyUpdate(ReplyDTO dto);

	void replyDelete(ReplyDTO dto);
}
