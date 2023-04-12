package com.goott.pj3.admin.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.goott.pj3.admin.dto.NoticeDTO;

@Repository
public class NoticeDAO {

	@Inject
	SqlSession sqlSession;
	
	public List<NoticeDTO> noticeList(String search_option, String keyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		return sqlSession.selectList("noticelist", map);
	}

	public void noticeinsert(NoticeDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.insert("noticeinsert", dto);
	}

	public NoticeDTO noticedetail(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("noticedetail",idx);
	}

	public void noticeupdate(NoticeDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("noticeupdate", dto);
	}

	public void noticedelete(NoticeDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.delete("noticedelete", dto);
	}

	public void noticedeletere(NoticeDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("noticedeletere", dto);
	}
	
	
}
