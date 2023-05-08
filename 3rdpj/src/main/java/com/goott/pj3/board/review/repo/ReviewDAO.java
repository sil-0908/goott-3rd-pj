package com.goott.pj3.board.review.repo;

import com.goott.pj3.board.review.dto.LikeUnlikeDTO;
import com.goott.pj3.board.review.dto.PlannerRatingDTO;
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
	
	// 리뷰 생성
	public int create(ReviewDTO reviewDTO) {
		return this.ss.insert("review.insert", reviewDTO);
	}
	// 리뷰 이미지 생성
	public void createImg(ReviewDTO reviewDTO) {
		this.ss.insert("review.insertFile", reviewDTO);
	}
	// 리뷰 상세 정보 호출
	public ReviewDTO detail(ReviewDTO reviewDTO) {
		return this.ss.selectOne("review.detail", reviewDTO);
	}
	// 리뷰 업데이트
	public int update(ReviewDTO reviewDTO) {
		return this.ss.update("review.update", reviewDTO);
	}
	// 리뷰 이미지 삭제
	public void deleteImg(ReviewDTO reviewDTO) {
		this.ss.delete("review.deleteImg", reviewDTO);
	}
 	// 리뷰 이미지 업데이트 
	public void updateImg(ReviewDTO reviewDTO) {
		this.ss.update("review.updateImg", reviewDTO);
	}
	// 리뷰 삭제
	public int delete(ReviewDTO reviewDTO) {
		return this.ss.update("review.delete", reviewDTO);
	}
	// 리뷰 목록 호출
	public List<ReviewDTO> list(Criteria cri) {
		return this.ss.selectList("review.list", cri);
	}
	// 리뷰 토탈 게시물 수 
	public int totalCount(Criteria cri) {
		return this.ss.selectOne("review.totalCount",cri);
	}
	// 이미지 목록 호출
	public List<ReviewDTO> imgList(ReviewDTO reviewDTO) {
		return this.ss.selectList("review.imglist", reviewDTO);
	}
	// 리뷰 이미지 업데이트 
	public void updateDeleteImg(ReviewDTO reviewDTO) {
		this.ss.update("review.updateDeleteImg", reviewDTO);
	}
	// 플랜 정보 호출
	public PlanDTO getCreate(PlanDTO planDTO) {
		return this.ss.selectOne("review.getCreate", planDTO);
	}
	// 기존 점수 가져오기
	public int rating(PlannerRatingDTO plannerRatingDTO) {
		return this.ss.selectOne("review.rating", plannerRatingDTO);
	}
	// 평점 매긴 인원 카운팅
	public int cnting(PlannerRatingDTO plannerRatingDTO) {
		return this.ss.selectOne("review.cntring", plannerRatingDTO);
	}
	// 플래너 평점 업데이트
	public void plannerRating(PlannerRatingDTO plannerRatingDTO) {
		this.ss.update("review.plannerRating", plannerRatingDTO);
	}
	// 플래너 평점 남긴 여부
	public void yOrN(PlannerRatingDTO plannerRatingDTO) {
		this.ss.update("review.yOrN", plannerRatingDTO);
	}
    // 리뷰 좋아요, 싫어요 개수 정보
	public LikeUnlikeDTO likeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO) {
		return this.ss.selectOne("review.likeUnlikeCnt", likeUnlikeDTO);
    }
}
