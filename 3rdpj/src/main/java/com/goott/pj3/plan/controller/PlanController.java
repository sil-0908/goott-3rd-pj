package com.goott.pj3.plan.controller;

import com.goott.pj3.common.util.auth.Auth;
import com.goott.pj3.common.util.aws.S3FileUploadService;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.plan.dto.ImgDTO;
import com.goott.pj3.plan.dto.PlanDTO;
import com.goott.pj3.user.service.UserService;
import org.springframework.stereotype.Controller;
import com.goott.pj3.plan.service.PlanService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
//2023.04.05 길영준
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
    public String planPut(PlanDTO planDTO, ImgDTO imgDTO, HttpSession httpSession, @RequestParam("files[]") List<MultipartFile> multipartFile) {
        String user = (String) httpSession.getAttribute("user_id");
        planDTO.setUser_id(user);
        planService.planCreate(planDTO);
        int idx = planDTO.getPlan_idx();
        imgDTO.setPlan_idx(idx);
        try {
            List<String> img = s3FileUploadService.upload(multipartFile);
            if (!img.get(0).isEmpty()) {
                imgDTO.setImg1(img.get(0));
            }
            if (!img.get(1).isEmpty()) {
                imgDTO.setImg2(img.get(1));
            }
            if (!img.get(2).isEmpty()) {
                imgDTO.setImg3(img.get(2));
            }
            if (!img.get(3).isEmpty()) {
                imgDTO.setImg4(img.get(3));
            }
            if (!img.get(4).isEmpty()) {
                imgDTO.setImg5(img.get(4));
            }
            if (!img.get(5).isEmpty()) {
                imgDTO.setImg6(img.get(5));
            }
            if (!img.get(6).isEmpty()) {
                imgDTO.setImg7(img.get(6));
            }
            if (!img.get(7).isEmpty()) {
                imgDTO.setImg8(img.get(7));
            }
            if (!img.get(8).isEmpty()) {
                imgDTO.setImg9(img.get(8));
            }
            if (!img.get(9).isEmpty()) {
                imgDTO.setImg10(img.get(9));
            }
            planService.uploadImg(imgDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/plan/list";
    }

    @GetMapping("list")
    public ModelAndView mv(ModelAndView modelAndView, Criteria cri) {
        modelAndView.addObject("paging", planService.paging(cri));
        modelAndView.addObject("data", planService.list(cri));
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
