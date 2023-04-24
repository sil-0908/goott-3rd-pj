package com.goott.pj3.planner.repo;

import com.goott.pj3.plan.dto.PlanDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PlannerDAO {

    @Autowired
    SqlSession ss;

    public List<PlanDTO> plannerList(PlanDTO planDTO) {
        return this.ss.selectList("planner.plannerlist", planDTO);
    }

    public List<PlanDTO> plannerDelList(PlannerDAO plannerDAO) {
        return this.ss.selectList("planner.plannerdellist", plannerDAO);
    }
}
