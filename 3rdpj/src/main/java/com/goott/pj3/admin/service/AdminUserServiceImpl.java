package com.goott.pj3.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.pj3.admin.dto.AdminUserDTO;
import com.goott.pj3.admin.repo.AdminUserDAO;


@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserDAO adminUserDAO;
	
	@Override
	public List<AdminUserDTO> adminUserList() {
		// TODO Auto-generated method stub
		return adminUserDAO.adminUserList();
	}

	@Override
	public AdminUserDTO adminUserDetail(String user_id) {
		// TODO Auto-generated method stub
		return adminUserDAO.adminUserDetail(user_id);
	}

	@Override
	public void adminuserupdate(AdminUserDTO dto) {
		// TODO Auto-generated method stub
		adminUserDAO.adminuserupdate(dto);
		
	}

	@Override
	public void adminuserdelete(AdminUserDTO dto) {
		// TODO Auto-generated method stub
		adminUserDAO.adminuserdelete(dto);
	}

	@Override
	public void adminuserdeletere(AdminUserDTO dto) {
		// TODO Auto-generated method stub
		adminUserDAO.adminuserdeletere(dto);
	}


}
