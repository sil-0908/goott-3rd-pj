package com.goott.pj3.board.review.service;

import java.util.List;
import java.util.Map;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;

public interface ReviewService {

    public String create(Map<String, Object>map);

    public Map<String, Object> detail(Map<String, Object> map);

    boolean update(Map<String, Object> map);

    boolean delete(Map<String, Object> map);

	public List<ReviewDTO> list(Criteria cri);

	public PagingDTO paging(Criteria cri);

}
