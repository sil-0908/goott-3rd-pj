package com.goott.pj3.plan.service;

import com.goott.pj3.plan.dto.PlanDTO;

import org.springframework.stereotype.Service;

import com.goott.pj3.plan.repo.PlanDAO;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    final
    PlanDAO planDAO;

    public PlanServiceImpl(PlanDAO planDAO) {
        this.planDAO = planDAO;
    }

    @Override
    public void planCreate(PlanDTO planDTO) {
        planDAO.create(planDTO);
    }

    @Override
    public List<PlanDTO> list() {
        return planDAO.list();
    }

    @Override
    public PlanDTO detail(int plan_idx) {
        return planDAO.detail(plan_idx);
    }

    @Override
    public void planEdit(PlanDTO planDTO) {
        planDAO.edit(planDTO);
    }

    @Override
    public void planDelete(int planIdx) {
        planDAO.delete(planIdx);
    }


}
