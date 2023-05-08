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
     * 여행 정보 생성
     * @param travelInfoDTO 여행 정보 생성 정보
     * @return 생성된 게시글 인덱스
     */
    @Override
    public int create(TravelInfoDTO travelInfoDTO) {
        int affectRowCnt = this.travelInfoDAO.create(travelInfoDTO);
        if(affectRowCnt==1){
            return travelInfoDTO.getTravel_location_idx();
        }
        return 0;
    }

    /**
     * 여행 정보 이미지 생성
     * @param travelInfoDTO 여행 정보 이미지 정보
     */
    @Override
    public void createImg(TravelInfoDTO travelInfoDTO) {
        this.travelInfoDAO.createImg(travelInfoDTO);
    }

    /**
     * 여행 정보 상세 페이지 호출
     * @param travelInfoDTO 상세 페이지 정보
     * @return 상세 페이지 정보 리턴
     */
    @Override
    public TravelInfoDTO detail(TravelInfoDTO travelInfoDTO) {
        return this.travelInfoDAO.detail(travelInfoDTO);
    }

    /**
     * 여행 정보 업데이트
     * @param travelInfoDTO 업데이트 할 정보
     * @return 업데이트 된 게시글 인덱스
     */
    @Override
    public int update(TravelInfoDTO travelInfoDTO) {
        int cnt = this.travelInfoDAO.update(travelInfoDTO);
        if(cnt==1){
            return travelInfoDTO.getTravel_location_idx();
        }
        return 0;
    }

    /**
     * 여행 정보 이미지 삭제
     * @param travelInfoDTO 삭제할 게시글 정보
     * @return 삭제 성공 여부
     */
    @Override
    public void deleteImg(TravelInfoDTO travelInfoDTO) {
        this.travelInfoDAO.deleteImg(travelInfoDTO);
    }

    /**
     * 여행 정보 이미지 업데이트
     * @param travelInfoDTO  업데이트 할 게시글 정보
     */
    @Override
    public void updateImg(TravelInfoDTO travelInfoDTO) {
        this.travelInfoDAO.updateImg(travelInfoDTO);
    }

    /**
     * 여행 정보 게시글 삭제
     * @param travelInfoDTO 삭제 할 게시글 정보 
     * @return 삭제 성공 여부 리턴
     */
    @Override
    public boolean delete(TravelInfoDTO travelInfoDTO) {
        int cnt = this.travelInfoDAO.delete(travelInfoDTO);
        return cnt==1;
    }

    /**
     * 이미지 목록 호출
     * @param travelInfoDTO 이미지 목록 호출하기 위한 게시글 정보  
     * @return 이미지 목록 리턴
     */
    @Override
    public List<TravelInfoDTO> imgList(TravelInfoDTO travelInfoDTO) {
        return this.travelInfoDAO.imgList(travelInfoDTO);
    }

    /**
     * 게시글 목록 조회
     * @param cri 게시글 조회 할 정보   
     * @return 게시글 목록 리턴
     */
    @Override
    public List<TravelInfoDTO> list(Criteria cri) {
        return travelInfoDAO.list(cri);
    }

    /**
     * 게시글 페이징 
     * @param cri 페이징 할 정보
     * @return 페이징 정보 리턴
     */
    @Override
    public PagingDTO paging(Criteria cri) {
        PagingDTO paging = new PagingDTO();
        paging.setCri(cri);
        paging.setTotalCount(travelInfoDAO.totalCount(cri));
        return paging;
    }

}
