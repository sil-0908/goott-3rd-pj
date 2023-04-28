package com.goott.pj3.plan.dto;

import java.util.Date;
import java.util.List;

//2023.04.05 길영준
//2023.04.26 길영준 주석추가
public class PlanDTO {

    private int plan_idx, price, sale_count;
                //플랜번호 //가격 //판매횟수
    private String start_date, end_date, plan_detail, plan_detail_img, plan_title, user_id;
                    //여행시작일//종료일  //플랜상세정보  //플렌이미지     //플랜제목      //작성자
    private boolean p_del_yn;   //플랜 삭제여부
    private Date create_date, update_date;  //작성일 // 수정일


    public int getPlan_idx() {
        return plan_idx;
    }

    public void setPlan_idx(int plan_idx) {
        this.plan_idx = plan_idx;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSale_count() {
        return sale_count;
    }

    public void setSale_count(int sale_count) {
        this.sale_count = sale_count;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getPlan_detail() {
        return plan_detail;
    }

    public void setPlan_detail(String plan_detail) {
        this.plan_detail = plan_detail;
    }

    public String getPlan_title() {
        return plan_title;
    }

    public void setPlan_title(String plan_title) {
        this.plan_title = plan_title;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public boolean isP_del_yn() {
        return p_del_yn;
    }

    public void setP_del_yn(boolean p_del_yn) {
        this.p_del_yn = p_del_yn;
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

    public List<String> getP_img() {
        return p_img;
    }

    public void setP_img(List<String> p_img) {
        this.p_img = p_img;
    }

    public List<Integer> getP_img_idx() {
        return p_img_idx;
    }

    public void setP_img_idx(List<Integer> p_img_idx) {
        this.p_img_idx = p_img_idx;
    }

    @Override
    public String toString() {
        return "PlanDTO{" +
                "plan_idx=" + plan_idx +
                ", price=" + price +
                ", sale_count=" + sale_count +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", plan_detail='" + plan_detail + '\'' +
                ", plan_title='" + plan_title + '\'' +
                ", user_id='" + user_id + '\'' +
                ", p_del_yn=" + p_del_yn +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                ", p_img=" + p_img +
                ", p_img_idx=" + p_img_idx +
                '}';
    }
}