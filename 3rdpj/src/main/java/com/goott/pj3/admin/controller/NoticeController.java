package com.goott.pj3.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goott.pj3.admin.dto.NoticeDTO;
import com.goott.pj3.admin.service.NoticeService;




@Controller
@RequestMapping("/admin/**")
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
//	공지사항리스트
	@RequestMapping("noticelist")
	public ModelAndView noticeList(@RequestParam(defaultValue = "all") String search_option, 
			@RequestParam(defaultValue ="") String keyword,ModelAndView mv ) {
		List<NoticeDTO> noticelist = noticeService.noticeList(search_option, keyword);
		Map<String, Object> map = new HashMap<>();
		mv.setViewName("admin/noticelist");
		map.put("search_option", search_option);
		map.put("keyword",keyword);
		mv.addObject("noticelist",noticelist);
		return mv;
	}
//	공지사항 작성
	@RequestMapping("noticewrite")
	public String noticeWrite() {
		return "admin/noticewrite";
	}
// 공지사항 데이터 넣기
	@RequestMapping("noticeinsert")
	public String insert(NoticeDTO dto, HttpSession session) {
		System.out.println(dto);
//		String writer = (String)session.getAttribute("user_id");
//		dto.setUser_id(writer);
		noticeService.noticeinsert(dto);
		return "redirect:/admin/noticelist";
	}
	
	@RequestMapping("noticedetail")
	public ModelAndView noticedetail(int idx) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/noticedetail");
		mv.addObject("dto", noticeService.noticedetail(idx));
		return mv;
	}
	
	@RequestMapping("noticeupdate")
	public String noticeupdate(NoticeDTO dto) {
		noticeService.noticeupdate(dto);
		return "redirect:/admin/noticelist";
	}

}
