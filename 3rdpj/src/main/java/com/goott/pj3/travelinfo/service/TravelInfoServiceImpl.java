package com.goott.pj3.travelinfo.service;

import com.goott.pj3.travelinfo.repo.TravelInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TravelInfoServiceImpl implements TravelInfoService {

	@Autowired
	TravelInfoDAO travelInfoDAO;

	@Override
	public String create(Map<String, Object> map) {
		int cnt = this.travelInfoDAO.insert(map);
		if(cnt==1){
			return map.get("travel_location_idx").toString();
		}
		return null;
	}

//	@Override
//	public Map<String, Object> detail(Map<String, Object> map) {
//		return this.travelInfoDAO.detail(map);
//	}
//
//	@Override
//	public boolean update(Map<String, Object> map) {
//		int affectRowCnt = this.travelInfoDAO.update(map);
//		return affectRowCnt == 1;
//	}
//
//	@Override
//	public boolean delete(Map<String, Object> map) {
//		int affectRowCnt = this.travelInfoDAO.delete(map);
//		return affectRowCnt==1;
//	}
//
//	@Override
//	public List<Map<String, Object>> list(Map<String, Object> map) {
//		return this.travelInfoDAO.list(map);
//	}
}
