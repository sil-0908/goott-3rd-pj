package com.goott.pj3.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.goott.pj3.admin.dto.AdminDTO;
import com.goott.pj3.admin.dto.AdminUserDTO;
import com.goott.pj3.admin.repo.AdminDAO;
import com.goott.pj3.admin.service.AdminService;
import com.goott.pj3.user.dto.UserDTO;

@Controller
@RequestMapping("/admin/**")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	// 어드민 로그인 페이지로 이동
	@RequestMapping("login")
	public String login() {
		return "admin/login";
	}
	
	//	로그인
	@RequestMapping("login_check")
	public ModelAndView login_check(AdminUserDTO dto, HttpSession session, ModelAndView mv) {
		String login_chk = adminService.login_check(dto);
		if(login_chk != null) {	// 회원값 있음
			session.setAttribute("user_id", dto.getUser_id());
			session.setAttribute("auth", dto.getAuth());
			session.setMaxInactiveInterval(1800);
			mv.setViewName("admin/main");
		}
		else {	// 회원값 없음
			mv.setViewName("admin/login");
			mv.addObject("message", "아이디 또는 비밀번호를 확인해주세요");
		}
		return mv;
	}
	
//	로그아웃
	@RequestMapping("signout")
	public String sign_out(HttpSession session) {
		session.invalidate(); // 세션만료
		return "redirect:/user/my_page";
	}
	
	
}
