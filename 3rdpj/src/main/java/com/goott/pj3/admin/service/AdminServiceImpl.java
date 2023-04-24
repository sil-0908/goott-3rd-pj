package com.goott.pj3.admin.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.pj3.admin.dto.AdminUserDTO;
import com.goott.pj3.admin.repo.AdminDAO;
import com.goott.pj3.user.dto.UserDTO;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO adminDAO;

    /**
     * 신진영 23.04.10 로그인체크
     * @param dto
     * @return
     */
    @Override
    public AdminUserDTO login_check(AdminUserDTO dto) {
        // TODO Auto-generated method stub
        return adminDAO.login_check(dto);
    }


}
