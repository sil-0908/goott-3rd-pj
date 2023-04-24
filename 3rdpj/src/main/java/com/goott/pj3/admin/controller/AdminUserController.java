package com.goott.pj3.admin.controller;

import java.util.List;


import com.goott.pj3.common.util.Auth;
import com.goott.pj3.common.util.Criteria;
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
     * @param mv
     * @param cri
     * @return
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
     * @param user_id
     * @return
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
     * @param dto
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("userupdate")
    public String adminUserUpdate(AdminUserDTO dto) {
        a_u_Service.adminUserUpdate(dto);
        return "redirect:/admin/userlist";
    }


    /**
     * 신진영 23.04.05 회원탈퇴
     * @param dto
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("userdelete")
    public String adminUserDelete(AdminUserDTO dto) {
        a_u_Service.adminUserDelete(dto);
        return "redirect:/admin/userlist";
    }


    /**
     * 신진영 23.04.05 회원탈퇴 복원
     * @param dto
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("userdeletere")
    public String adminUserDeleteReturn(AdminUserDTO dto) {
        a_u_Service.adminUserDeleteReturn(dto);
        return "redirect:/admin/userlist";
    }

}
