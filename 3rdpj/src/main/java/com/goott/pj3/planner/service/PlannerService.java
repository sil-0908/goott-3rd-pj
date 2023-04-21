package com.goott.pj3.planner.service;

import com.goott.pj3.plan.dto.PlanDTO;

import java.util.List;
import java.util.Map;

public interface PlannerService {

    List<PlanDTO> plannerList(PlanDTO planDTO);

    List<PlanDTO> plannerDelList(PlanDTO planDTO);
}
