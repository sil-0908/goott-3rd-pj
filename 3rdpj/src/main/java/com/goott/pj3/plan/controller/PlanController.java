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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 작성 get
//    @Auth(role = Auth.Role.PLANNER)
    @GetMapping("create")
    public String planGet() {
        return "plan/plan_create";
    }

    // 작성 post
    @PostMapping("create")
    public String planPut(PlanDTO planDTO, ImgDTO imgDTO, HttpSession httpSession,
                          @RequestParam("files[]") List<MultipartFile> multipartFile) throws IOException {
        String user = (String) httpSession.getAttribute("user_id");
        planDTO.setUser_id(user);
        int plan_idx = planService.planCreate(planDTO); // 게시글 생성
        if(plan_idx!=0){ // 이미지 파일 생성
            if(multipartFile !=null || !multipartFile.isEmpty()){
                List<String> imgList = s3FileUploadService.upload(multipartFile);
                planDTO.setPlan_idx(plan_idx);
                planDTO.setP_img(imgList);
                boolean success = this.planService.planImgCreate(planDTO);
                if(success){
                    return "redirect:/plan/list";
                }
            }
        }
        return "redirect:/plan/create";
    }

    // 리스트 겟
    @GetMapping("list")
    public ModelAndView mv(ModelAndView modelAndView, Criteria cri) {
        modelAndView.addObject("paging", planService.paging(cri));
        modelAndView.addObject("data", planService.list(cri));
        modelAndView.setViewName("plan/plan_list");
        return modelAndView;
    }

    // 디테일
    @GetMapping("list/{plan_idx}")
    public ModelAndView planDetail(ModelAndView modelAndView, @PathVariable("plan_idx") int plan_idx) {

        modelAndView.addObject("data", planService.detail(plan_idx));
        modelAndView.setViewName("plan/plan_detail");
        return modelAndView;
    }

    // 수정 겟
    @GetMapping("list/edit")
    public ModelAndView planEdit(ModelAndView modelAndView, HttpSession httpSession,
                                 @RequestParam("idx") int plan_idx, @RequestParam("auth") String user_id) {
        String user = (String) httpSession.getAttribute("user_id");
        if (user.equals(user_id)) {
            modelAndView.addObject("data", planService.detail(plan_idx));
            modelAndView.setViewName("plan/plan_edit");
        } else {
            modelAndView.setViewName("/plan/plan_list");
        }
        return modelAndView;
    }

    // 수정 포스트
    @PutMapping("list/edit")
    public String planEditPut(PlanDTO planDTO, HttpSession httpSession,
                              @RequestParam("idx") int plan_idx, @RequestParam("auth") String user_id) {
        String user = (String) httpSession.getAttribute("user_id");
        if (user.equals(user_id)) {
            planDTO.setPlan_idx(plan_idx);
            planService.planEdit(planDTO);
            return "redirect:/plan/list";
        } else {
            return "redirect:/plan/list";
        }

    }

    // 삭제
    @PostMapping("list/delete")
    public String planDelete(int plan_idx) {
        System.out.println(plan_idx);
        planService.planDelete(plan_idx);
        return "redirect:/plan/list";
    }
}
