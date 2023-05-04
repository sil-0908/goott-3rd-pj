package com.goott.pj3.board.review.dto;

public class LikeUnlikeDTO {

    private int review_idx;
    private String user_id;
    private int r_like;
    private int r_unlike;

    public int getReview_idx() {
        return review_idx;
    }

    public void setReview_idx(int review_idx) {
        this.review_idx = review_idx;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getR_like() {
        return r_like;
    }

    public void setR_like(int r_like) {
        this.r_like = r_like;
    }

    public int getR_unlike() {
        return r_unlike;
    }

    public void setR_unlike(int r_unlike) {
        this.r_unlike = r_unlike;
    }

    @Override
    public String toString() {
        return "LikeUnlikeDTO{" +
                "review_idx=" + review_idx +
                ", user_id='" + user_id + '\'' +
                ", r_like=" + r_like +
                ", r_unlike=" + r_unlike +
                '}';
    }
}
