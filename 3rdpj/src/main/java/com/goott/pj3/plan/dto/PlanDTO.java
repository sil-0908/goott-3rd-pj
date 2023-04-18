package com.goott.pj3.plan.dto;

import java.util.Date;

public class PlanDTO {
    private int plan_idx,  price, sale_count;
    private String start_date, end_date, plan_detail, plan_detail_img, plan_title, user_id;
    private boolean p_del_yn;
    private Date create_date, update_date;

    public int getPlan_idx() {
        return plan_idx;
    }

    public void setPlan_idx(int plan_idx) {
        this.plan_idx = plan_idx;
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

    public String getPlan_detail() {
        return plan_detail;
    }

    public void setPlan_detail(String plan_detail) {
        this.plan_detail = plan_detail;
    }

    public String getPlan_detail_img() {
        return plan_detail_img;
    }

    public void setPlan_detail_img(String plan_detail_img) {
        this.plan_detail_img = plan_detail_img;
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

    @Override
    public String toString() {
        return "PlanDTO{" +
                "plan_idx=" + plan_idx +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", price=" + price +
                ", sale_count=" + sale_count +
                ", plan_detail='" + plan_detail + '\'' +
                ", plan_detail_img='" + plan_detail_img + '\'' +
                ", plan_title='" + plan_title + '\'' +
                ", user_id='" + user_id + '\'' +
                ", p_del_yn=" + p_del_yn +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}