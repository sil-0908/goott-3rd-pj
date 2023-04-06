package com.goott.pj3.admin.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.goott.pj3.admin.dto.NoticeDTO;
import com.goott.pj3.admin.repo.NoticeDAO;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Inject
	NoticeDAO noticeDAO;
	
	@Override
	public List<NoticeDTO> noticeList(String search_option, String keyword) {
		// TODO Auto-generated method stub
		return noticeDAO.noticeList(search_option, keyword);
	}

	@Override
	public void noticeinsert(NoticeDTO dto) {
		// TODO Auto-generated method stub
		noticeDAO.noticeinsert(dto);
		String category = dto.getCategory();
		if(category!="N") {
			return;
		}
	
	}

	@Override
	public NoticeDTO noticedetail(int idx) {
		// TODO Auto-generated method stub
		return noticeDAO.noticedetail(idx);
	}

	@Override
	public void noticeupdate(NoticeDTO dto) {
		// TODO Auto-generated method stub
		noticeDAO.noticeupdate(dto);
	}

	@Override
	public void noticedelete(NoticeDTO dto) {
		// TODO Auto-generated method stub
		noticeDAO.noticedelete(dto);
	}
	
	

}
