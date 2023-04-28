package com.goott.pj3.plan.controller;

import com.goott.pj3.plan.dto.PayDTO;
import com.goott.pj3.plan.service.PaymentService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


// 2023.04.22 길영준 결제 서버검증, DB입력
@RestController
public class PaymentController {
    private final IamportClient iamportClient;
    private final PaymentService paymentService;

    public PaymentController(IamportClient iamportClient, PaymentService paymentService) {
        this.iamportClient = iamportClient;
        this.paymentService = paymentService;
    }

    // 결제 서버검증(실제 결제한 가격이 고지된 가격과 동일한지 검증)
    @PostMapping("/verifyIamport/{imp_uid}")
    public IamportResponse<Payment> paymentByUid(@PathVariable(value = "imp_uid") String imp_uid) throws IamportResponseException, IOException {
        return iamportClient.paymentByImpUid(imp_uid);
    }

    // 결제정보 DB입력
    @PostMapping(value = "/payment/confirm", consumes = "application/json")
    public Map<String, Object> paymentConfirm(@RequestBody PayDTO payDTO) {
        System.out.println(payDTO.toString());
        boolean checkPayment = paymentService.pay(payDTO);
        Map<String, Object> map = new HashMap<String, Object>();
        if (checkPayment) {
            paymentService.saleCount(payDTO);
            map.put("msg", "결제성공");
        } else {
            map.put("msg", "결제실패");
        }
        return map;
    }


}

