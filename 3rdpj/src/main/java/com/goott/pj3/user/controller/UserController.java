package com.goott.pj3.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.goott.pj3.user.dto.UserDTO;
import com.goott.pj3.user.service.UserService;

@Controller
@RequestMapping("/user/**")
public class UserController {

	@Autowired
	UserService userService;
	
	// 추가필요 : 카카오, 네이버, 구글 로그인 API / 회원가입할때 핸드폰 인증 / 비밀번호 찾기
	
//	마이페이지 이동 - 장민실 23.04.04
	@GetMapping("mypage")
	public String go_my_page() {
		return "user/my_page";
	}
	
//	회원가입 페이지 이동 - 장민실 23.04.04
	@GetMapping("signup")
	public String go_sign_up() {
		return "user/sign_up";
	}
	
//	로그인 페이지 이동 - 장민실 23.04.04
	@GetMapping("signin")
	public String go_sign_in() {
		return "user/sign_in";
	}
	
//	아이디 비밀번호 찾기 페이지 이동 - 장민실 23.04.19
	@GetMapping("find_user")
	public String go_find_user() {
		return "user/find_user";
	}
	
//	회원가입 - 장민실 23.04.04
	@PostMapping("signup")
	public String sign_up(UserDTO u_dto) {
		userService.sign_up(u_dto);
		return "redirect:/user/signin";
	}
	
//	아이디 중복체크 - 장민실 23.04.04
	@PostMapping("id_chk")
	@ResponseBody
	public int id_chk(@RequestParam String id) {
		int cnt = userService.id_chk(id);
		return cnt;
	}
	
//	로그인 - 장민실 23.04.04
	@PostMapping("signin")
	@ResponseBody
	public ModelAndView sign_in(@RequestParam("id") String id, @RequestParam("pw") String pw, UserDTO u_dto, HttpSession session, ModelAndView mav) {
		u_dto.setUser_id(id);
		u_dto.setPw(pw);
		UserDTO ur_dto = userService.sign_in(u_dto);
        Map<String, String> responseData = new HashMap<>();	
		if(ur_dto != null) {
			// 사용자 탈퇴여부 확인 추가 - 장민실 23.04.07
			String user_del_yn = ur_dto.getU_del_yn();	// 사용자 탈퇴 여부 : n=미탈퇴, y=탈퇴			
			if(user_del_yn.equals("n")) {
				session.setAttribute("user_id", ur_dto.getUser_id());
				session.setAttribute("auth", ur_dto.getAuth());
				session.setMaxInactiveInterval(1800);	// 초 단위 : 30분
				responseData.put("msg", "success");
			}	// 탈퇴하지 않은 사용자일때 if end
			else {
				responseData.put("msg", "user_del_y");
			}	// 탈퇴한 사용자일때 else if end
		}	// 사용자 있을때 if end
		else {
			responseData.put("msg", "not_user");
		}	// 사용자 없을때 else if end
		mav.setView(new MappingJackson2JsonView());
        mav.addObject("signin_msg", responseData);
		return mav;
	}
	
//	로그아웃 - 장민실 23.04.04
	@RequestMapping("sign_out")
	public String sign_out(HttpSession session) {
		session.invalidate();
		return "redirect:/user/mypage";
	}
	
//	아이디 찾기 - 장민실 23.04.13 > 현재 DB에 중복정보 다량으로 기능구현 완료 후 주석처리
//	@PostMapping("find_id")
//	@ResponseBody
//	public String find_id(@RequestParam("email") String email, @RequestParam("hp") String hp, UserDTO u_dto) {
////		휴대폰 인증기능 완료되면 휴대폰인증 추가하기
//		u_dto.setEmail(email);
//		u_dto.setHp(hp);
//		String id = userService.find_id(u_dto);
//		return id;
//	}
	
//	비밀번호 찾기 - 장민실 23.04.23
	@PostMapping("find_get_pw")
	@ResponseBody
	public int find_get_pw(@RequestParam("id") String id, @RequestParam("hp") String hp, UserDTO u_dto) {
		u_dto.setUser_id(id);
		u_dto.setHp(hp);
		int pw_cnt = userService.find_get_pw(u_dto);	// 입력정보 일치하는 비밀번호 존재여부 : 0=존재X, 1=존재O
		return pw_cnt;
	}
	
//	새로운 비밀번호 저장 - 장민실 23.04.23
//	@PostMapping("find_set_pw")
//	@ResponseBody
//	public String find_set_pw(@RequestParam("id") String id, @RequestParam("hp") String hp, @RequestParam("pw") String pw, UserDTO u_dto) {
//		u_dto.setUser_id(id);
//		u_dto.setHp(hp);
//		u_dto.setPw(pw);
//		return "redirect:/user/sign_in";
//	}
	
//	마이페이지
//	@PostMapping("mypage")
//	@ResponseBody
//	public String my_page(HttpSession session, UserDTO u_dto) {
////		세션에 저장된 id랑 권한으로 db정보 불러오기
//			유저권한일때 : 아이디, 이메일, 핸드폰번호, 프로필이미지, 포인트
//			플래너권한일때 : 아이디, 이메일, 핸드폰번호, 사업용핸드폰번호, 자기소개, 프로필이미지, 포인트, 사업자번호
//		String id = session.getId();
////		유저정보 가져오는거..그냥 로그인할때 있는 메소드에 추가해서 가져와서 이용할까..따로 만들어야 할까..
//		userService.get_user(u_dto);
//		return "user/my_page";
//	}

	

	
	
}
