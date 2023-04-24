package com.goott.pj3.admin.repo;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.admin.dto.AdminUserDTO;

@Repository
public class AdminDAO {

    @Autowired
    SqlSession ss;

    public AdminUserDTO login_check(AdminUserDTO dto) {
        // TODO Auto-generated method stub
        return ss.selectOne("admin.login_check", dto);
    }



}
