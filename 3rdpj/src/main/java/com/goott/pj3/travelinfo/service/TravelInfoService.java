package com.goott.pj3.travelinfo.service;

import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;
import com.goott.pj3.travelinfo.dto.TravelInfoDTO;

import java.util.List;
import java.util.Map;

public interface TravelInfoService {



    /**
     * 조원재 23.04.08. 여행지 정보 리스트
     * @param
     * @return
     */
    List<TravelInfoDTO> list(Criteria cri);

	PagingDTO paging(Criteria cri);

    int create(TravelInfoDTO travelInfoDTO);

    TravelInfoDTO detail(TravelInfoDTO travelInfoDTO);
}
