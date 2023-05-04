package com.goott.pj3.board.review.service;

import java.util.List;
import java.util.Map;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;

public interface ReviewService {
    /**
     * 리뷰 내용 생성
     * @param reviewDTO
     * @return
     */
    int create(ReviewDTO reviewDTO);

    /**
     * 리뷰 이미지 파일 생성
     * @param reviewDTO
     */
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
}
