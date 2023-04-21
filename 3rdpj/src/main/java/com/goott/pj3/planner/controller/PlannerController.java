package com.goott.pj3.planner.controller;

import com.goott.pj3.common.util.Auth;
import com.goott.pj3.plan.dto.PlanDTO;
import com.goott.pj3.planner.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value="/planner/**")
public class PlannerController {

    @Autowired
    PlannerService plannerSerivce;

//    @Auth(role = Auth.Role.PLANNER)
    @RequestMapping("plannerpage")
    public ModelAndView plannerPage(HttpSession httpSession, ModelAndView mv, PlanDTO planDTO){
        String user_id = (String) httpSession.getAttribute("user_id");
        planDTO.setUser_id(user_id);
        List<PlanDTO> planData = this.plannerSerivce.plannerList(planDTO);
        List<PlanDTO> PlanDelDate = this.plannerSerivce.plannerDelList(planDTO);
        mv.addObject("data", planData);
        mv.addObject("deldata", PlanDelDate);
        mv.setViewName("/planner/planner_page");
        return mv;
    }

//    @RequestMapping("update")
//    public ModelAndView plannerUpdate(@RequestParam()){
//
//    }

}
