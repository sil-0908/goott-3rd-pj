package com.goott.pj3.admin.service;

import java.util.List;

import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.pj3.admin.dto.AdminUserDTO;
import com.goott.pj3.admin.repo.AdminUserDAO;


@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDAO adminUserDAO;


    /**
     * 신진영 23.04.05 회원리스트
     * @param cri
     * @return
     */
    @Override
    public List<AdminUserDTO> adminUserList(Criteria cri) {
        return adminUserDAO.adminUserList(cri);
    }

    /**
     * 신진영 23.04.05 회원관리 페이징
     * @param cri
     * @return
     */
    @Override
    public PagingDTO paging(Criteria cri) {
        PagingDTO paging = new PagingDTO();
        paging.setCri(cri);
        paging.setTotalCount(adminUserDAO.totalCount(cri));
        return paging;
    }

    /**
     * 신진영 23.04.05 회원상세페이지
     * @param user_id
     * @return
     */
    @Override
    public AdminUserDTO adminUserDetail(String user_id) {
        // TODO Auto-generated method stub
        return adminUserDAO.adminUserDetail(user_id);
    }

    /**
     * 신진영 23.04.05 회원 정보 수정
     * @param dto
     */
    @Override
    public void adminUserUpdate(AdminUserDTO dto) {
        // TODO Auto-generated method stub
        adminUserDAO.adminUserUpdate(dto);

    }

    /**
     * 신진영 23.04.05 회원 탈퇴
     * @param dto
     */
    @Override
    public void adminUserDelete(AdminUserDTO dto) {
        // TODO Auto-generated method stub
        adminUserDAO.adminUserDelete(dto);
    }

    /**
     * 신진영 23.04.05 회원 복원
     * @param dto
     */
    @Override
    public void adminUserDeleteReturn(AdminUserDTO dto) {
        // TODO Auto-generated method stub
        adminUserDAO.adminUserDeleteReturn(dto);
    }


}
