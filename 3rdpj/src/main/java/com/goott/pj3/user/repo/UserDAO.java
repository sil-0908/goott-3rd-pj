package com.goott.pj3.user.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.user.dto.UserDTO;

@Repository
public class UserDAO {

	@Autowired
	SqlSession ss;

//	로그인할때 일치하는 유저정보 있는지 int 반환
	public int user_cnt(UserDTO u_dto) {
		return ss.selectOne("user.user_cnt", u_dto);
	}

//	세션 저장시킬 유저정보 dto담아오기
	public UserDTO find_user(String id) {
		return ss.selectOne("user.find_user", id);
	}

//	회원가입
	public void sign_up(UserDTO u_dto) {
		ss.insert("user.sign_up", u_dto);
	}

//	아이디 중복체크
	public int id_chk(String id) {
		return ss.selectOne("user.id_chk", id);
	}
	
}
