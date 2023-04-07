package com.goott.pj3.plan.repo;

import com.goott.pj3.plan.dto.PlanDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanDAO {

    final
    SqlSession ss;

    public PlanDAO(SqlSession ss) {
        this.ss = ss;
    }

    public void create(PlanDTO planDTO) {
        ss.insert("plan.create", planDTO);
    }

    public List<PlanDTO> list() {
        return ss.selectList("plan.list");
    }


    public PlanDTO detail(int plan_idx) {
        return  ss.selectOne("plan.detail", plan_idx);
    }

    public void edit(PlanDTO planDTO) {
        ss.update("plan.edit", planDTO);
    }

    public void delete(int plan_idx) {
        ss.delete("plan.delete", plan_idx);
    }
}
