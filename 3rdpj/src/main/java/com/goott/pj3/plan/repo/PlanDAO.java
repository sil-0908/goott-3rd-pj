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


    public PlanDTO detail(int planIdx) {
        return  ss.selectOne("plan.detail", planIdx);
    }
}
