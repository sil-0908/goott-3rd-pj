package com.goott.pj3.board.qna.repo;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.goott.pj3.common.util.reply.ReplyDTO;

@Repository
public class QnaReplyDAO {

	@Inject
	SqlSession ss;

	public void write(ReplyDTO dto) {
		ss.insert("qna.replywrite",dto);
	}

	public List<ReplyDTO> getList(ReplyDTO dto) {
		return ss.selectList("qna.getList",dto);
	}

	public void replyUpdate(ReplyDTO dto) {
		ss.update("qna.replyupdate",dto);
	}

	public void replyDelete(ReplyDTO dto) {
		ss.update("qna.replydelete", dto);
	}
	
}
