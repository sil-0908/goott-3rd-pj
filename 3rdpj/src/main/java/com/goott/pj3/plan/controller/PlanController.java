package com.goott.pj3.plan.controller;

import com.goott.pj3.common.util.auth.Auth;
import com.goott.pj3.common.util.aws.S3FileUploadService;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.plan.dto.ImgDTO;
import com.goott.pj3.plan.dto.PlanDTO;
import com.goott.pj3.user.service.UserService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import com.goott.pj3.plan.service.PlanService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//2023.04.05 길영준
@Controller
@RequestMapping("plan/*")
public class PlanController {

    final PlanService planService;
    final UserService userService;
    final S3FileUploadService s3FileUploadService;

    //생성자 의존성 주입
    public PlanController(PlanService planService, UserService userService, S3FileUploadService s3FileUploadService) {
        this.planService = planService;
        this.userService = userService;
        this.s3FileUploadService = s3FileUploadService;
    }

    // 작성 get
    @Auth(role = Auth.Role.PLANNER)
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
            if(multipartFile !=null || !multipartFile.isEmpty()){ // 이미지 파일 있으면
                List<String> imgUrlList = s3FileUploadService.upload(multipartFile); // 서버에 이미지 파일 저장 후 URL값 List에 담기
                planDTO.setPlan_idx(plan_idx); // 게시글 인덱스 set
                planDTO.setP_img(imgUrlList); // 이미지 url set
                boolean success = this.planService.planImgCreate(planDTO); // 이미지 저장 성공
                if(success){
                    return "redirect:/plan/list";
                }
            }
        }
        return "/plan/plan_create";
    }

    // 리스트 겟
    @GetMapping("list")
    public ModelAndView mv(ModelAndView modelAndView, Criteria cri, PlanDTO planDTO) {
        List<PlanDTO> originalList = planService.imgList(planDTO);
        List<PlanDTO> newList = new ArrayList<>(); // 인덱스+첫번째 이미지 값만 있는 dto 담을 List
        for(PlanDTO dto : originalList){
            List<String> planImgList = dto.getP_img(); // 이미지만 List에 담기
            if(planImgList != null && !planImgList.isEmpty()){ //  이미지가 있는 경우
                String firstImg = planImgList.get(0); // 첫번째 이미지 변수에 담기
                PlanDTO newDto = new PlanDTO(); // 인덱스+첫번째 이미지 값 담을 dto
                newDto.setPlan_idx(dto.getPlan_idx()); // 인덱스 담기
                newDto.setP_img(Collections.singletonList(firstImg)); // 첫번째 이미지 담기
                newList.add(newDto);
            }
        }
        modelAndView.addObject("imgList", newList);
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
    @PostMapping("list/edit")
    public String planEditPut(PlanDTO planDTO, HttpSession httpSession,
                              @RequestParam("idx") int plan_idx, @RequestParam("auth") String user_id,
                              @RequestParam("files[]") List<MultipartFile> multipartFiles) {
        System.out.println("이미지 파일 : " + multipartFiles);
        String user = (String) httpSession.getAttribute("user_id");
        if (user.equals(user_id)) {
            planDTO.setPlan_idx(plan_idx);
            planService.planEdit(planDTO); // 게시글 업데이트 (이미지 제외)
            for (String fileName : planService.detail(plan_idx).getP_img()) { // list에 담겨있는 URL값 가져오기
                s3FileUploadService.deleteFromS3(fileName); // s3서버 이미지 파일 삭제
            }
            boolean success = planService.planImgDelete(planDTO); // 기존 이미지 파일 삭제
            System.out.println("test : " + success);
            if(success){  // 이미지 업데이트
                try {
                    if (multipartFiles != null || !multipartFiles.isEmpty()) {
                        List<String> imgList = s3FileUploadService.upload(multipartFiles);
                        planDTO.setP_img(imgList);
                        planDTO.setPlan_idx(plan_idx);
                        this.planService.planImgUpdate(planDTO);
                    }
                } catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
            return "redirect:/plan/list";
        } else {
            return "redirect:/plan/list";
        }
    }
    // 삭제
    @PostMapping("list/delete")
    public String planDelete(int plan_idx, PlanDTO planDTO) {
        planDTO.setPlan_idx(plan_idx);
        planService.planDelete(plan_idx); // 게시글 삭제
        for (String fileName : planService.detail(plan_idx).getP_img()) {
            s3FileUploadService.deleteFromS3(fileName); // s3서버 이미지 파일 삭제
        }
        planService.planImgDelete(planDTO); // 이미지 삭제
        return "redirect:/plan/list";
    }
}
