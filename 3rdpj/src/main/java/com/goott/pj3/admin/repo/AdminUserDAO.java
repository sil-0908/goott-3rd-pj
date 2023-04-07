package com.goott.pj3.admin.repo;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.admin.dto.AdminUserDTO;


@Repository
public class AdminUserDAO {
	
	@Autowired
	SqlSession sqlSession;

	public List<AdminUserDTO> adminUserList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("adminuserlist");
	}

	public AdminUserDTO adminUserDetail(String user_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("adminuserdetail",user_id);
	}

	public void adminuserupdate(AdminUserDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("adminuserupdate", dto);
	}

	public void adminuserdelete(AdminUserDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.delete("adminuserdelete",dto);
	}


}
