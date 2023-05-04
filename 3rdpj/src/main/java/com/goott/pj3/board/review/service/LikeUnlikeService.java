package com.goott.pj3.board.review.service;

import com.goott.pj3.board.review.dto.LikeUnlikeDTO;

public interface LikeUnlikeService {

    /**
     * 좋아요 처리
     * @param likeUnlikeDTO 좋아요, 싫어요 DTO
     */
    void like(LikeUnlikeDTO likeUnlikeDTO);

    /**
     * 싫어요 처리
     * @param likeUnlikeDTO 좋아요, 싫어요 DTO
     */
    void unlike(LikeUnlikeDTO likeUnlikeDTO);

    /**
     * 좋아요, 싫어요 개수 가져오기
     * @param likeUnlikeDTO 좋아요, 싫어요 DTO
     * @return 좋아요, 싫어요 개수 DTO
     */
    LikeUnlikeDTO getLikeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO);
}
