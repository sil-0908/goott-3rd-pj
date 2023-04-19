package com.goott.pj3.travelinfo.service;

import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;
import com.goott.pj3.travelinfo.dto.TravelInfoDTO;
import com.goott.pj3.travelinfo.repo.TravelInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TravelInfoServiceImpl implements TravelInfoService {

	@Autowired
	TravelInfoDAO travelInfoDAO;

	/**
	 * 조원재 23.04.08. 여행지 정보 생성
	 * @param map
	 * @return
	 */
	@Override
	public String insert(Map<String, Object> map) {
		int attectRowCnt = this.travelInfoDAO.insert(map);
		if(attectRowCnt==1){
			return map.get("travel_location_idx").toString();
		}
		return null;
	}

	/**
	 * 조원재 23,04.08. 여행지 디테일 페이지
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.travelInfoDAO.detail(map);
	}

	/**
	 * 조원재 23.04.08. 여행지 정보 수정
	 * @param map
	 * @return
	 */
	@Override
	public boolean update(Map<String, Object> map) {
		// 이미지 파일 수정 없는 경우 null 값 처리 로직 필요
		int attectRowCnt = this.travelInfoDAO.update(map);
		return attectRowCnt==1;
	}

	/**
	 * 조원재 23.04.08. 여행지 정보 삭제
	 * @param map
	 * @return
	 */
	@Override
	public boolean delete(Map<String, Object> map) {
		int attectRowCnt = this.travelInfoDAO.delete(map);
		return attectRowCnt==1;
	}

	/**
	 * 조원재 23.04.08. 여행지 정보 리스트;
	 * @param map
	 * @return
	 */
	@Override
	public List<TravelInfoDTO> list(Criteria cri) {
		// TODO Auto-generated method stub
		return travelInfoDAO.list(cri);
	}

//	@Override
//	public List<Map<String, Object>> list(Map<String, Object> map) {
//		return this.travelInfoDAO.list(map);
//	}

	@Override
	public PagingDTO paging(Criteria cri) {
		PagingDTO paging = new PagingDTO();
		paging.setCri(cri);
		paging.setTotalCount(travelInfoDAO.totalCount(cri));
		return paging;
	}
}
