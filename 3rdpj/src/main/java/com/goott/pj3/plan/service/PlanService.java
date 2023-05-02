package com.goott.pj3.plan.service;

import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;
import com.goott.pj3.plan.dto.ImgDTO;
import com.goott.pj3.plan.dto.PlanDTO;

import java.util.List;

//2023.04.05 길영준
public interface PlanService {


    int planCreate(PlanDTO planDTO);

    boolean planImgCreate(PlanDTO planDTO);

    List<PlanDTO> list(Criteria cri);

    PlanDTO detail(int plan_idx);

    void planEdit(PlanDTO planDTO);
    boolean planImgDelete(PlanDTO planDTO);

    void planImgUpdate(PlanDTO planDTO);

    void planDelete(int plan_idx);

    PagingDTO paging(Criteria cri);


    List<PlanDTO> imgList(PlanDTO planDTO);
}
