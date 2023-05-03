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
        LikeUnlikeDTO likeUnlikeCnt = this.likeUnlikeDAO.likeUnlikeCnt(likeUnlikeDTO); // 내 라이크, 언라이크 수
        System.out.println("likeUnlikeCnt : " + likeUnlikeCnt);
        if(likeUnlikeCnt==null){ // 최초 라이크 +1
            System.out.println("보여야돼!");
            likeUnlikeDTO.setR_like(1); // 라이크 +1
            this.likeUnlikeDAO.createLike(likeUnlikeDTO);
        }else if(likeUnlikeCnt.getR_like()==0 && likeUnlikeCnt.getR_unlike()==0){ // 라이크 취소 후 다시 +1
            likeUnlikeDTO.setR_like(1); // 라이크 +1
            this.likeUnlikeDAO.like(likeUnlikeDTO);
        } else if(likeUnlikeCnt.getR_like()==0 && likeUnlikeCnt.getR_unlike()==1){ // 언라이크 취소, 라이크+1
            likeUnlikeDTO.setR_like(1); // 라이크 +1
            likeUnlikeCnt.setR_unlike(likeUnlikeCnt.getR_unlike()-1); // 언라이크 -1
            this.likeUnlikeDAO.relike(likeUnlikeDTO);
        }else if(likeUnlikeCnt.getR_like()==1 && likeUnlikeCnt.getR_unlike()==0){ // 라이크 취소
            likeUnlikeDTO.setR_like(0);
            this.likeUnlikeDAO.cancelLike(likeUnlikeDTO);
        }
    }
    @Override
    public void unlike(LikeUnlikeDTO likeUnlikeDTO) {
        LikeUnlikeDTO likeUnlikeCnt = this.likeUnlikeDAO.likeUnlikeCnt(likeUnlikeDTO); // 내 라이크, 언라이크 수
        if(likeUnlikeCnt==null){ // 최초 언 라이크 +1
            likeUnlikeDTO.setR_unlike(1); // 라이크 +1
            this.likeUnlikeDAO.createUnlike(likeUnlikeDTO);
        }else if(likeUnlikeCnt.getR_like()==0 && likeUnlikeCnt.getR_unlike()==0){ // 언라이크 취소 후 다시 +1
            likeUnlikeDTO.setR_unlike(1);
            this.likeUnlikeDAO.unlike(likeUnlikeDTO);
        }else if(likeUnlikeCnt.getR_like()==1 && likeUnlikeCnt.getR_unlike()==0){ // 라이크 취소, 언라이크+1
            likeUnlikeDTO.setR_unlike(1); // 언라이크 +1
            likeUnlikeCnt.setR_like(likeUnlikeCnt.getR_like()-1); // 라이크 -1
            this.likeUnlikeDAO.reUnLike(likeUnlikeDTO);
        }else if(likeUnlikeCnt.getR_like()==0 && likeUnlikeCnt.getR_unlike()==1){ // 라이크 취소
            likeUnlikeDTO.setR_unlike(0);
            this.likeUnlikeDAO.cancelUnLike(likeUnlikeDTO);
        }
    }

    @Override
    public LikeUnlikeDTO getLikeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO) {
        return this.likeUnlikeDAO.getLikeUnlikeCnt(likeUnlikeDTO);
    }
}
