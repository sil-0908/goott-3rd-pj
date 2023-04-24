package com.goott.pj3.admin.service;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;

import java.util.List;
import java.util.Map;

public interface AdminReviewService {

    List<ReviewDTO> list(Criteria cri);

    PagingDTO paging(Criteria cri);

    public Map<String, Object> detail(Map<String, Object> map);

    boolean update(Map<String, Object> map);

    boolean delete(Map<String, Object> map);

}
