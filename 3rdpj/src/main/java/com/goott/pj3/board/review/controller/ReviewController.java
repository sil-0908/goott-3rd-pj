package com.goott.pj3.board.review.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.goott.pj3.board.review.service.ReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/review/**")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@RequestMapping("create")
	public ModelAndView create(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/review/create");
		return mv;
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map, HttpSession httpSession){
		String userId = httpSession.getAttribute("user_id").toString();
		ModelAndView mv = new ModelAndView();
		map.put("user_id", userId);
		String review_idx = this.reviewService.create(map);
		if(review_idx.equals(null)) {
			mv.setViewName("redirect:/review/create");
		}else {
			mv.setViewName("redirect:/review/detail?review_idx="+review_idx);
		}
		return mv;
	}

	@RequestMapping("detail")
	public ModelAndView detail(@RequestParam Map<String, Object> map){
		System.out.println("detailMap : " + map);
		ModelAndView mv = new ModelAndView();
		Map<String, Object> detail = this.reviewService.detail(map);
		System.out.println(detail.toString());
		mv.addObject("data", detail);
		String review_idx = map.get("review_idx").toString();
		mv.addObject("review_idx", review_idx);
		mv.setViewName("/board/review/detail");
		return mv;
	}
}
