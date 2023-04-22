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

    public void pay(PayDTO payDTO) {
        session.insert("payment.insert", payDTO);
    }
}
