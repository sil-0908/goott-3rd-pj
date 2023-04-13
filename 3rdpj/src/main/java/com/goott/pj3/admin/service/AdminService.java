package com.goott.pj3.admin.service;

import java.util.Map;

import com.goott.pj3.admin.dto.AdminUserDTO;


public interface AdminService {

	Map<String, Object> login_check(AdminUserDTO dto);



}
