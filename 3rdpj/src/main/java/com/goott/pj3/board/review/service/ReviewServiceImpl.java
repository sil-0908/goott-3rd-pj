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

	/**
	 * 조원재 23.04.05. 리뷰 생성 
	 * @param map
	 * @return
	 */
	@Override
	public String create(Map<String, Object> map) {
		int affectRowCnt = this.reviewDAO.insert(map); // 데이터 생성 성공 시 반환되는 값 : 1 (생성한 데이터 수 반환)
		if(affectRowCnt==1){
			return map.get("review_idx").toString();
		}
		return null;
	}
	/**
	 * 조원재 23.04.05. 리뷰 데이터 호출
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.reviewDAO.detail(map);
	}
	/**
	 * 조원재 23.04.05. 리뷰 수정
	 * @param map
	 * @return
	 */
	@Override
	public boolean update(Map<String, Object> map) {
		int affectRowCnt = this.reviewDAO.update(map); // 데이터 생성 성공 시 반환되는 값 : 1 (생성한 데이터 수 반환)
		return affectRowCnt == 1;
	}
	/**
	 * 조원재 23.04.05. 리뷰 삭제
	 * @param map
	 * @return
	 */
	@Override
	public boolean delete(Map<String, Object> map) {
		int affectRowCnt = this.reviewDAO.delete(map); // 데이터 생성 성공 시 반환되는 값 : 1 (생성한 데이터 수 반환)
		return affectRowCnt==1;
	}
	/**
	 * 조원재 23.04.05. 리뷰 목록 호출
	 * @param map
	 * @return
	 */

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
