package com.goott.pj3.travelinfo.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.travelinfo.dto.TravelInfoDTO;

import java.util.List;
import java.util.Map;

@Repository
public class TravelInfoDAO {

	@Autowired
	SqlSession ss;

	/**
	 * 조원재 23.04.08. 여행지 정보 생성
	 * @param map
	 * @return
	 */
	public int insert(Map<String, Object> map) {
		return this.ss.insert("travelinfo.insert", map);
	}
	/**
	 * 조원재 23.04.08. 여행지 정보 디테일 정보 호출
	 * @param map
	 * @return
	 */
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.ss.selectOne("travelinfo.detail", map);
	}
	/**
	 * 조원재 23.04.08. 여행지 정보 수정
	 * @param map
	 * @return
	 */
	public int update(Map<String, Object> map) {
		return this.ss.update("travelinfo.update", map);
	}
	/**
	 * 조원재 23.04.08 여행지 정보 삭제
	 * @param map
	 * @return
	 */
	public int delete(Map<String, Object> map) {
		return this.ss.delete("travelinfo.delete", map);
	}

	/**
	 * 조원재 23.04.08. 여행지 정보 리스트
	 * @param map
	 * @return
	 */
	public List<TravelInfoDTO> list(Criteria cri) {
		return ss.selectList("travelinfo.list", cri);
	}
	
	public int totalCount(Criteria cri) {
		return ss.selectOne("travelinfo.totalCount", cri);
	}
}
