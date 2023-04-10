package com.goott.pj3.admin.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.admin.dto.AdminUserDTO;

@Repository
public class AdminDAO {

	@Autowired
	SqlSession ss;

	public String login_check(AdminUserDTO dto) {
		// TODO Auto-generated method stub
		return ss.selectOne("admin.login_check", dto);
	}
	
}
