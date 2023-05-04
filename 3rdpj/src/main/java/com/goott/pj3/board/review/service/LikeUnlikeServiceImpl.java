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
        processLikeUnlike(likeUnlikeDTO, true);
    }

    @Override
    public void unlike(LikeUnlikeDTO likeUnlikeDTO) {
        processLikeUnlike(likeUnlikeDTO, false);
    }

    /**
     * 라이크 또는 언라이크 처리
     *
     * @param likeUnlikeDTO LikeUnlikeDTO 객체
     * @param isLike        라이크 여부 (true: 라이크, false: 언라이크)
     */
    private void processLikeUnlike(LikeUnlikeDTO likeUnlikeDTO, boolean isLike) {
        LikeUnlikeDTO likeUnlikeCnt = this.likeUnlikeDAO.likeUnlikeCnt(likeUnlikeDTO);

        if (likeUnlikeCnt == null) {
            // 최초 라이크 또는 언라이크 처리
            if (isLike) {
                likeUnlikeDTO.setR_like(1);
                this.likeUnlikeDAO.createLike(likeUnlikeDTO);
            } else {
                likeUnlikeDTO.setR_unlike(1);
                this.likeUnlikeDAO.createUnlike(likeUnlikeDTO);
            }
        } else {
            int rLike = likeUnlikeCnt.getR_like();
            int rUnlike = likeUnlikeCnt.getR_unlike();

            if (rLike == 1 && rUnlike == 0 && isLike) {
                // 라이크 취소 처리
                likeUnlikeDTO.setR_like(0);
                this.likeUnlikeDAO.cancelLike(likeUnlikeDTO);
            } else if (rLike == 0 && rUnlike == 1 && !isLike) {
                // 언라이크 취소 처리
                likeUnlikeDTO.setR_unlike(0);
                this.likeUnlikeDAO.cancelUnLike(likeUnlikeDTO);
            } else if (rLike == 0 && rUnlike == 0) {
                // 라이크 또는 언라이크 처리
                if (isLike) {
                    likeUnlikeDTO.setR_like(1);
                    this.likeUnlikeDAO.like(likeUnlikeDTO);
                } else {
                    likeUnlikeDTO.setR_unlike(1);
                    this.likeUnlikeDAO.unlike(likeUnlikeDTO);
                }
            } else if (rLike == 0 && rUnlike == 1 && isLike) {
                // 언라이크 취소 후 라이크 처리
                likeUnlikeDTO.setR_like(1);
                likeUnlikeDTO.setR_unlike(0);
                this.likeUnlikeDAO.relike(likeUnlikeDTO);
            } else if (rLike == 1 && rUnlike == 0 && !isLike) {
                // 라이크 취소 후 언라이크 처리
                likeUnlikeDTO.setR_unlike(1);
                likeUnlikeDTO.setR_like(0);
                this.likeUnlikeDAO.reUnLike(likeUnlikeDTO);
            }
        }
    }

    @Override
    public LikeUnlikeDTO getLikeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO) {
        return this.likeUnlikeDAO.getLikeUnlikeCnt(likeUnlikeDTO);
    }
}
