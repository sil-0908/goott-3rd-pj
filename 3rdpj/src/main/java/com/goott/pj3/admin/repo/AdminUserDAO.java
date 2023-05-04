package com.goott.pj3.admin.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.goott.pj3.admin.dto.chartDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.admin.dto.AdminUserDTO;
import com.goott.pj3.common.util.paging.Criteria;


@Repository
public class AdminUserDAO {

    @Autowired
    SqlSession sqlSession;

    /**
     * 신진영 23.04.05 회원목록 리스트
     * @param cri
     * @return
     */
    public List<AdminUserDTO> adminUserList(Criteria cri) {
        // TODO Auto-generated method stub
        return sqlSession.selectList("admin.adminUserList", cri);
    }

    /**
     * 신진영 23.04.05 회원목록 페이징
     * @param cri
     * @return
     */
    public int totalCount(Criteria cri) {
        return  sqlSession.selectOne("admin.userT_Count",cri);
    }

    /**
     * 신진영 23.04.05 회원상세정보
     * @param user_id
     * @return
     */
    public AdminUserDTO adminUserDetail(String user_id) {
        // TODO Auto-generated method stub
        return sqlSession.selectOne("admin.adminUserDetail", user_id);
    }

    /**
     * 신진영 23.04.05 회원정보 수정
     * @param dto
     */
    public void adminUserUpdate(AdminUserDTO dto) {
        // TODO Auto-generated method stub
        sqlSession.update("admin.adminUserUpdate", dto);
    }

    /**
     * 신진영 23.04.05 회원 탈퇴
     * @param dto
     */
    public void adminUserDelete(AdminUserDTO dto) {
        // TODO Auto-generated method stub
        sqlSession.delete("admin.adminUserDelete", dto);
    }

    /**
     * 신진영 23.04.05 회원 탈퇴 복원
     * @param dto
     */
    public void adminUserDeleteReturn(AdminUserDTO dto) {
        // TODO Auto-generated method stub
        sqlSession.update("admin.adminUserDeleteReturn", dto);
    }


    public List<chartDTO> getUserMonthByAuth(String auth) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("auth", auth);
        return sqlSession.selectList("admin.getUserMonth", paramMap);
    }
}
