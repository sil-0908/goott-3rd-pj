package com.goott.pj3.board.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.pj3.board.free.dto.FreeBoardDTO;
import com.goott.pj3.board.free.repo.FreeBoardDAO;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	FreeBoardDAO freeBoardDAO;

	@Override
	public void enroll(FreeBoardDTO freeDto) {
		freeBoardDAO.enroll(freeDto);
	}

	@Override
	public List<FreeBoardDTO> list(Criteria cri) {
		return freeBoardDAO.list(cri);
	}

	@Override
	public PagingDTO paging(Criteria cri) {
		PagingDTO paging = new PagingDTO();
		paging.setCri(cri);
		paging.setTotalCount(freeBoardDAO.totalCount(cri));
		return paging;
	}
	
	@Override
	public int totalCount(Criteria cri) {
		return freeBoardDAO.totalCount(cri);
	}

	@Override
	public FreeBoardDTO detail(int free_idx) {
		return freeBoardDAO.detail(free_idx);
	}

	@Override
	public void delete(int free_idx) {
		freeBoardDAO.delete(free_idx);
	}
	
	@Override
	public void modify(FreeBoardDTO boardDTO) {
		freeBoardDAO.modify(boardDTO);
	}


	
}
