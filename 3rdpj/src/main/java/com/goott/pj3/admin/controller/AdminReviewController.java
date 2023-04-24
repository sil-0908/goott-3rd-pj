package com.goott.pj3.admin.controller;




import com.goott.pj3.admin.service.AdminReviewService;
import com.goott.pj3.common.util.Auth;
import com.goott.pj3.common.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/**")
public class AdminReviewController {

    @Autowired
    AdminReviewService reviewService;


    /**
     * 신진영 23.04.18 리뷰 목록, 검색
     * @param cri,mv
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("reviewlist")
    public ModelAndView list(Criteria cri, ModelAndView mv) {
        mv.addObject("paging", reviewService.paging(cri));
        mv.addObject("data", reviewService.list(cri));
        mv.setViewName("/admin/review/review_list");
        return mv;
    }

    /**
     * 신진영 23.04.18 리뷰 상세페이지
     * @param map
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("reviewdetail")
    public ModelAndView detail(@RequestParam Map<String, Object> map){
        ModelAndView mv = new ModelAndView();
        Map<String, Object> detail = this.reviewService.detail(map);
        mv.addObject("data", detail);
        String review_idx = map.get("review_idx").toString();
        mv.addObject("review_idx", review_idx);
        mv.setViewName("/admin/review/review_detail");
        return mv;
    }

    /**
     * 신진영 23.04.18 리뷰 수정 호출
     * @param map
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("reviewupdate")
    public ModelAndView update(@RequestParam Map<String, Object> map) {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> detail = this.reviewService.detail(map);
        mv.addObject("data", detail);
        mv.setViewName("admin/review/review_update");
        return mv;
    }

    /**
     * 신진영 23.04.18 리뷰 수정
     * @param map
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value = "reviewupdate", method = RequestMethod.POST)
    public ModelAndView updatePost(@RequestParam Map<String, Object> map){
        ModelAndView mv = new ModelAndView();
        boolean update = this.reviewService.update(map);
        if(update){
            String review_idx = map.get("review_idx").toString();
            mv.setViewName("redirect:/admin/review/reviewdetail?review_idx="+review_idx);
        } else {
            mv = this.update(map);
        }
        return mv;
    }

    /**
     * 신진영 23.04.18 리뷰 삭제
     * @param map
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("reviewdelete")
    public ModelAndView delete(@RequestParam Map<String, Object> map){
        ModelAndView mv = new ModelAndView();
        boolean delete = this.reviewService.delete(map);
        if (delete){
            mv.setViewName("redirect:/admin/reviewlist");
        } else {
            String review_idx = map.get("review_idx").toString();
            mv.setViewName("redirect:/admin/review/reviewdetail?review_idx="+review_idx);
        }
        return mv;
    }



}
