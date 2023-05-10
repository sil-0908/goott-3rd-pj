package com.goott.pj3.admin.dto;

import java.util.Date;


public class AdminUserDTO {

    //업무용전화 : hp_emp
    //소개 : INTRO
    //결제할때 올라가는 포인트 : u_point
    //사업자번호 :emp_num
    //결제성공횟수 : success_count
    //계좌번호 : acount
    private String user_id;
    private String pw;
    private String birth;
    private String email;
    private String hp;
    private String hp_emp;
    private String intro;
    private String profile_img;
    private String auth;
    private String u_del_yn;
    private String acount;

    private String planner_score;

    private int u_point;
    private int emp_num;
    private int success_count;

    private int planner_rating ;

    private Date create_date;
    private Date update_date;


    public String getUser_id() {
        return user_id;
    }


    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public String getPw() {
        return pw;
    }


    public void setPw(String pw) {
        this.pw = pw;
    }


    public String getBirth() {
        return birth;
    }


    public void setBirth(String birth) {
        this.birth = birth;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getHp() {
        return hp;
    }


    public void setHp(String hp) {
        this.hp = hp;
    }


    public String getHp_emp() {
        return hp_emp;
    }


    public void setHp_emp(String hp_emp) {
        this.hp_emp = hp_emp;
    }


    public String getIntro() {
        return intro;
    }


    public void setIntro(String intro) {
        this.intro = intro;
    }


    public String getProfile_img() {
        return profile_img;
    }


    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }


    public String getAuth() {
        return auth;
    }


    public void setAuth(String auth) {
        this.auth = auth;
    }


    public String getU_del_yn() {
        return u_del_yn;
    }


    public void setU_del_yn(String u_del_yn) {
        this.u_del_yn = u_del_yn;
    }


    public String getAcount() {
        return acount;
    }


    public void setAcount(String acount) {
        this.acount = acount;
    }


    public int getU_point() {
        return u_point;
    }


    public void setU_point(int u_point) {
        this.u_point = u_point;
    }


    public int getEmp_num() {
        return emp_num;
    }


    public void setEmp_num(int emp_num) {
        this.emp_num = emp_num;
    }


    public int getSuccess_count() {
        return success_count;
    }


    public void setSuccess_count(int success_count) {
        this.success_count = success_count;
    }


    public String getPlanner_score() {
        return planner_score;
    }

    public void setPlanner_score(String planner_score) {
        this.planner_score = planner_score;
    }

    public int getPlanner_rating() {
        return planner_rating;
    }

    public void setPlanner_rating(int planner_rating) {
        this.planner_rating = planner_rating;
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
        return "AdminUserDTO{" +
                "user_id='" + user_id + '\'' +
                ", pw='" + pw + '\'' +
                ", birth='" + birth + '\'' +
                ", email='" + email + '\'' +
                ", hp='" + hp + '\'' +
                ", hp_emp='" + hp_emp + '\'' +
                ", intro='" + intro + '\'' +
                ", profile_img='" + profile_img + '\'' +
                ", auth='" + auth + '\'' +
                ", u_del_yn='" + u_del_yn + '\'' +
                ", acount='" + acount + '\'' +
                ", planner_score='" + planner_score + '\'' +
                ", u_point=" + u_point +
                ", emp_num=" + emp_num +
                ", success_count=" + success_count +
                ", planner_rating=" + planner_rating +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
