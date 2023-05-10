//package com.goott.pj3.user.controller;
//
//import java.util.Random;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import net.nurigo.sdk.NurigoApp;
//import net.nurigo.sdk.message.model.Message;
//import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
//import net.nurigo.sdk.message.response.SingleMessageSentResponse;
//import net.nurigo.sdk.message.service.DefaultMessageService;
//
//// 장민실 23.05.09
//@RestController
////@RequestMapping("/api/**")
//public class ApiController {
////	
//	final DefaultMessageService messageService;
//	
//	public ApiController() {
//		this.messageService = NurigoApp.INSTANCE.initialize("NCSMINAMEAOHNT2E", "ZDOP3TRPZXKC5RVTFJU4OJU8YL3XG3KU", "https://api.coolsms.co.kr");
//	}
////	
////	@PostMapping("send_sms")
////	@ResponseBody
////	public SingleMessageSentResponse send_sms(@RequestParam("hp") String hp) {
////		Message msg = new Message();
////		msg.setFrom(hp);
////		msg.setTo(hp);
////		msg.setText("[SunTour] 인증번호는 [] 입니다.");
////		SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(msg));
////		return response;
////	}
//	
//	
//	
//    @PostMapping("/send-one")
//    public SingleMessageSentResponse sendOne() {
//        Message message = new Message();
//        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
//        message.setFrom("발신번호 입력");
//        message.setTo("수신번호 입력");
//        message.setText("한글 45자, 영자 90자 이하 입력되면 자동으로 SMS타입의 메시지가 추가됩니다.");
//
//        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
//        System.out.println(response);
//
//        return response;
//    }
//	
//
//}
