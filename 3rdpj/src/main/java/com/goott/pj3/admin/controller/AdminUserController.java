package com.goott.pj3.admin.controller;

import java.util.List;


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
	
// 회원목록 리스트	
	@RequestMapping("userlist")
	public ModelAndView adminUserList(ModelAndView mv) {
		List<AdminUserDTO> adminuserlist = a_u_Service.adminUserList();
		mv.setViewName("admin/adminuserlist");
		mv.addObject("adminuserlist",adminuserlist);
		return mv;
	}
// 회원 상세정보
	@RequestMapping("userdetail")
	public ModelAndView adminUserDetail(String user_id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/adminuserdetail");
		mv.addObject("dto",a_u_Service.adminUserDetail(user_id));
		return mv;
	}
// 회원정보 수정
	@RequestMapping("userupdate")
	public String adminUserUpdate(AdminUserDTO dto) {
		a_u_Service.adminuserupdate(dto);
		return "redirect:/admin/userlist";
	}
// 회원 탈퇴
	@RequestMapping("userdelete")
	public String adminUserDelete(AdminUserDTO dto) {
		a_u_Service.adminuserdelete(dto);
		return "redirect:/admin/userlist";
	}
	
}
