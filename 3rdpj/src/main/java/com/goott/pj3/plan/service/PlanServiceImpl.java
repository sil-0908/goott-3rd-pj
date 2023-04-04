package com.goott.pj3.plan.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.goott.pj3.plan.repo.PlanDAO;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanDAO planDAO;
	
}
