//package com.goott.pj3.user.controller;
//
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.goott.pj3.user.service.ApiService;
//
//import net.nurigo.sdk.NurigoApp;
//import net.nurigo.sdk.message.model.Message;
//import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
//import net.nurigo.sdk.message.response.SingleMessageSentResponse;
//import net.nurigo.sdk.message.service.DefaultMessageService;
//
//@Controller
//public class ApiController {
//	
//	@Autowired
//	ApiService apiService;
//	@Autowired
//	DefaultMessageService messageService;	
//	
//	public void coolSms() {
//		String api_key = "NCSMINAMEAOHNT2E";
//		String api_secret = "ZDOP3TRPZXKC5RVTFJU4OJU8YL3XG3KU";
//		this.messageService = NurigoApp.INSTANCE.initialize(api_key, api_secret, "https://api.coolsms.co.kr");
//	}
//	
////	8자리 랜덤 난수 생성 - 장민실 23.04.26
////	@RequestMapping("send_sms")
////	@ResponseBody
////	public String send_sms(@RequestParam("hp") String hp) {
////		Random random = new Random();
////		String ran_num = "";		
////		for (int i=0; i<8; i++) {
////			int create_num = random.nextInt(9);
////			ran_num += Integer.toString(create_num);
////		}
////		apiService.hp_certified(hp, ran_num);
////		return ran_num;
////	}
//	
//	@RequestMapping("send_sms")
//	@ResponseBody
//	public SingleMessageSentResponse send_sms(@RequestParam("hp") String hp, Message msg) {
//		Random random = new Random();
//		String ran_num = "";
//		for (int i=0; i<8; i++) {
//			int create_num = random.nextInt(9);
//			ran_num += Integer.toString(create_num);
//		}
//		msg.setFrom(hp);
//		msg.setTo(hp);
//		msg.setText("[SunTour] 인증번호는 " + ran_num + " 입니다.");
//		SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(msg));
//		return response;
//	}
//	
//
//}
