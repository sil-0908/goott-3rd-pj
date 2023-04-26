package com.goott.pj3.board.free.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.board.free.dto.FreeBoardDTO;
import com.goott.pj3.common.util.paging.Criteria;

@Repository
public class FreeBoardDAO {

	@Autowired
	SqlSession ss;

	public void enroll(FreeBoardDTO freeDto) {
		ss.insert("free.insert",freeDto);
		
	}

	public List<FreeBoardDTO> list(Criteria cri) {
		return ss.selectList("free.list", cri);
	}

	public int totalCount(Criteria cri) { return ss.selectOne("free.totalCount", cri);}

	public FreeBoardDTO detail(int free_idx) {
		return ss.selectOne("free.detail", free_idx);
	}

	public void delete(int free_idx) {
		ss.update("free.delete", free_idx);
	}

	public void modify(FreeBoardDTO boardDTO) {
		ss.update("free.modify", boardDTO);
	}


}
