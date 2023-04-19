package com.goott.pj3.user.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.user.dto.UserDTO;

@Repository
public class UserDAO {

	@Autowired
	SqlSession ss;
	
//	회원가입 - 장민실 23.04.04
	public void sign_up(UserDTO u_dto) {
		ss.insert("user.sign_up", u_dto);
	}

//	아이디 중복체크 - 장민실 23.04.04
	public int id_chk(String id) {
		return ss.selectOne("user.id_chk", id);
	}

//	로그인 - 장민실 23.04.04
	public UserDTO sign_in(UserDTO u_dto) {
		return ss.selectOne("user.sign_in", u_dto);
	}

//	DB의 암호화 비밀번호 가져오기 - 장민실 23.04.11
	public String get_hashed_pw(UserDTO u_dto) {
		return ss.selectOne("user.get_hashed_pw", u_dto);
	}
	
//	아이디찾기 - 장민실 23.04.13
	public String find_id(UserDTO u_dto) {
		return ss.selectOne("user.find_id", u_dto);
	}

//	사용자 탈퇴여부
	public String del_yn(UserDTO u_dto) {
		return ss.selectOne("user.del_yn", u_dto);
	}
	
}
