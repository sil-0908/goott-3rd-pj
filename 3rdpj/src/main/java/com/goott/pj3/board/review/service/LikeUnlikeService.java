package com.goott.pj3.board.review.service;

import com.goott.pj3.board.review.dto.LikeUnlikeDTO;

public interface LikeUnlikeService {

    void like(LikeUnlikeDTO likeUnlikeDTO);

    void unlike(LikeUnlikeDTO likeUnlikeDTO);

}
