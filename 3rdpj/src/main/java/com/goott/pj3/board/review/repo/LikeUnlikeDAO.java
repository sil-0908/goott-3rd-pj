package com.goott.pj3.board.review.repo;

import com.goott.pj3.board.review.dto.LikeUnlikeDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeUnlikeDAO {

    @Autowired
    SqlSession ss;

    // 기존 좋아요, 싫어요 개수 리턴
    public LikeUnlikeDTO likeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO) {
        return this.ss.selectOne("likeUnlike.likeUnlikeCnt", likeUnlikeDTO);
    }
    // 좋아요 최소 생성
    public void createLike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.insert("likeUnlike.createLike", likeUnlikeDTO);
    }
    // 좋아요 0->1
    public void like(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.like", likeUnlikeDTO);
    }
    // 좋아요 0->1 싫어요 1->0
    public void relike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.relike", likeUnlikeDTO);
    }
    // 좋아요 1->0
    public void cancelLike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.deleteLike", likeUnlikeDTO);
    }
    // 싫어요 최소 생성
    public void createUnlike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.insert("likeUnlike.createUnlike", likeUnlikeDTO);
    }
    // 싫어요 0->1
    public void unlike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.unlike", likeUnlikeDTO);
    }
    // 싫어요 0->1 좋아요 1->0
    public void reUnLike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.reUnLike", likeUnlikeDTO);
    }
    // 싫어요 1->0
    public void cancelUnLike(LikeUnlikeDTO likeUnlikeDTO) {
        this.ss.update("likeUnlike.deleteUnlike", likeUnlikeDTO);
    }
    // 조회한 게시글 좋아요, 싫어요 갯수 리턴
    public LikeUnlikeDTO getLikeUnlikeCnt(LikeUnlikeDTO likeUnlikeDTO) {
        return this.ss.selectOne("likeUnlike.getLikeUnlikeCnt", likeUnlikeDTO);
    }
}
