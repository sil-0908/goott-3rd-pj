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

    // 로그인
    @RequestMapping(value = "/admin/login_check", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login_check(@RequestParam String user_id, String pw, AdminUserDTO dto,
            HttpSession session, ModelAndView mv) {
        dto.setUser_id(user_id);
        dto.setPw(pw);
        String login_chk = adminService.login_check(dto);
        if (login_chk != null) { // 회원값 있음
            session.setAttribute("user_id", dto.getUser_id());
            session.setAttribute("auth", dto.getAuth());
            session.setMaxInactiveInterval(1800);
            mv.setViewName("redirect:/admin/main");
            mv.addObject("message","success");
        } else { // 회원값 없음
            mv.addObject("message", "아이디 또는 비밀번호를 확인해주세요");
            mv.setViewName("admin/login");
        }
        return mv;
    }

    // log out
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate(); // session expires
        return "redirect:/admin/noticelist";
    }

    @RequestMapping("main")
    public ModelAndView main(HttpSession session, ModelAndView mv) {
        if (session.getAttribute("user_id") != null && session.getAttribute("auth") != null) {
            mv.setViewName("admin/main");
        } else {
            mv.setViewName("redirect:/admin/login");
        }
        return mv;
    }

}
	

