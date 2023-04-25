package com.goott.pj3.plan.repo;

import com.goott.pj3.plan.dto.PayDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
//2023.04.22 길영준
@Repository
public class PaymentDAO {
    final
    SqlSession session;

    public PaymentDAO(SqlSession session) {
        this.session = session;
    }

    public int pay(PayDTO payDTO) {
       return session.insert("plan.pay", payDTO);
    }

    public void saleCount(PayDTO payDTO) {
        session.insert("plan.count", payDTO);
    }
}
