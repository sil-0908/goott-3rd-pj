package com.goott.pj3.user.service;

import java.util.List;

import com.goott.pj3.user.dto.UserDTO;

// 장민실 23.04.04
public interface UserService {
	
//	회원가입
	void sign_up(UserDTO u_dto);
	
//	회원가입 이용약관
	List<UserDTO> get_signup_accept();
	List<UserDTO> get_signup_privacy();

//	아이디 중복체크
	int id_chk(String id);

//	로그인
	UserDTO sign_in(UserDTO u_dto);

//	아이디 찾기
	String find_id(UserDTO u_dto);

//	비밀번호 찾기
	String find_get_pw(UserDTO u_dto);
	
//	pw값 존재여부
	int pw_cnt(UserDTO u_dto);

//  비밀번호 변경
	void set_new_pw(UserDTO u_dto);

//	일반 사용자가 플래너 마이페이지 접속할때
	UserDTO get_planner_info(UserDTO u_dto);
	
//	일반사용자 마이페이지
	UserDTO get_user_my_info(UserDTO u_dto);

//	플래너 마이페이지
	UserDTO get_planner_my_info(UserDTO u_dto);


	

}
