package com.goott.pj3.admin.service;

import java.util.List;

import com.goott.pj3.admin.dto.AdminUserDTO;


public interface AdminUserService {

	List<AdminUserDTO> adminUserList();

	AdminUserDTO adminUserDetail(String user_id);

	void adminuserupdate(AdminUserDTO dto);

	void adminuserdelete(AdminUserDTO dto);

	void adminuserdeletere(AdminUserDTO dto);

}
