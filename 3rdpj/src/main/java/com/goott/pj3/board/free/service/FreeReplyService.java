package com.goott.pj3.board.free.service;

import java.util.List;

import com.goott.pj3.common.util.reply.ReplyDTO;

public interface FreeReplyService {

	void write(ReplyDTO dto);

	List<ReplyDTO> getList(ReplyDTO dto);

	void replyUpdate(ReplyDTO dto);

	void replyDelete(ReplyDTO dto);

}
