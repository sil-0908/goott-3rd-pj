package com.goott.pj3.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.goott.pj3.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
}
