package com.goott.pj3.plan.dto;
//2023.04.22 길영준
public class PayDTO {
    private String imp_uid, merchant_uid, user_id, plan_idx;

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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPlan_idx() {
        return plan_idx;
    }

    public void setPlan_idx(String plan_idx) {
        this.plan_idx = plan_idx;
    }

    @Override
    public String toString() {
        return "PayDTO{" +
                "imp_uid='" + imp_uid + '\'' +
                ", merchant_uid='" + merchant_uid + '\'' +
                ", user_id='" + user_id + '\'' +
                ", plan_idx='" + plan_idx + '\'' +
                '}';
    }
}
