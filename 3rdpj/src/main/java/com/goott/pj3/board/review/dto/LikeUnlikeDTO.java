package com.goott.pj3.board.review.dto;

public class LikeUnlikeDTO {

    private String user_id;
    private int p_like;
    private int p_unlike;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getP_like() {
        return p_like;
    }

    public void setP_like(int p_like) {
        this.p_like = p_like;
    }

    public int getP_unlike() {
        return p_unlike;
    }

    public void setP_unlike(int p_unlike) {
        this.p_unlike = p_unlike;
    }

    @Override
    public String toString() {
        return "LikeUnlikeDTO{" +
                "user_id='" + user_id + '\'' +
                ", p_like=" + p_like +
                ", p_unlike=" + p_unlike +
                '}';
    }
}
