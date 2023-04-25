package com.goott.pj3.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goott.pj3.user.dto.UserDTO;
import com.goott.pj3.user.repo.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
//	회원가입 - 장민실 23.04.04
	@Transactional
	@Override
	public void sign_up(UserDTO u_dto) {
//		비밀번호 암호화 추가 - 장민실 23.04.11
		u_dto.setPw(bcrypt.encode(u_dto.getPw()));		
		userDAO.sign_up(u_dto);
	}

//	아이디 중복체크 - 장민실 23.04.04
	@Override
	public int id_chk(String id) {
		return userDAO.id_chk(id);
	}
	
//	로그인 - 장민실 23.04.04
	@Transactional
	@Override
	public UserDTO sign_in(UserDTO u_dto) {
//		DB의 암호화 비밀번호 가져오기 추가 - 장민실 23.04.11
//		String hashed_pw = userDAO.get_hashed_pw(u_dto);
//		boolean pw_match = bcrypt.matches(u_dto.getPw(), hashed_pw);	// 일치여부 확인 : true=일치, false=불일치
//		if(pw_match == true) {
			return userDAO.sign_in(u_dto);
//		}
//		else return null;
	}

//	아이디 찾기 - 장민실 23.04.13
	@Override
	public String find_id(UserDTO u_dto) {
		return userDAO.find_id(u_dto);
	}

//	비밀번호 찾기 - 장민실 23.04.23
	@Override
	public String find_get_pw(UserDTO u_dto) {
		return userDAO.find_get_pw(u_dto);
	}

//	@Transactional
//	@Override
//	public void set_new_pw(UserDTO u_dto) {
//		return userDAO.set_new_pw(u_dto);
//	}
	
}
