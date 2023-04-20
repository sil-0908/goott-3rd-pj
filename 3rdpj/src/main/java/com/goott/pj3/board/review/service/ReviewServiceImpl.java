package com.goott.pj3.board.review.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.board.review.repo.ReviewDAO;
import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;

import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDAO;

	@Override
	public int create(ReviewDTO reviewDTO) {
		int affectRowCnt =  this.reviewDAO.create(reviewDTO);
		if(affectRowCnt==1){
			return reviewDTO.getPlan_idx();
		}
		return 0;
	}
	@Override
	public void createFile(List<String> files) {
		this.reviewDAO.createFile(files);
	}

	@Override
	public ReviewDTO detail(ReviewDTO reviewDTO) {
		return this.reviewDAO.detail(reviewDTO);
	}

	@Override
	public boolean update(ReviewDTO reviewDTO) {
		int cnt = this.reviewDAO.update(reviewDTO);
		return cnt==1;
	}

	@Override
	public boolean delete(ReviewDTO reviewDTO) {
		int cnt = this.reviewDAO.delete(reviewDTO);
		return cnt==1;
	}

	@Override
	public List<ReviewDTO> list(Criteria cri) {
		return reviewDAO.list(cri);
	}

	@Override
	public PagingDTO paging(Criteria cri) {
		PagingDTO paging = new PagingDTO();
		paging.setCri(cri);
		paging.setTotalCount(reviewDAO.totalCount(cri));
		return paging;
	}
}
