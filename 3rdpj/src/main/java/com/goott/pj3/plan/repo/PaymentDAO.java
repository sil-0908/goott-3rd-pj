package com.goott.pj3.plan.repo;

import com.goott.pj3.plan.dto.PayDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

//2023.04.22 길영준
//2023.04.26 길영준 주석추가
@Repository
public class PaymentDAO {
    final
    SqlSession session;

    public PaymentDAO(SqlSession session) {
        this.session = session;
    }

    //결제하기
    public int pay(PayDTO payDTO) {
        return session.insert("plan.pay", payDTO);
    }

    // 결제된후 추가
    public void saleCount(PayDTO payDTO) {
        session.update("plan.count", payDTO); //플랜 판매횟수 증가
        session.update("plan.success", payDTO); //플래너 판매성공 횟수 증가
        session.delete("cart.subCart", payDTO); // 결제한 플랜 카트에서 제거
    }
}
