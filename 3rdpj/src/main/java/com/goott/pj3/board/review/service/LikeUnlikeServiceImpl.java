package com.goott.pj3.board.review.service;

import com.goott.pj3.board.review.dto.LikeUnlikeDTO;
import com.goott.pj3.board.review.repo.LikeUnlikeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeUnlikeServiceImpl implements LikeUnlikeService{

    @Autowired
    LikeUnlikeDAO likeUnlikeDAO;

    @Override
    public void like(LikeUnlikeDTO likeUnlikeDTO) {
        }

    @Override
    public void unlike(LikeUnlikeDTO likeUnlikeDTO) {
        }
}
