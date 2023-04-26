package com.goott.pj3.travelinfo.service;

import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;
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
	 * 조원재 23.04.08. 여행지 정보 리스트;
	 * @param
	 * @return
	 */
	@Override
	public List<TravelInfoDTO> list(Criteria cri) {
		// TODO Auto-generated method stub
		return travelInfoDAO.list(cri);
	}

	@Override
	public PagingDTO paging(Criteria cri) {
		PagingDTO paging = new PagingDTO();
		paging.setCri(cri);
		paging.setTotalCount(travelInfoDAO.totalCount(cri));
		return paging;
	}

	@Override
	public int create(TravelInfoDTO travelInfoDTO) {
		int cnt = this.travelInfoDAO.create(travelInfoDTO);
		if (cnt==1){
			System.out.println("return idx : " + travelInfoDTO.getTravel_location_idx());
			return travelInfoDTO.getTravel_location_idx();
		}
		return 0;
	}

	@Override
	public TravelInfoDTO detail(TravelInfoDTO travelInfoDTO) {
		return this.travelInfoDAO.detail(travelInfoDTO);
	}
}
