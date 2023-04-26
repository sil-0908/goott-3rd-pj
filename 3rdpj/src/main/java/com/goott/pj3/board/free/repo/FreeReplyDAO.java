package com.goott.pj3.board.free.repo;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.goott.pj3.common.util.ReplyDTO;

@Repository
public class FreeReplyDAO {

	@Inject
	SqlSession ss;

	public void write(ReplyDTO dto) {
		ss.insert("free.replywrite",dto);
	}

	public List<ReplyDTO> getList(ReplyDTO dto) {
		return ss.selectList("free.getList",dto);
	}

	public void replyUpdate(ReplyDTO dto) {
		ss.update("free.replyupdate",dto);
	}

	public void replyDelete(ReplyDTO dto) {
		ss.update("free.replydelete", dto);
	}
	
}
