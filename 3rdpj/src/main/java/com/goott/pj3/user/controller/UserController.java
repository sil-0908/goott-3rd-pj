package com.goott.pj3.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.goott.pj3.user.dto.UserDTO;
import com.goott.pj3.user.service.UserService;

@Controller
@RequestMapping("/user/**")
public class UserController {

	@Autowired
	UserService userService;
	
//	마이페이지 이동
	@RequestMapping("mypage")
	public String go_mypage() {
		return "user/my_page";
	}
	
//	로그인 페이지 이동
	@RequestMapping("signin")
	public String go_sign_in() {
		return "user/sign_in";
	}
	
//	회원가입 페이지 이동
	@RequestMapping("signup")
	public String go_sign_up() {
		return "user/sign_up";
	}
	
//	로그인
	@RequestMapping(value = "signin", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView signin(@RequestParam String id, @RequestParam String pw, UserDTO u_dto, HttpSession session, ModelAndView mv) {
		u_dto.setUser_id(id);
		u_dto.setPw(pw);
		int user_cnt = userService.user_cnt(u_dto);
		
		if(user_cnt == 1) {	// 회원값 있음
			UserDTO ur_dto = userService.find_user(id);
			session.setAttribute("user_id", ur_dto.getUser_id());
			session.setAttribute("auth", ur_dto.getAuth());
			session.setMaxInactiveInterval(1800);
			mv.setViewName("user/my_page");
		}
		else if(user_cnt == 0) {	// 회원값 없음
			mv.addObject("message", "아이디 또는 비밀번호를 확인해주세요");
			mv.setViewName("user/sign_in");
		}
		return mv;
	}
	
//	로그아웃
	@RequestMapping("signout")
	public String sign_out(HttpSession session) {
		session.invalidate();
		return "redirect:/user/my_page";
	}
	
//	회원가입
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String sign_up(UserDTO u_dto) {
		userService.sign_up(u_dto);
		return "redirect:/user/signin";
	}
	
//	아이디 실시간 중복체크
	@RequestMapping(value = "id_chk", method = RequestMethod.POST)
	@ResponseBody
	public int id_chk(@RequestParam String id) {
		int cnt = userService.id_chk(id);
		return cnt;
	}
	
	
}
