package com.goott.pj3.board.review.service;

import com.goott.pj3.board.review.dto.LikeUnlikeDTO;
import com.goott.pj3.board.review.dto.PlannerRatingDTO;
import com.goott.pj3.plan.dto.PlanDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.board.review.repo.ReviewDAO;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;

import java.util.List;

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
	 * @param plannerRatingDTO
	 */
	@Override
	public void plannerRating(PlannerRatingDTO plannerRatingDTO) {
		// 기존 점수 가져오기
		int rating = reviewDAO.rating(plannerRatingDTO);
		// 기존 점수 + 평가한 점수 계산
		int sumRating = rating + (int) plannerRatingDTO.getPlanner_rating();

		// 기존 평가 인원 수 가져오기
		int cnt = reviewDAO.cnting(plannerRatingDTO);
		// 기존 평가 인원 수 + 1
		int sumCnt = cnt + 1;

		// 평점을 남겼는지 여부 가져오기
		reviewDAO.yOrN(plannerRatingDTO);

		// 평가된 내용 업데이트
		plannerRatingDTO.setPlanner_rating(sumRating);
		plannerRatingDTO.setRating_cnt(sumCnt);

		// 플래너 평점 업데이트
		this.reviewDAO.plannerRating(plannerRatingDTO);
	}

	/**
	 * 조원재 23.05.03 리뷰 좋아요, 싫어요 카운트
	 * @param likeUnlikeDTO
	 * @return
	 */
	@Override
	public LikeUnlikeDTO likeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO) {
		return this.reviewDAO.likeUnlikeCnt(likeUnlikeDTO);
	}


}
