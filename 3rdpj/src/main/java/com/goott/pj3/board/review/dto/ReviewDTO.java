package com.goott.pj3.board.review.dto;

import java.util.Date;
import java.util.List;

public class ReviewDTO {
    private int review_idx, plan_idx, planner_rating; // 리뷰 인덱스 // 플랜 인덱스 // 플래너 점수
    private String user_id, review_content, r_del_yn, keyword, option; // 유저 아이디 // 리뷰 내용 // 삭제여부 // 검색 키워드 // 검색 옵션
    private Date create_date, update_date; // 생성 날짜 // 수정 날짜
    private List<String> r_img; // 이미지 URL 주소
    private List<Integer> r_img_idx; // 이미지 인덱스 번호

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public List<Integer> getR_img_idx() {
        return r_img_idx;
    }

    public void setR_img_idx(List<Integer> r_img_idx) {
        this.r_img_idx = r_img_idx;
    }

    public List<String> getR_img() {
        return r_img;
    }

    public void setR_img(List<String> r_img) {
        this.r_img = r_img;
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

    public int getPlanner_rating() {
        return planner_rating;
    }

    public void setPlanner_rating(int planner_rating) {
        this.planner_rating = planner_rating;
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
                ", planner_rating=" + planner_rating +
                ", user_id='" + user_id + '\'' +
                ", review_content='" + review_content + '\'' +
                ", r_del_yn='" + r_del_yn + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                ", r_img=" + r_img +
                ", r_img_idx=" + r_img_idx +
                '}';
    }
}
