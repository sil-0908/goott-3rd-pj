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
//@RequestMapping("/api/**")
//public class ApiController {
//	
//	final DefaultMessageService messageService;
//	
//	public ApiController() {
//		String api_key = "NCSMINAMEAOHNT2E";
//		String api_secret = "ZDOP3TRPZXKC5RVTFJU4OJU8YL3XG3KU";
//		this.messageService = NurigoApp.INSTANCE.initialize(api_key, api_secret, "https://api.coolsms.co.kr");
//	}
//	
//	@PostMapping("send_sms")
//	@ResponseBody
//	public SingleMessageSentResponse send_sms(@RequestParam("hp") String hp) {
//		Random random = new Random();
//		String ran_num = "";
//		for (int i=0; i<8; i++) {
//			int create_num = random.nextInt(9);
//			ran_num += Integer.toString(create_num);
//		}
//		Message msg = new Message();
//		msg.setFrom(hp);
//		System.out.println("from : " + msg.getFrom());
//		msg.setTo(hp);
//		System.out.println("to : " + msg.getTo());
//		msg.setText("[SunTour] 인증번호는 [" + ran_num + "] 입니다.");
//		System.out.println("text : " + msg.getText());
//		SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(msg));
//		System.out.println("response : " + response);
//		return response;
//	}
//	
//
//}
