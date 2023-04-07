package com.goott.pj3.board.review.dto;

import java.util.Arrays;
import java.util.Date;

public class ReviewDTO {
    int review_idx;
    String user_id;
    int plan_idx;
    String review_content;
    String[] reivew_img;
    int review_rating;
    Date create_date;
    Date upate_date;

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
        return upate_date;
    }

    public void setUpate_date(Date upate_date) {
        this.upate_date = upate_date;
    }

    @Override
    public String toString() {
        return "ReviewDTO [review_idx=" + review_idx + ",user_id=" + user_id + ",plan_idx=" + plan_idx +
                ",review_content=" + review_content + ",review_rating=" + review_rating +
                ", reivew_img=" + Arrays.toString(reivew_img) +
                ",create_date=" + create_date + ",upate_date=" + upate_date + "]";
    }
}
