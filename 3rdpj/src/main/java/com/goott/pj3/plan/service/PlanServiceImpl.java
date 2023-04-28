package com.goott.pj3.plan.service;

import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;
import com.goott.pj3.plan.dto.ImgDTO;
import com.goott.pj3.plan.dto.PlanDTO;

import org.springframework.stereotype.Service;

import com.goott.pj3.plan.repo.PlanDAO;

import java.util.List;

//2023.04.05 길영준
//2023.04.26 길영준 주석추가
@Service
public class PlanServiceImpl implements PlanService {

    final
    PlanDAO planDAO;

    public PlanServiceImpl(PlanDAO planDAO) {
        this.planDAO = planDAO;
    }

    // 플랜작성
    @Override
    public int planCreate(PlanDTO planDTO) {
        int affectRowCnt = this.planDAO.create(planDTO);
        if(affectRowCnt!=0){
            return planDTO.getPlan_idx();
        }
        return 0;
    }

    @Override
    public boolean planImgCreate(PlanDTO planDTO) {
        int affectRowCnt = this.planDAO.planImgCreate(planDTO);
        return affectRowCnt==1;
    }

    //플랜 리스트
    @Override
    public List<PlanDTO> list(Criteria cri) {
        return planDAO.list(cri);
    }

    // paging처리 - 04.18 김범수
    @Override
    public PagingDTO paging(Criteria cri) {
        PagingDTO paging = new PagingDTO();
        paging.setCri(cri);
        paging.setTotalCount(planDAO.totalConut(cri));
        return paging;
    }

    //이미지 업로드
    @Override
    public void uploadImg(ImgDTO imgDTO) {
        planDAO.uploadImg(imgDTO);
    }

    //플랜 디테일
    @Override
    public PlanDTO detail(int plan_idx) {
        return planDAO.detail(plan_idx);
    }

    //플랜 수정
    @Override
    public void planEdit(PlanDTO planDTO) {
        planDAO.edit(planDTO);
    }

    //플랜 삭제
    @Override
    public void planDelete(int planIdx) {
        planDAO.delete(planIdx);
    }

}
