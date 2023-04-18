package com.test.test.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.test.user.dto.UserDTO;
import com.test.test.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(UserDTO dto) {
		userService.signup(dto);
		return "signin";
	}
	
	@RequestMapping("/signin")
	public String signin() {
		return "signin";
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String signup(HttpSession ss, UserDTO dto) {
		if(userService.signin(dto) != null) {
			ss.setAttribute("id", dto.getUser_id());
			ss.setAttribute("auth", userService.getAuth(dto));
		}
		return "home";
	}
	
	@RequestMapping(value="/planner", method=RequestMethod.POST)
	public String planner(HttpSession ss, UserDTO dto) {
		ss.setAttribute("auth", userService.getAuth(dto));
		userService.toPlanner(dto.getUser_id());
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
}
