package com.goott.pj3.board.review.service;

import java.util.List;
import java.util.Map;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;

public interface ReviewService {
    int create(ReviewDTO reviewDTO);

    void createFile(ReviewDTO reviewDTO);

    List<ReviewDTO> detail(ReviewDTO reviewDTO);

    int update(ReviewDTO reviewDTO);

    boolean delete(ReviewDTO reviewDTO);

    List<ReviewDTO> list(Criteria cri);

    PagingDTO paging(Criteria cri);


    void updateFile(ReviewDTO reviewDTO);
}
