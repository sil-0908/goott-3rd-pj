package com.goott.pj3.travelinfo.controller;

import com.goott.pj3.travelinfo.service.TravelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/travelinfo/**")
public class TravelInfoController {

	@Autowired
	TravelInfoService travelInfoService;

	@RequestMapping("create")
	public ModelAndView create(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/travelinfo/travelinfo_create");
		return mv;
	}
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map, HttpSession httpSession){
		String userId = httpSession.getAttribute("user_id").toString();
		ModelAndView mv = new ModelAndView();
		map.put("user_id", userId);
		String travel_loction_idx = this.travelInfoService.create(map);
		if(travel_loction_idx.equals(null)) {
			mv.setViewName("redirect:/travelinfo/travelinfo_create");
		}else {
			mv.setViewName("redirect:/travelinfo/detail?review_idx="+travel_loction_idx);
		}
		return mv;
	}
//	@RequestMapping("detail")
//	public ModelAndView detail(@RequestParam Map<String, Object> map){
//		ModelAndView mv = new ModelAndView();
//		Map<String, Object> detail = this.travelInfoService.detail(map);
//		mv.addObject("data", detail);
//		String review_idx = map.get("review_idx").toString();
//		mv.addObject("review_idx", review_idx);
//		mv.setViewName("/board/review/review_detail");
//		return mv;
//	}
//	@RequestMapping("update")
//	public ModelAndView update(@RequestParam Map<String, Object> map) {
//		ModelAndView mv = new ModelAndView();
//		Map<String, Object> detail = this.travelInfoService.detail(map);
//		mv.addObject("data", detail);
//		mv.setViewName("board/review/review_update");
//		return mv;
//	}
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public ModelAndView updatePost(@RequestParam Map<String, Object> map){
//		ModelAndView mv = new ModelAndView();
//		boolean update = this.travelInfoService.update(map);
//		if(update){
//			String review_idx = map.get("review_idx").toString();
//			mv.setViewName("redirect:/review/detail?review_idx="+review_idx);
//		} else {
//			mv = this.update(map);
//		}
//		return mv;
//	}
//	@RequestMapping("delete")
//	public ModelAndView delete(@RequestParam Map<String, Object> map){
//		ModelAndView mv = new ModelAndView();
//		boolean delete = this.travelInfoService.delete(map);
//		if (delete){
//			mv.setViewName("redirect:/review/review_list");
//		} else {
//			String review_idx = map.get("review_idx").toString();
//			mv.setViewName("redirect:/review/detail?review_idx="+review_idx);
//		}
//		return mv;
//	}
//	@RequestMapping("list")
//	public ModelAndView list(@RequestParam Map<String, Object> map){
//		System.out.println("listMap : " + map);
//		ModelAndView mv = new ModelAndView();
//		List<Map<String, Object>> reviewList = this.travelInfoService.list(map);
//		mv.addObject("data", reviewList);
//		if(map.containsKey("keyword")){
//			mv.addObject("keyword", map.get("keyword"));
//		}
//		mv.setViewName("/board/review/review_list");
//		return mv;
//	}
}
