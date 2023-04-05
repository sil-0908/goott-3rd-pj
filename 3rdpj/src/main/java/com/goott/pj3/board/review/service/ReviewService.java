package com.goott.pj3.board.review.service;

import java.util.Map;

public interface ReviewService {

    public String create(Map<String, Object>map);

    public Map<String, Object> detail(Map<String, Object> map);

}
