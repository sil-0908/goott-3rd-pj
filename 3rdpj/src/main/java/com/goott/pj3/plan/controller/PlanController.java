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
    public ModelAndView planDetail(ModelAndView modelAndView, @PathVariable("plan_idx") int plan_idx) {
        modelAndView.addObject("data", planService.detail(plan_idx));
        modelAndView.setViewName("plan/plan_detail");
        return modelAndView;
    }

    @GetMapping("list/edit/{plan_idx}")
    public ModelAndView planEdit(ModelAndView modelAndView, @PathVariable("plan_idx") int plan_idx) {
        modelAndView.addObject("data", planService.detail(plan_idx));
        modelAndView.setViewName("plan/plan_edit");
        return modelAndView;
    }


    @PutMapping("list/edit/{plan_idx}")
    public String planEditPut(PlanDTO planDTO, @PathVariable("plan_idx") int plan_idx) {
        planDTO.setPlan_idx(plan_idx);
        planService.planEdit(planDTO);
        return "redirect:/plan/list";
    }

    @PostMapping("list/delete")
    public String planDelete(int plan_idx) {
        System.out.println(plan_idx);
        planService.planDelete(plan_idx);
        return "redirect:/plan/list";
    }


}
