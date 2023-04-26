package com.goott.pj3.travelinfo.controller;

import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.travelinfo.dto.TravelInfoDTO;
import com.goott.pj3.travelinfo.service.TravelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/travelinfo/**")
public class TravelInfoController {

	@Autowired
	TravelInfoService travelInfoService;

	/**
	 * 23.04.07. 여행지 정보 생성 페이지 호출
	 * @return
	 */
	@RequestMapping("create")
	public ModelAndView create(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/travelinfo/travelinfo_create");
		return mv;
	}
	/**
	 * 조원재 23.04.7 여행지 정보 생성
	 * @param httpSession
	 * @param travelInfoDTO
	 * @param mv
	 * @return
	 */
	@PostMapping("create")
	public ModelAndView createPost(HttpSession httpSession, TravelInfoDTO travelInfoDTO, ModelAndView mv){
		String user_id = (String) httpSession.getAttribute("user_id");
		travelInfoDTO.setUser_id(user_id);
		int travel_location_idx = this.travelInfoService.create(travelInfoDTO);
		if(travel_location_idx == 1){
			mv.setViewName("redirect:/travelinfo/detail/"+travel_location_idx);
		}else {
			mv.setViewName("travelinfo/travelinfo_create");
		}
		return mv;
	}

	/**
	 * 조원재 23.04.08 여행지 정보 디테일 페이지 호출
	 */
	@RequestMapping("detail/{travelinfo_idx")
	public ModelAndView detail(@PathVariable int travel_location_idx,
							   TravelInfoDTO travelInfoDTO, ModelAndView mv){
		travelInfoDTO.setTravel_location_idx(travel_location_idx);
		TravelInfoDTO detail= this.travelInfoService.detail(travelInfoDTO);
		mv.addObject("data", detail);
		mv.setViewName("travelinfo/travelinfo_detail");
		return mv;
	}

//	/**
//	 * 조원재 23.04.08. 여행정보 수정 페이지 호출
//	 */
//	@RequestMapping("update")
//	public ModelAndView update(@RequestParam Map<String, Object> map) {
//		ModelAndView mv = new ModelAndView();
//		Map<String, Object> detailData = this.travelInfoService.detail(map);
//		mv.addObject("data", detailData);
//		mv.setViewName("travelinfo/travelinfo_update");
//		return mv;
//	}
//
//	/**
//	 * 조원재 23.04.08. 여행 정보 수정
//	 */
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public ModelAndView updatePost(@RequestParam Map<String, Object> map){
//		ModelAndView mv = new ModelAndView();
//		boolean update = this.travelInfoService.update(map);
//		if(update){
//			String travel_location_idx = map.get("travel_location_idx").toString();
//			mv.setViewName("redirect:/travelinfo/detail?travel_location_idx="+travel_location_idx);
//		} else {
//			mv = this.update(map);
//		}
//		return mv;
//	}
//
//	/**
//	 * 조원재 23.04.08. 여행지 정보 삭제
//	 */
//	@RequestMapping("delete")
//	public ModelAndView delete(@RequestParam Map<String, Object> map){
//		ModelAndView mv = new ModelAndView();
//		boolean delete = this.travelInfoService.delete(map);
//		if (delete){
//			mv.setViewName("redirect:/travelinfo/list");
//		} else {
//			String travel_location_idx = map.get("travel_location_idx").toString();
//			mv.setViewName("redirect:/travelinfo/detail?travel_location_idx="+travel_location_idx);
//		}
//		return mv;
//	}
//
//	@RequestMapping("list")
//	public ModelAndView list(ModelAndView mv, Criteria cri){
//		mv.addObject("paging", travelInfoService.paging(cri));
//		mv.addObject("data", travelInfoService.list(cri));
//		mv.setViewName("/travelinfo/travelinfo_list");
//		return mv;
//	}
}
