package com.goott.pj3.admin.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.goott.pj3.common.util.Criteria;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.goott.pj3.admin.dto.NoticeDTO;

@Repository
public class NoticeDAO {

    @Inject
    SqlSession sqlSession;

    public List<NoticeDTO> noticeList(Criteria cri) {
        return sqlSession.selectList("admin.noticeList",cri);
    }

    public int totalCount(Criteria cri) {
        return  sqlSession.selectOne("admin.noticeT_Count",cri);
    }

    public void noticeInsert(NoticeDTO dto) {
        // TODO Auto-generated method stub
        sqlSession.insert("admin.noticeInsert", dto);
    }

    public NoticeDTO noticeDetail(int idx) {
        // TODO Auto-generated method stub
        return sqlSession.selectOne("admin.noticeDetail", idx);
    }

    public void noticeUpdate(NoticeDTO dto) {
        // TODO Auto-generated method stub
        sqlSession.update("admin.noticeUpdate", dto);
    }

    public void noticeDelete(NoticeDTO dto) {
        // TODO Auto-generated method stub
        sqlSession.delete("admin.noticeDelete", dto);
    }

    public void noticeDeleteReturn(NoticeDTO dto) {
        // TODO Auto-generated method stub
        sqlSession.update("admin.noticeDeleteReturn", dto);
    }



}
