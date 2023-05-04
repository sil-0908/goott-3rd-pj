package com.goott.pj3.plan.dto;
//2023.04.22 길영준
//2023.04.26 길영준 주석추가
public class PayDTO {
    private String imp_uid, merchant_uid, buyer_id, planner_id;
                //결제고유번호 //상점결제번호 // 구매자 // 판매자
    private int plan_idx; //플랜넘버

    public String getImp_uid() {
        return imp_uid;
    }

    public void setImp_uid(String imp_uid) {
        this.imp_uid = imp_uid;
    }

    public String getMerchant_uid() {
        return merchant_uid;
    }

    public void setMerchant_uid(String merchant_uid) {
        this.merchant_uid = merchant_uid;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getPlanner_id() {
        return planner_id;
    }

    public void setPlanner_id(String planner_id) {
        this.planner_id = planner_id;
    }

    public int getPlan_idx() {
        return plan_idx;
    }

    public void setPlan_idx(int plan_idx) {
        this.plan_idx = plan_idx;
    }

    @Override
    public String toString() {
        return "PayDTO{" +
                "imp_uid='" + imp_uid + '\'' +
                ", merchant_uid='" + merchant_uid + '\'' +
                ", buyer_id='" + buyer_id + '\'' +
                ", planner_id='" + planner_id + '\'' +
                ", plan_idx=" + plan_idx +
                '}';
    }
}
