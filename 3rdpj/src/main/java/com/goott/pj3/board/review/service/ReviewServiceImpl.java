package com.goott.pj3.board.review.service;

import com.goott.pj3.board.review.dto.LikeUnlikeDTO;
import com.goott.pj3.plan.dto.PlanDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.board.review.repo.ReviewDAO;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;

import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDAO;

	/**
	 * 23.04.22 리뷰 생성
	 * @param reviewDTO
	 * @return
	 */
	@Override
	public int create(ReviewDTO reviewDTO) {
		int affectRowCnt =  this.reviewDAO.create(reviewDTO); // 게시글 생성된 갯수 반환
		if(affectRowCnt==1){
			System.out.println("review_idx : " + reviewDTO.getReview_idx());
			return reviewDTO.getReview_idx();
		}
		return 0;
	}

	@Override
	public void createImg(ReviewDTO reviewDTO) {
		this.reviewDAO.createImg(reviewDTO);
	}

	@Override
	public ReviewDTO detail(ReviewDTO reviewDTO) {
		return this.reviewDAO.detail(reviewDTO);
	}

	@Override
	public int update(ReviewDTO reviewDTO) {
		int cnt = this.reviewDAO.update(reviewDTO);
		if(cnt==1){
			return reviewDTO.getReview_idx();
		}
		return 0;
	}

	@Override
	public void updateImg(ReviewDTO reviewDTO) {
		this.reviewDAO.updateImg(reviewDTO);
	}

	@Override
	public boolean delete(ReviewDTO reviewDTO) {
		int cnt = this.reviewDAO.delete(reviewDTO);
		if (cnt==1){
			return true;
		}
		return false;
	}

	@Override
	public void deleteImg(ReviewDTO reviewDTO) {
		this.reviewDAO.deleteImg(reviewDTO);
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

	@Override
	public List<ReviewDTO> imglist(ReviewDTO reviewDTO) {
		return this.reviewDAO.imgList(reviewDTO);
	}

	@Override
	public void updateDeleteImg(ReviewDTO reviewDTO) {
		this.reviewDAO.updateDeleteImg(reviewDTO);
	}

	@Override
	public PlanDTO getCreate(PlanDTO planDTO) {
		return this.reviewDAO.getCreate(planDTO);
	}

	/**
	 * 조원재 23.05.03. 플래너 평점
	 * @param map
	 */
	@Override
	public void plannerRating(Map<String, Object> map) {
		// 기존 점수 가지고와서 플랜점수 더하기
		int rating = reviewDAO.rating(map); // 기존 점수
		int sumRating = rating + (int) map.get("planner_rating"); // 기존 점수 + 평가한 점수
		int cnt = reviewDAO.cnting(map); // 기존 평가한 인원 카운트
		int sumCnt = cnt + 1; // 기존 평가한 인원 카운트 + 1
		int affectRowCnt =reviewDAO.yOrN(map); // 평점 남긴 여부
		map.put("planner_rating", sumRating);
		map.put("rating_cnt", sumCnt);
		this.reviewDAO.plannerRating(map); // 플래너 평점 매기기
	}

	@Override
	public LikeUnlikeDTO likeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO) {
		return this.reviewDAO.likeUnlikeCnt(likeUnlikeDTO);
	}


}
