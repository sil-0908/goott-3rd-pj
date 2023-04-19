package com.goott.pj3.board.free.controller;

import javax.servlet.http.HttpSession;

import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.goott.pj3.board.free.dto.FreeBoardDTO;
import com.goott.pj3.board.free.service.FreeBoardService;

@Controller
@RequestMapping("free/**")
public class FreeBoardController {

	@Autowired
	FreeBoardService freeBoardService;

	@RequestMapping("create")
	public String Enroll() {
		return "board/free/free_enroll";
	}

	@RequestMapping(value = "enroll", method = RequestMethod.POST)
	public String enroll(FreeBoardDTO freeDto, HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		freeDto.setUser_id(user_id);
		freeBoardService.enroll(freeDto);
		return "redirect:/free/list";
	}

	@RequestMapping("list")
	public ModelAndView free(ModelAndView mv, Criteria cri) {
		PagingDTO paging = new PagingDTO();
		paging.setCri(cri); // page / perpagenum 설정
		paging.setTotalCount(freeBoardService.totalCount(cri)); // 총게시글 갯수 불러오는 것
		System.out.println("1:"+paging);
		System.out.println("2:"+freeBoardService.list(cri));
		mv.addObject("paging", paging);
		mv.addObject("list", freeBoardService.list(cri));
		mv.setViewName("board/free/free_list");
		return mv;
	}

	@RequestMapping("detail/{free_idx}")
	public ModelAndView freeDetail(ModelAndView mv, @PathVariable int free_idx) {
		mv.addObject("data", this.freeBoardService.detail(free_idx));
		mv.setViewName("board/free/free_detail");
		return mv;
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST, produces="application/text; charset=UTF-8;")
	@ResponseBody
	public String modify(FreeBoardDTO boardDTO) {
		freeBoardService.modify(boardDTO);
		return "수정완료";
	}
//	
@RequestMapping("delete")
public String delete(int free_idx) {
	freeBoardService.delete(free_idx);
	return "redirect:/free/list";
}
}
