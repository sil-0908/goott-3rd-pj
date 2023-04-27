package com.goott.pj3.user.dto;

import java.sql.Date;

public class UserDTO {
	
	// 공통 DTO : 아이디, 비밀번호, 생년월일, 이메일, 폰번호, 권한, 탈퇴여부, 프로필사진, 포인트, 회원가입일자, 정보수정일자
	String user_id, pw, birth, email, hp, auth, u_del_yn, profile_img;
	int u_point;
	Date create_date, update_date;
	// 플래너 DTO : 사업용 폰번호, 자기소개, 사업자등록번호, 계좌, 성공횟수, 플래너 좋아요/싫어요
	String hp_emp, intro, emp_num, acount;
	int success_count, planner_like, planner_unlike;	

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

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public int getU_point() {
		return u_point;
	}

	public void setU_point(int u_point) {
		this.u_point = u_point;
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

	public String getEmp_num() {
		return emp_num;
	}

	public void setEmp_num(String emp_num) {
		this.emp_num = emp_num;
	}

	public String getAcount() {
		return acount;
	}

	public void setAcount(String acount) {
		this.acount = acount;
	}

	public int getSuccess_count() {
		return success_count;
	}

	public void setSuccess_count(int success_count) {
		this.success_count = success_count;
	}

	public int getPlanner_like() {
		return planner_like;
	}

	public void setPlanner_like(int planner_like) {
		this.planner_like = planner_like;
	}

	public int getPlanner_unlike() {
		return planner_unlike;
	}

	public void setPlanner_unlike(int planner_unlike) {
		this.planner_unlike = planner_unlike;
	}

	@Override
	public String toString() {
	return "UserDTO [user_id = " + user_id
			+ ", pw = " + pw
			+ ", birth = " + birth
			+ ", email = " + email
			+ ", hp = " + hp
			+ ", auth = " + auth
			+ ", u_del_yn = " + u_del_yn
			+ ", profile_img = " + profile_img
			+ ", u_point = " + u_point
			+ ", create_date = " + create_date
			+ ", update_date = " + update_date
			+ ", hp_emp = " + hp_emp
			+ ", intro = " + intro
			+ ", emp_num = " + emp_num
			+ ", acount = " + acount
			+ ", success_count = " + success_count
			+ ", planner_like = " + planner_like
			+ ", planner_unlike = " + planner_unlike
			+ "]";
	}

}
