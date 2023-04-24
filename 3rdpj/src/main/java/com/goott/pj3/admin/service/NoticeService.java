package com.goott.pj3.admin.service;

import java.util.List;

import com.goott.pj3.admin.dto.NoticeDTO;
import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;


public interface NoticeService {

    List<NoticeDTO> noticeList(Criteria cri);

    PagingDTO paging(Criteria cri);

    void noticeInsert(NoticeDTO dto);

    NoticeDTO noticeDetail(int idx);

    void noticeUpdate(NoticeDTO dto);

    void noticeDelete(NoticeDTO dto);

    void noticeDeleteReturn(NoticeDTO dto);


}
