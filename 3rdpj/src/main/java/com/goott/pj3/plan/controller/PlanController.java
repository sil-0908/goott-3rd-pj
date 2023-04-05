package com.goott.pj3.plan.controller;

import com.goott.pj3.plan.dto.PlanDTO;
import com.goott.pj3.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.goott.pj3.plan.service.PlanService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("plan/*")
public class PlanController {

    final
    PlanService planService;
    final
    UserService userService;

    public PlanController(PlanService planService, UserService userService) {
        this.planService = planService;
        this.userService = userService;
    }

    @GetMapping("create")
    public String planGet() {
        return "plan/plan_create";
    }

    @PostMapping("create")
    public String planPut(PlanDTO planDTO, HttpSession httpSession) {
        String user = (String) httpSession.getAttribute("user_id");
        planDTO.setUser_id(user);
        planService.planCreate(planDTO);
        return "redirect:/plan/list";
    }

    @GetMapping("list")
    public ModelAndView mv(ModelAndView modelAndView) {
        modelAndView.addObject("data", planService.list());
        modelAndView.setViewName("plan/plan_list");
        return modelAndView;
    }

    @GetMapping("list/{plan_idx}")
    public ModelAndView planDetail(ModelAndView modelAndView, @PathVariable int plan_idx) {
    modelAndView.addObject("data", planService.detail(plan_idx));
            modelAndView.setViewName("plan/plan_detail");
            return modelAndView;
    }




}
