package com.goott.pj3.board.review.repo;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.goott.pj3.common.util.ReplyDTO;

@Repository
public class ReviewReplyDAO {

	@Inject
	SqlSession ss;

	public void write(ReplyDTO dto) {
		ss.insert("review.replywrite",dto);
	}

	public List<ReplyDTO> getList(ReplyDTO dto) {
		return ss.selectList("review.getList",dto);
	}

	public void replyUpdate(ReplyDTO dto) {
		ss.update("review.replyupdate",dto);
	}

	public void replyDelete(ReplyDTO dto) {
		ss.update("review.replydelete", dto);
	}
}
