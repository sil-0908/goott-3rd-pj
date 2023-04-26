package com.goott.pj3.plan.repo;

import com.goott.pj3.plan.dto.PlanDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDAO {
    final
    SqlSession ss;

    public CartDAO(SqlSession sqlSession) {
        this.ss = sqlSession;
    }

    public void addCart(PlanDTO planDTO) {
        ss.insert("cart.add", planDTO);
    }

    public List<PlanDTO> getCart(PlanDTO planDTO) {
        return ss.selectList("cart.get", planDTO);
    }

    public void deleteCart(int planIdx) {
        ss.delete("cart.delete", planIdx);
    }
}
