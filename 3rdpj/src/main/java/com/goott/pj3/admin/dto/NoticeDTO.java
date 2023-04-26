package com.goott.pj3.admin.dto;

import java.util.Date;

public class NoticeDTO {

    private int qna_idx;
    private String user_id;
    private String category;
    private String auth;
    private String qna_title;
    private String qna_content;
    private String qna_answer;
    private String qna_pw;
    private String answer;
    private String q_del_yn;
    private Date create_date;
    private Date update_date;


    public int getQna_idx() {
        return qna_idx;
    }


    public void setQna_idx(int qna_idx) {
        this.qna_idx = qna_idx;
    }


    public String getUser_id() {
        return user_id;
    }


    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getAuth() {
        return auth;
    }


    public void setAuth(String auth) {
        this.auth = auth;
    }


    public String getQna_title() {
        return qna_title;
    }


    public void setQna_title(String qna_title) {
        this.qna_title = qna_title;
    }


    public String getQna_content() {
        return qna_content;
    }


    public void setQna_content(String qna_content) {
        this.qna_content = qna_content;
    }


    public String getQna_answer() {
        return qna_answer;
    }


    public void setQna_answer(String qna_answer) {
        this.qna_answer = qna_answer;
    }


    public String getQna_pw() {
        return qna_pw;
    }


    public void setQna_pw(String qna_pw) {
        this.qna_pw = qna_pw;
    }


    public String getAnswer() {
        return answer;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public String getQ_del_yn() {
        return q_del_yn;
    }


    public void setQ_del_yn(String q_del_yn) {
        this.q_del_yn = q_del_yn;
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
        return "QnaDTO [ qna_idx =" + qna_idx
                + ",user_id=" + user_id
                + ",category=" + category
                + ",auth=" + auth
                + ",qna_title=" + qna_title
                + ", qna_content=" + qna_content
                + ", qna_answer=" + qna_answer
                + ", qna_pw= " + qna_pw
                + ", answer=" + answer
                + ",q_del_yn=" + q_del_yn
                + ",create_date=" + create_date
                + ", update_date=" + update_date
                + "]";
    }

}
