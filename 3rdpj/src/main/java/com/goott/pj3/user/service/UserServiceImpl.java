package com.goott.pj3.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goott.pj3.user.dto.UserDTO;
import com.goott.pj3.user.repo.UserDAO;

//장민실 23.04.04
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
//	회원가입
	@Transactional
	@Override
	public void sign_up(UserDTO u_dto) {
//		비밀번호 암호화 추가 - 장민실 23.04.11
		u_dto.setPw(bcrypt.encode(u_dto.getPw()));
		userDAO.sign_up(u_dto);
	}
	
//	회원가입 이용약관
	@Override
	public List<UserDTO> get_signup_accept() {
		return userDAO.get_signup_accept();
	}
	@Override
	public List<UserDTO> get_signup_privacy() {
		return userDAO.get_signup_privacy();
	}

//	아이디 중복체크
	@Override
	public int id_chk(String id) {
		return userDAO.id_chk(id);
	}
	
//	로그인
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

//	아이디 찾기
	@Override
	public String find_id(UserDTO u_dto) {
		return userDAO.find_id(u_dto);
	}

//	비밀번호 찾기
	@Override
	public String find_get_pw(UserDTO u_dto) {
		return userDAO.find_get_pw(u_dto);
	}
	
//	pw 값 존재여부
	@Transactional
	@Override
	public int pw_cnt(UserDTO u_dto) {
		String hashed_pw = userDAO.get_hashed_pw(u_dto);
		boolean pw_match = bcrypt.matches(u_dto.getPw(), hashed_pw);	// 일치여부 확인 : true=일치, false=불일치
		System.out.println("비밀번호 일치 여부(서비스) : " + pw_match);
		if(pw_match == true) {
			System.out.println("서비스에서 true탔음 1 리턴");
			return 1;
		}
		else System.out.println("서비스에서 false탔음 0 리턴"); return 0;
	}

//  비밀번호 변경
	@Transactional
	@Override
	public void set_new_pw(UserDTO u_dto) {
		u_dto.setPw(bcrypt.encode(u_dto.getPw()));
		userDAO.set_new_pw(u_dto);
	}

//	일반 사용자가 플래너 마이페이지 접속할때
	@Override
	public UserDTO get_planner_info(UserDTO u_dto) {
		return userDAO.get_planner_info(u_dto);
	}

//	일반사용자 마이페이지
	@Override
	public UserDTO get_user_my_info(UserDTO u_dto) {
		return userDAO.get_user_my_info(u_dto);
	}

//	플래너 마이페이지
	@Override
	public UserDTO get_planner_my_info(UserDTO u_dto) {
		return userDAO.get_planner_my_info(u_dto);
	}

	


	
}
