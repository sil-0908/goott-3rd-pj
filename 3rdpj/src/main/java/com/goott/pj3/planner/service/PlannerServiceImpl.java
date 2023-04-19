package com.goott.pj3.planner.service;

import com.goott.pj3.plan.dto.PlanDTO;
import com.goott.pj3.planner.repo.PlannerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlannerServiceImpl implements PlannerService{

    @Autowired
    PlannerDAO plannerDAO;

    @Override
    public List<PlanDTO> plannerList(PlanDTO planDTO) {
        return this.plannerDAO.plannerList(planDTO);
    }

    @Override
    public List<PlanDTO> plannerDelList(PlanDTO planDTO) {
        return this.plannerDAO.plannerDelList(plannerDAO);
    }
}
