package com.goott.pj3.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.pj3.admin.dto.AdminUserDTO;
import com.goott.pj3.admin.repo.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDAO;

	@Override
	public String login_check(AdminUserDTO dto) {
		// TODO Auto-generated method stub
		return adminDAO.login_check(dto);
	}
	
}
