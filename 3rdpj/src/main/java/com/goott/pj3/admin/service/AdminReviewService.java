package com.goott.pj3.admin.service;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;

import java.util.List;
import java.util.Map;

public interface AdminReviewService {

    List<ReviewDTO> list(Criteria cri);

    PagingDTO paging(Criteria cri);

    ReviewDTO detail(int reviewIdx);

//    boolean update(Map<String, Object> map);

//    boolean delete(Map<String, Object> map);


}
