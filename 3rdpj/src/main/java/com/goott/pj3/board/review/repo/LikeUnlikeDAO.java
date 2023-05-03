package com.goott.pj3.board.review.repo;

import com.goott.pj3.board.review.dto.LikeUnlikeDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeUnlikeDAO {

    @Autowired
    SqlSession ss;

    public LikeUnlikeDTO likeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO) {
        return this.ss.selectOne("likeUnlike.likeUnlikeCnt", likeUnlikeDTO);
    }
    public void createLike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.insert("likeUnlike.createLike", likeUnlikeDTO);
    }

    public void like(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.like", likeUnlikeDTO);
    }

    public void relike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.relike", likeUnlikeDTO);
    }

    public void cancelLike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.deleteLike", likeUnlikeDTO);
    }

    public void createUnlike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.insert("likeUnlike.createUnlike", likeUnlikeDTO);
    }

    public void unlike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.unlike", likeUnlikeDTO);
    }
    public void reUnLike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.reUnLike", likeUnlikeDTO);
    }

    public void cancelUnLike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.deleteUnlike", likeUnlikeDTO);
    }

    public LikeUnlikeDTO getLikeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO) {
        return this.ss.selectOne("likeUnlike.getLikeUnlikeCnt", likeUnlikeDTO);
    }

}
