package com.goott.pj3.board.review.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.goott.pj3.board.review.repo.ReviewDAO;

import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDAO;

	@Override
	public String create(Map<String, Object> map) {
		int cnt = this.reviewDAO.insert(map);
		if(cnt==1){
			return map.get("review_idx").toString();
		}
		return null;
	}

	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.reviewDAO.detail(map);
	}

	@Override
	public boolean update(Map<String, Object> map) {
		int affectRowCnt = this.reviewDAO.update(map);
		return affectRowCnt == 1;
	}

	@Override
	public boolean delete(Map<String, Object> map) {
		int affectRowCnt = this.reviewDAO.delete(map);
		return affectRowCnt==1;
	}

	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return this.reviewDAO.list(map);
	}
}
