package com.goott.pj3.board.review.dto;

import java.util.Arrays;
import java.util.Date;

public class ReviewDTO {
    int review_idx, plan_idx, review_rating;
    String user_id, review_content, r_del_yn;
    String[] reivew_img;
    Date create_date, update_date;

    public String getR_del_yn() {
        return r_del_yn;
    }

    public void setR_del_yn(String r_del_yn) {
        this.r_del_yn = r_del_yn;
    }

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

    public int getPlan_idx() {
        return plan_idx;
    }

    public void setPlan_idx(int plan_idx) {
        this.plan_idx = plan_idx;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }

    public String[] getReivew_img() {
        return reivew_img;
    }

    public void setReivew_img(String[] reivew_img) {
        this.reivew_img = reivew_img;
    }

    public int getReview_rating() {
        return review_rating;
    }

    public void setReview_rating(int review_rating) {
        this.review_rating = review_rating;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpate_date() {
        return update_date;
    }

    public void setUpate_date(Date upate_date) {
        this.update_date = upate_date;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "review_idx=" + review_idx +
                ", plan_idx=" + plan_idx +
                ", review_rating=" + review_rating +
                ", user_id='" + user_id + '\'' +
                ", review_content='" + review_content + '\'' +
                ", r_del_yn='" + r_del_yn + '\'' +
                ", reivew_img=" + Arrays.toString(reivew_img) +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
