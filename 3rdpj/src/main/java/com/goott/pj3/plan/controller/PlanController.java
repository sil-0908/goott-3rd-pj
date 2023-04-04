package com.goott.pj3.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.goott.pj3.plan.service.PlanService;

@Controller
public class PlanController {

	@Autowired
	PlanService planService;
	
}
