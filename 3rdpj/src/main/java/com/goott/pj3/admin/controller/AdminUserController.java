package com.goott.pj3.admin.controller;

import java.util.List;

import com.goott.pj3.common.util.auth.Auth;
import com.goott.pj3.common.util.paging.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.goott.pj3.admin.dto.AdminUserDTO;
import com.goott.pj3.admin.service.AdminUserService;


@Controller
@RequestMapping("/admin/**")
public class AdminUserController {

    @Autowired
    AdminUserService a_u_Service;

    /**
     * 신진영 23.04.05 회원목록 리스트
     * @param mv ModelAndView 객체
     * @param cri Criteria 객체
     * @return ModelAndView
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value="userlist",produces="application/text; charset=UTF-8;")
    public ModelAndView adminUserList(ModelAndView mv, Criteria cri) {
        mv.addObject("paging", a_u_Service.paging(cri));
        mv.addObject("adminuserlist", a_u_Service.adminUserList(cri));
        mv.setViewName("admin/user/adminuserlist");
        return mv;
    }

    /**
     * 신진영 23.04.05 회원 상세정보
     * @param user_id 조회할 사용자의 아이디
     * @return ModelAndView 객체
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("userdetail")
    public ModelAndView adminUserDetail(String user_id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/user/adminuserdetail");
        mv.addObject("dto", a_u_Service.adminUserDetail(user_id));
        return mv;
    }


    /**
     * 신진영 23.04.05 회원정보 수정
     * @param dto 수정할 사용자 정보를 담은 DTO 객체
     * @return 사용자 정보 수정 후 사용자 목록 페이지로 이동합니다.
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("userupdate")
    public String adminUserUpdate(AdminUserDTO dto) {
        a_u_Service.adminUserUpdate(dto);
        return "redirect:/admin/userlist";
    }


    /**
     * 신진영 23.04.05 회원탈퇴
     * @param dto 삭제할 회원의 정보가 담긴 DTO 객체
     * @return 회원 목록 페이지로 이동
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("userdelete")
    public String adminUserDelete(AdminUserDTO dto) {
        a_u_Service.adminUserDelete(dto);
        return "redirect:/admin/userlist";
    }


    /**
     * 신진영 23.04.05 회원탈퇴 복원
     * @param dto 복구할 유저의 정보를 담고 있는 DTO 객체
     * @return 관리자 유저 리스트 페이지로 이동하는 redirect 경로
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("userdeletere")
    public String adminUserDeleteReturn(AdminUserDTO dto) {
        a_u_Service.adminUserDeleteReturn(dto);
        return "redirect:/admin/userlist";
    }

}
