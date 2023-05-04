package com.goott.pj3.board.free.service;

import java.util.List;

import com.goott.pj3.board.free.dto.FreeBoardDTO;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;

public interface FreeBoardService {

	void enroll(FreeBoardDTO freeDto);

	List<FreeBoardDTO> list(Criteria cri);
	
	PagingDTO paging(Criteria cri);

	int totalCount(Criteria cri);

	FreeBoardDTO detail(int free_idx);

	void delete(int free_idx);

	void modify(FreeBoardDTO boardDTO);


}
