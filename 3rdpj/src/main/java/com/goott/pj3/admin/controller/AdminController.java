package com.goott.pj3.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.goott.pj3.admin.dto.AdminUserDTO;
import com.goott.pj3.admin.service.AdminService;
import com.goott.pj3.common.util.auth.Auth;


@Controller
@RequestMapping("/admin/**")
public class AdminController {


    @Autowired
    AdminService adminService;


    /**
     * 신진영 23.04.10 로그인 화면 호출
     */
    @RequestMapping("login")
    public String login() {
        return "admin/login";
    }



    /**
     * 신진영 23.04.10 로그인체크
     * @param dto 로그인 정보가 포함된 AdminUserDTO 객체
     * @param session 사용자 세션 정보를 저장하는 HttpSession 객체
     * @param mv 적절한 뷰를 반환하기 위한 ModelAndView 객체
     * @return 로그인 결과에 따라 적절한 뷰가 설정된 ModelAndView 객체를 반환
     */
    @RequestMapping(value = "login_check", method = RequestMethod.POST)
    public ModelAndView login_check(AdminUserDTO dto,
                                    HttpSession session, ModelAndView mv) {
        // adminService 객체의 login_check 메소드를 호출하여 로그인 자격 증명을 확인합니다.
        AdminUserDTO login_chk = adminService.login_check(dto);
        // 로그인 자격 증명이 유효한 경우, 세션 속성을 설정하고 적절한 뷰를 반환합니다.
        if (login_chk != null) {
            session.setAttribute("user_id", login_chk.getUser_id());
            session.setAttribute("auth", login_chk.getAuth());
            session.setMaxInactiveInterval(60 * 120);
            mv.setViewName("admin/main");
        // 로그인 자격 증명이 유효하지 않은 경우, 오류 메시지와 함께 로그인 페이지를 반환합니다.
        } else if (login_chk == null) {
            mv.setViewName("admin/login");
            mv.addObject("data", "error");
        }
        // ModelAndView 객체를 반환합니다.
        return mv;
    }

    /**
     * 신진영 23.04.10 로그아웃
     * @param session 현재 사용자 세션의 HttpSession 객체
     * @return 로그인 페이지로 사용자를 리디렉션하는 문자열
     */
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        // 현재 세션 무효화
        session.invalidate();
        // 사용자를 로그인 페이지로 리디렉션
        return "redirect:/admin/login";
    }


    /**
     * 신진영 23.04.10 어드민 메인 화면 호출
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("main")
    public String main() {
            return "admin/main";

    }

}


