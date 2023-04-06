package com.goott.pj3.plan.service;

import com.goott.pj3.plan.dto.PlanDTO;

import java.util.List;

public interface PlanService {

    void planCreate(PlanDTO planDTO);

    List<PlanDTO> list();

    PlanDTO detail(int plan_idx);

    void planEdit(PlanDTO planDTO);

    void planDelete(int plan_idx);
}
