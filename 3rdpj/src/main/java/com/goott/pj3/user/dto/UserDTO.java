package com.goott.pj3.user.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTO {
	
	// 공통 DTO : 아이디, 비밀번호, 생년월일, 이메일, 폰번호, 권한, 탈퇴여부, 프로필사진, 포인트, 회원가입일자, 정보수정일자
	private String user_id, pw, birth, email, hp, auth, u_del_yn, profile_img;
	private int u_point;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private LocalDateTime create_date, update_date;
	// 플래너 DTO : 사업용 폰번호, 자기소개, 사업자등록번호, 계좌, 성공횟수, 플래너 평균점수
	private String hp_emp, intro, emp_num, acount, planner_score;
	private int success_count;
	// 회원가입 이용약관 DTO
	private String accept_detail, privacy_detail;

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

	public LocalDateTime getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDateTime create_date) {
		this.create_date = create_date;
	}

	public LocalDateTime getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(LocalDateTime update_date) {
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
	
	public String getPlanner_score() {
		return planner_score;
	}

	public void setPlanner_score(String planner_score) {
		this.planner_score = planner_score;
	}

	public int getSuccess_count() {
		return success_count;
	}

	public void setSuccess_count(int success_count) {
		this.success_count = success_count;
	}		

	public String getAccept_detail() {
		return accept_detail;
	}

	public void setAccept_content(String accept_detail) {
		this.accept_detail = accept_detail;
	}	

	public String getPrivacy_detail() {
		return privacy_detail;
	}

	public void setPrivacy_detail(String privacy_detail) {
		this.privacy_detail = privacy_detail;
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
			+ ", planner_score = " + planner_score
			+ ", success_count = " + success_count
			+ ", accept_detail = " + accept_detail
			+ ", privacy_detail = " + privacy_detail
			+ "]";
	}

}
