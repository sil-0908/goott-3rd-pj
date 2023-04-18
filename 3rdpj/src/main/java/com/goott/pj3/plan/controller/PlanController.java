package com.goott.pj3.plan.controller;

import com.goott.pj3.common.util.Auth;
import com.goott.pj3.common.util.S3FileUploadService;
import com.goott.pj3.plan.dto.PlanDTO;
import com.goott.pj3.user.service.UserService;
import org.springframework.stereotype.Controller;

import com.goott.pj3.plan.service.PlanService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("plan/*")
public class PlanController {

    final PlanService planService;
    final UserService userService;
    final S3FileUploadService s3FileUploadService;

    public PlanController(PlanService planService, UserService userService, S3FileUploadService s3FileUploadService) {
        this.planService = planService;
        this.userService = userService;
        this.s3FileUploadService = s3FileUploadService;
    }

    @Auth(role = Auth.Role.PLANNER)
    @GetMapping("create")
    public String planGet() {
        return "plan/plan_create";
    }

    @PostMapping("create")
    public String planPut(PlanDTO planDTO, HttpSession httpSession, @RequestParam("file") MultipartFile multipartFile) {
        String user = (String) httpSession.getAttribute("user_id");

        planDTO.setUser_id(user);
        try {
            if (multipartFile != null) {
                planDTO.setPlan_detail_img(s3FileUploadService.upload(multipartFile));
            } else {
                System.out.println("파일 어디갔냐아아아");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
