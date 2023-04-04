package com.goott.pj3.admin.service;

import java.util.List;

import com.goott.pj3.admin.dto.NoticeDTO;



public interface NoticeService {

	List<NoticeDTO> noticeList(String search_option, String keyword);

	void noticeinsert(NoticeDTO dto);

	NoticeDTO noticedetail(int idx);

	void noticeupdate(NoticeDTO dto);

}
