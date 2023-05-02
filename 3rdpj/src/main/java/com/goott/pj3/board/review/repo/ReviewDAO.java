package com.goott.pj3.board.review.repo;

import com.goott.pj3.plan.dto.PlanDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.common.util.paging.Criteria;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ReviewDAO {

	@Autowired
	SqlSession ss;

	public int create(ReviewDTO reviewDTO) {
		return this.ss.insert("review.insert", reviewDTO);
	}

	public void createImg(ReviewDTO reviewDTO) {
		System.out.println("files : " + reviewDTO);
		this.ss.insert("review.insertFile", reviewDTO);
	}

	public ReviewDTO detail(ReviewDTO reviewDTO) {
		return this.ss.selectOne("review.detail", reviewDTO);
	}

	public int update(ReviewDTO reviewDTO) {
		return this.ss.update("review.update", reviewDTO);
	}

	public void deleteImg(ReviewDTO reviewDTO) {
		this.ss.delete("review.deleteImg", reviewDTO);
	}

	public void updateImg(ReviewDTO reviewDTO) {
		this.ss.update("review.updateImg", reviewDTO);
	}

	public int delete(ReviewDTO reviewDTO) {
		return this.ss.update("review.delete", reviewDTO);
	}

	public List<ReviewDTO> list(Criteria cri) {
		return this.ss.selectList("review.list", cri);
	}

	public int totalCount(Criteria cri) {
		return this.ss.selectOne("review.totalCount",cri);
	}

	public List<ReviewDTO> imgList(ReviewDTO reviewDTO) {
		return this.ss.selectList("review.imglist", reviewDTO);
	}

	public void updateDeleteImg(ReviewDTO reviewDTO) {
		this.ss.update("review.updateDeleteImg", reviewDTO);
	}

	public PlanDTO getCreate(PlanDTO planDTO) {
		return this.ss.selectOne("review.getCreate", planDTO);
	}
 	// 기존 점수 가져오기
	public int rating(Map<String, Object> map) {
		return this.ss.selectOne("review.rating", map);
	}
	// 평점 매긴 인원 카운팅 
	public int cnting(Map<String, Object> map) {
		return this.ss.selectOne(("review.cntring"), map);
	}
	// 플래너 평점 업데이트
	public void plannerRating(Map<String, Object> map) {
		this.ss.update("review.plannerRating", map);
	}
}
