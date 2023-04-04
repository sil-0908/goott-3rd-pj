package com.goott.pj3.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.goott.pj3.admin.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
}
