package com.goott.pj3.travelinfo.service;

import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;
import com.goott.pj3.travelinfo.dto.TravelInfoDTO;

import java.util.List;
import java.util.Map;

public interface TravelInfoService {

    /**
     * 조원재 23.04.08. 여행지 정보 생성
     * @param map
     * @return
     */
    String insert(Map<String, Object> map);

    /**
     * 조원재 23,04.08. 여행지 디테일 페이지
     * @param map
     * @return
     */
    Map<String, Object> detail(Map<String, Object> map);

    /**
     * 조원재 23.04.08. 여행지 정보 수정
     * @param map
     * @return
     */
    boolean update(Map<String, Object> map);

    /**
     * 조원재 23.04.08 여행지 정보 삭제
     * @param map
     * @return
     */
    boolean delete(Map<String, Object> map);

    /**
     * 조원재 23.04.08. 여행지 정보 리스트
     * @param map
     * @return
     */
    List<TravelInfoDTO> list(Criteria cri);

	PagingDTO paging(Criteria cri);
    
}
