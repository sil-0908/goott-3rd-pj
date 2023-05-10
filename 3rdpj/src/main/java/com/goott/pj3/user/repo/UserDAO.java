package com.goott.pj3.user.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.user.dto.UserDTO;

//장민실 23.04.04
@Repository
public class UserDAO {

	@Autowired
	SqlSession ss;
	
//	회원가입
	public void sign_up(UserDTO u_dto) {
		ss.insert("user.sign_up", u_dto);
	}
	
//	회원가입 이용약관
	public List<UserDTO> get_signup_accept() {
		return ss.selectList("user.get_signup_accept");
	}
	public List<UserDTO> get_signup_privacy() {
		return ss.selectList("user.get_signup_privacy");
	}

//	아이디 중복체크
	public int id_chk(String id) {
		return ss.selectOne("user.id_chk", id);
	}

//	로그인
	public UserDTO sign_in(UserDTO u_dto) {
		return ss.selectOne("user.sign_in", u_dto);
	}

//	DB의 암호화 비밀번호 가져오기
	public String get_hashed_pw(UserDTO u_dto) {
		return ss.selectOne("user.get_hashed_pw", u_dto);
	}
	
//	아이디찾기
	public String find_id(UserDTO u_dto) {
		return ss.selectOne("user.find_id", u_dto);
	}

//	사용자 탈퇴여부
	public String del_yn(UserDTO u_dto) {
		return ss.selectOne("user.del_yn", u_dto);
	}

//	비밀번호 찾기
	public String find_get_pw(UserDTO u_dto) {
		return ss.selectOne("user.find_get_pw", u_dto);
	}

//  비밀번호 변경
	public void set_new_pw(UserDTO u_dto) {
		ss.update("user.find_set_pw", u_dto);
	}

//	일반 사용자가 플래너 마이페이지 접속할때
	public UserDTO get_planner_info(UserDTO u_dto) {
		return ss.selectOne("user.get_planner_info", u_dto);
	}

//	일반사용자 마이페이지
	public UserDTO get_user_my_info(UserDTO u_dto) {
		return ss.selectOne("user.get_user_my_info", u_dto);
	}

//	플래너 마이페이지
	public UserDTO get_planner_my_info(UserDTO u_dto) {
		return ss.selectOne("user.get_planner_my_info", u_dto);
	}

	

	
}
