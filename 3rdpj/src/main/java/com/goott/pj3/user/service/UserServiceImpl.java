package com.goott.pj3.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.pj3.user.dto.UserDTO;
import com.goott.pj3.user.repo.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

//	로그인할때 일치하는 유저정보 있는지 int 반환
	@Override
	public int user_cnt(UserDTO u_dto) {
		return userDAO.user_cnt(u_dto);
	}
	
//	세션 저장시킬 유저정보 dto담아오기
	@Override
	public UserDTO find_user(String id) {
		return userDAO.find_user(id);
	}

//	회원가입
	@Override
	public void sign_up(UserDTO u_dto) {
		userDAO.sign_up(u_dto);
	}

//	아이디 중복체크
	@Override
	public int id_chk(String id) {
		return userDAO.id_chk(id);
	}
	
}
