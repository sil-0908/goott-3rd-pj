package com.goott.pj3.board.review.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ReviewDTO {
    private int review_idx, plan_idx, review_rating;
    private String user_id, review_content, r_del_yn;
    private Date create_date, update_date;
    private List<String> img;

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }

    public int getReview_idx() {
        return review_idx;
    }

    public void setReview_idx(int review_idx) {
        this.review_idx = review_idx;
    }

    public int getPlan_idx() {
        return plan_idx;
    }

    public void setPlan_idx(int plan_idx) {
        this.plan_idx = plan_idx;
    }

    public int getReview_rating() {
        return review_rating;
    }

    public void setReview_rating(int review_rating) {
        this.review_rating = review_rating;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }

    public String getR_del_yn() {
        return r_del_yn;
    }

    public void setR_del_yn(String r_del_yn) {
        this.r_del_yn = r_del_yn;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
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
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                ", img=" + img +
                '}';
    }
}
