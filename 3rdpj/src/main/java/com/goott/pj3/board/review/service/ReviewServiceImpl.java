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
	 * 리뷰 생성
	 * @param reviewDTO 리뷰 정보
	 * @return 생성된 리뷰의 review_idx 값
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

	/**
	 * 리뷰 이미지 생성
	 * @param reviewDTO 리뷰 정보
	 */
	@Override
	public void createImg(ReviewDTO reviewDTO) {
		this.reviewDAO.createImg(reviewDTO);
	}

	/**
	 * 리뷰 상세 정보 조회
	 * @param reviewDTO
	 * @return 리뷰 상세 정보
	 */
	@Override
	public ReviewDTO detail(ReviewDTO reviewDTO) {
		return this.reviewDAO.detail(reviewDTO);
	}

	/**
	 * 리뷰 업데이트
	 * @param reviewDTO
	 * @return 업데이트 된 리뷰 인덱스값
	 */
	@Override
	public int update(ReviewDTO reviewDTO) {
		int cnt = this.reviewDAO.update(reviewDTO);
		if(cnt==1){
			return reviewDTO.getReview_idx();
		}
		return 0;
	}

	/**
	 * 리뷰 이미지 업데이트
	 * @param reviewDTO 업데이트 할 리뷰 정보
	 */
	@Override
	public void updateImg(ReviewDTO reviewDTO) {
		this.reviewDAO.updateImg(reviewDTO);
	}

	/**
	 * 리뷰 삭제
	 * @param reviewDTO
	 * @return 삭제 성공 여부 (true : 성공, fasle : 실패)
	 */
	@Override
	public boolean delete(ReviewDTO reviewDTO) {
		int cnt = this.reviewDAO.delete(reviewDTO);
		if (cnt==1){
			return true;
		}
		return false;
	}

	/**
	 * 리뷰 이미지 삭제
	 * @param reviewDTO 삭제할 리뷰 정보
	 */
	@Override
	public void deleteImg(ReviewDTO reviewDTO) {
		this.reviewDAO.deleteImg(reviewDTO);
	}

	/**
	 * 리뷰 목록
	 * @param cri 조회 조건(페이징 정보 포함)
	 * @return 리뷰 목록
	 */
	@Override
	public List<ReviewDTO> list(Criteria cri) {
		return reviewDAO.list(cri);
	}

	/**
	 페이징 처리
	 @param cri 페이징 조건을 담고 있는 Criteria 객체
	 @return 페이징 처리를 위한 정보를 담고 있는 PagingDTO 객체
	 */
	@Override
	public PagingDTO paging(Criteria cri) {
		PagingDTO paging = new PagingDTO(); // 페이징 정보를 담을 객체 생성
		paging.setCri(cri); // 페이징 조건 설정
		paging.setTotalCount(reviewDAO.totalCount(cri)); // 전체 게시물 수 설정
		return paging; // 페이징 정보 반환
	}

	/**
	 * 조건에 맞는 리뷰 이미지 목록
	 * @param reviewDTO 조회 조건
	 * @return 리뷰 이미지 목록
	 */
	@Override
	public List<ReviewDTO> imglist(ReviewDTO reviewDTO) {
		return this.reviewDAO.imgList(reviewDTO);
	}

	/**
	 * 리뷰 이미지 삭제 
	 * @param reviewDTO 삭제할 리뷰 정보
	 */
	@Override
	public void updateDeleteImg(ReviewDTO reviewDTO) {
		this.reviewDAO.updateDeleteImg(reviewDTO);
	}
	/**
	 * 플래너 평점 정보 
	 * @param planDTO
	 * @return 플래너 평점 정보 
	 */
	@Override
	public PlanDTO getCreate(PlanDTO planDTO) {
		return this.reviewDAO.getCreate(planDTO);
	}
	/**
	 * 플래너 평점 등록
	 * @param plannerRatingDTO 플래너 평점 정보
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
	 * 리뷰 좋아요, 싫어요 카운트
	 * @param likeUnlikeDTO 리뷰 평가 정보 (리뷰 인덱스)
	 * @return 리뷰 좋아요, 싫어요 개수
	 */
	@Override
	public LikeUnlikeDTO likeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO) {
		return this.reviewDAO.likeUnlikeCnt(likeUnlikeDTO);
	}


}
