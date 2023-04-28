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

    @Override
    public int create(TravelInfoDTO travelInfoDTO) {
        System.out.println("serviceimpl : " + travelInfoDTO);
        int affectRowCnt = this.travelInfoDAO.create(travelInfoDTO);
        if(affectRowCnt==1){
            return travelInfoDTO.getTravel_location_idx();
        }
        return 0;
    }

    @Override
    public void createImg(TravelInfoDTO travelInfoDTO) {
        this.travelInfoDAO.createImg(travelInfoDTO);
    }

    @Override
    public TravelInfoDTO detail(TravelInfoDTO travelInfoDTO) {
        return this.travelInfoDAO.detail(travelInfoDTO);
    }

    @Override
    public int update(TravelInfoDTO travelInfoDTO) {
        int cnt = this.travelInfoDAO.update(travelInfoDTO);
        if(cnt==1){
            return travelInfoDTO.getTravel_location_idx();
        }
        return 0;
    }
    @Override
    public boolean deleteImg(TravelInfoDTO travelInfoDTO) {
        System.out.println("delImgImpl : " + travelInfoDTO );
        int affectRowCnt = this.travelInfoDAO.deleteImg(travelInfoDTO);
        if(affectRowCnt!=0){
            return true;
        }
        return false;
    }

    @Override
    public void updateImg(TravelInfoDTO travelInfoDTO) {
        System.out.println("updateImg serviceimpl : " + travelInfoDTO);
        this.travelInfoDAO.updateImg(travelInfoDTO);
    }

    @Override
    public boolean delete(TravelInfoDTO travelInfoDTO) {
        int cnt = this.travelInfoDAO.delete(travelInfoDTO);
        return cnt==1;
    }

    @Override
    public List<TravelInfoDTO> imgList(TravelInfoDTO travelInfoDTO) {
        return this.travelInfoDAO.imgList(travelInfoDTO);
    }

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

}
