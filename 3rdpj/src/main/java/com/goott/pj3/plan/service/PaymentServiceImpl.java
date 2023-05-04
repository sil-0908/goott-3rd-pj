package com.goott.pj3.plan.service;

import com.goott.pj3.plan.dto.PayDTO;
import com.goott.pj3.plan.repo.PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//2023.04.22 길영준
//2023.04.26 길영준 주석추가
@Service
public class PaymentServiceImpl implements PaymentService {
    final
    PaymentDAO paymentDAO;

    public PaymentServiceImpl(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    // 결제가 완료되었나 확인
    @Override
    public boolean pay(PayDTO payDTO) {
        int cnt = paymentDAO.pay(payDTO);
        return cnt == 1;
    }

    //판매회수 증가
    @Override
    public void saleCount(PayDTO payDTO) {
        paymentDAO.saleCount(payDTO);
    }
}
