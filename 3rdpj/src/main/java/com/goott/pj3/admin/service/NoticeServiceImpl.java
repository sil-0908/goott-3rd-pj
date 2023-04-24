package com.goott.pj3.admin.service;

import java.util.List;

import javax.inject.Inject;

import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;
import org.springframework.stereotype.Service;

import com.goott.pj3.admin.dto.NoticeDTO;
import com.goott.pj3.admin.repo.NoticeDAO;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Inject
    NoticeDAO noticeDAO;

    /**
     * 신진영 23.04.04 공지사항 리스트
     * @param cri
     * @return
     */
    @Override
    public List<NoticeDTO> noticeList(Criteria cri) {
        return noticeDAO.noticeList(cri);
    }

    /**
     * 신진영 23.04.18 공지사항 페이징
     * @param cri
     * @return
     */
    @Override
    public PagingDTO paging(Criteria cri) {
        PagingDTO paging = new PagingDTO();
        paging.setCri(cri);
        paging.setTotalCount(noticeDAO.totalCount(cri));
        return paging;
    }

    /**
     * 신진영 23.04.04 공지사항 생성
     * @param dto
     */
    @Override
    public void noticeInsert(NoticeDTO dto) {
        // TODO Auto-generated method stub
        noticeDAO.noticeInsert(dto);
        String category = dto.getCategory();
        if (category != "N") {
            return;
        }

    }

    /**
     * 신진영 23.04.04 공지사항 상세
     * @param idx
     * @return
     */
    @Override
    public NoticeDTO noticeDetail(int idx) {
        // TODO Auto-generated method stub
        return noticeDAO.noticeDetail(idx);
    }

    /**
     * 신진영 23.04.04 공지사항 수정
     * @param dto
     */
    @Override
    public void noticeUpdate(NoticeDTO dto) {
        // TODO Auto-generated method stub
        noticeDAO.noticeUpdate(dto);
    }

    /**
     * 신진영 23.04.04 공지사항 삭제
     * @param dto
     */
    @Override
    public void noticeDelete(NoticeDTO dto) {
        // TODO Auto-generated method stub
        noticeDAO.noticeDelete(dto);
    }

    /**
     * 신진영 23.04.05 공지사항 복원
     * @param dto
     */
    @Override
    public void noticeDeleteReturn(NoticeDTO dto) {
        // TODO Auto-generated method stub
        noticeDAO.noticeDeleteReturn(dto);
    }




}
