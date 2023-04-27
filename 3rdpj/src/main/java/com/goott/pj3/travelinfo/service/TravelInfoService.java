package com.goott.pj3.travelinfo.service;

import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;
import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.travelinfo.dto.TravelInfoDTO;

import java.util.List;
import java.util.Map;

public interface TravelInfoService {

    int create(TravelInfoDTO travelInfoDTO);

    void createImg(TravelInfoDTO travelInfoDTO);

    TravelInfoDTO detail(TravelInfoDTO travelInfoDTO);

    int update(TravelInfoDTO travelInfoDTO);

    void deleteImg(TravelInfoDTO travelInfoDTO);

    void updateImg(TravelInfoDTO travelInfoDTO);

    boolean delete(TravelInfoDTO travelInfoDTO);

    List<TravelInfoDTO> imglist(TravelInfoDTO travelInfoDTO);

    List<TravelInfoDTO> list(Criteria cri);

    PagingDTO paging(Criteria cri);
}
