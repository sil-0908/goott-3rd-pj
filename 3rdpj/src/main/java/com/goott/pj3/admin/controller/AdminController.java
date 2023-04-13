package com.goott.pj3.admin.controller;

import java.util.HashMap;
import java.util.Map;

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

    // 로그인
    @RequestMapping(value = "/admin/login_check", method = RequestMethod.POST)
    public ModelAndView login_check(@RequestParam String user_id, String pw, AdminUserDTO dto,
            HttpSession session, ModelAndView mv) {

        dto.setUser_id(user_id);
        dto.setPw(pw);

        Map<String, Object> map = adminService.login_check(dto);
        
        if (map != null) { // 회원값 있음
            session.setAttribute("user_id", map.get("user_id"));
			session.setAttribute("auth", map.get("auth"));
            session.setMaxInactiveInterval(1800);
            mv.setViewName("redirect:/admin/main");
        } else { // 회원값 없음
            mv.setViewName("redirect:/admin/login");
        }
        return mv;
    }

    // logout
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate(); // session expires
        return "redirect:/admin/noticelist";
    }

    @RequestMapping("main")
    public ModelAndView main(HttpSession session, ModelAndView mv) {
    	System.out.println(session.getAttribute("auth"));
        if ("auth_a".equals(session.getAttribute("auth"))) {
            mv.setViewName("admin/main");
        } else if(session.getAttribute("auth") == null) {
            mv.setViewName("admin/login");
        } else {
        	mv.setViewName("admin/login");
        }
        return mv;
    }

}
	

