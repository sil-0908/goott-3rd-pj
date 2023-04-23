package com.goott.pj3.plan.controller;

import com.goott.pj3.plan.dto.PayDTO;
import com.goott.pj3.plan.service.PaymentService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

// 2023.04.22 길영준 결제 서버검증, DB입력
@Controller
public class PaymentController {
    private final IamportClient iamportClient;
    private final PaymentService paymentService;

    public PaymentController(IamportClient iamportClient, PaymentService paymentService) {
        this.iamportClient = iamportClient;
        this.paymentService = paymentService;
    }
// 결제 서버검증(실제 결제한 가격이 고지된 가격과 동일한지 검증)
    @ResponseBody
    @PostMapping("/verifyIamport/{imp_uid}")
    public IamportResponse<Payment> paymentByUid(@PathVariable(value = "imp_uid") String imp_uid) throws IamportResponseException, IOException {
        return iamportClient.paymentByImpUid(imp_uid);
    }

    @ResponseBody
    @PostMapping("/payment/confirm")
    public String paymentConfirm(@RequestBody PayDTO payDTO){
        paymentService.pay(payDTO);
        System.out.println(payDTO.toString());
        return "success";
    }


}

