package com.goott.pj3.board.review.service;

import java.util.List;

import com.goott.pj3.board.review.dto.LikeUnlikeDTO;
import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.board.review.dto.PlannerRatingDTO;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;
import com.goott.pj3.plan.dto.PlanDTO;

public interface ReviewService {

    int create(ReviewDTO reviewDTO);

    void createImg(ReviewDTO reviewDTO);

    ReviewDTO detail(ReviewDTO reviewDTO);

    int update(ReviewDTO reviewDTO);

    void deleteImg(ReviewDTO reviewDTO);

    void updateImg(ReviewDTO reviewDTO);

    boolean delete(ReviewDTO reviewDTO);

    List<ReviewDTO> list(Criteria cri);

    PagingDTO paging(Criteria cri);

    List<ReviewDTO> imglist(ReviewDTO reviewDTO);

    void updateDeleteImg(ReviewDTO reviewDTO);

    PlanDTO getCreate(PlanDTO planDTO);

    void plannerRating(PlannerRatingDTO plannerRatingDTO);

    LikeUnlikeDTO likeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO);
}
