package com.goott.pj3.board.review.dto;

public class PlannerRatingDTO {

    private int planner_rating;
    private int plan_idx;
    private String planner_id; // 플래너 아이디
    private String user_id;
    private int rating_cnt; // 평점 카운팅

    public int getPlanner_rating() {
        return planner_rating;
    }

    public void setPlanner_rating(int planner_rating) {
        this.planner_rating = planner_rating;
    }

    public int getPlan_idx() {
        return plan_idx;
    }

    public void setPlan_idx(int plan_idx) {
        this.plan_idx = plan_idx;
    }

    public String getPlanner_id() {
        return planner_id;
    }

    public void setPlanner_id(String planner_id) {
        this.planner_id = planner_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getRating_cnt() {
        return rating_cnt;
    }

    public void setRating_cnt(int rating_cnt) {
        this.rating_cnt = rating_cnt;
    }
    @Override
    public String toString() {
        return "PlannerRatingDTO{" +
                "planner_rating=" + planner_rating +
                ", plan_idx=" + plan_idx +
                ", planner_id='" + planner_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", rating_cnt=" + rating_cnt +
                '}';
    }
}
