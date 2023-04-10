package com.test.test.user.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.test.user.dto.UserDTO;

@Repository
public class UserDAO {

	@Autowired
	SqlSession ss;

	public void signup(UserDTO dto) {
		ss.insert("user.signup", dto);
	}

	public String getAuth(UserDTO dto) {
		return ss.selectOne("user.get_auth", dto);
	}

	public String signin(UserDTO dto) {
		return ss.selectOne("user.signin", dto);
	}

	public void toPlanner(String user_id) {
		ss.update("user.to_planner", user_id);
	}
	
}
