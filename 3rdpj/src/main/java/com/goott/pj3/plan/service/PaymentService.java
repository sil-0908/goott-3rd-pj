package com.goott.pj3.plan.service;

import com.goott.pj3.plan.dto.PayDTO;

//2023.04.22 길영준
public interface PaymentService {

    boolean pay(PayDTO payDTO);

    void saleCount(PayDTO payDTO);
}
