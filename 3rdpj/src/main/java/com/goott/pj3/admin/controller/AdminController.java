package com.goott.pj3.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.goott.pj3.common.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.goott.pj3.admin.dto.AdminUserDTO;
import com.goott.pj3.admin.service.AdminService;


@Controller
@RequestMapping("/admin/**")
public class AdminController {


    @Autowired
    AdminService adminService;


    /**
     * 신진영 23.04.10 로그인 화면 호출
     * @return
     */
    @RequestMapping("login")
    public String login() {
        return "admin/login";
    }



    /**
     * 신진영 23.04.10 로그인체크
     * @param dto
     * @param session
     * @param mv
     * @return
     */
    @RequestMapping(value = "login_check", method = RequestMethod.POST)
    public ModelAndView login_check(AdminUserDTO dto,
                                    HttpSession session, ModelAndView mv) {
        AdminUserDTO login_chk = adminService.login_check(dto);
        if (login_chk != null) {
            session.setAttribute("user_id", login_chk.getUser_id());
            session.setAttribute("auth", login_chk.getAuth());
            session.setMaxInactiveInterval(60 * 120);
            mv.setViewName("admin/main");

        } else if (login_chk == null) {
            mv.setViewName("admin/login");
            mv.addObject("data", "error");
        }
        return mv;
    }

    /**
     * 신진영 23.04.10 로그아웃
     * @param session
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }


    /**
     * 신진영 23.04.10 어드민 메인
     * @param session
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("main")
    public String main(HttpSession session) {
            return "admin/main";

    }

}


