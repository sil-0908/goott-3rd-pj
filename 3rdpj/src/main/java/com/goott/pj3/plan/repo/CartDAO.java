package com.goott.pj3.plan.repo;

import com.goott.pj3.plan.dto.PlanDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//2023.04.24 길영준
@Repository
public class CartDAO {
    final
    SqlSession ss;

    public CartDAO(SqlSession sqlSession) {
        this.ss = sqlSession;
    }

    // 카트추가
    public void addCart(PlanDTO planDTO) {
        ss.insert("cart.add", planDTO);
    }

    // 카트 불러오기
    public List<PlanDTO> getCart(PlanDTO planDTO) {
        return ss.selectList("cart.get", planDTO);
    }

    // 카트삭제
    public void deleteCart(int planIdx) {
        ss.delete("cart.delete", planIdx);
    }
}
