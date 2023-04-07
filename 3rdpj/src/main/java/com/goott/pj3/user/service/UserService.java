package com.goott.pj3.user.service;

import com.goott.pj3.user.dto.UserDTO;

public interface UserService {

//	로그인할때 일치하는 유저정보 있는지 int 반환
	int user_cnt(UserDTO u_dto);

//	세션 저장시킬 유저정보 dto담아오기
	UserDTO find_user(String id);

//	회원가입
	void sign_up(UserDTO u_dto);

//	아이디 중복체크
	int id_chk(String id);

}
