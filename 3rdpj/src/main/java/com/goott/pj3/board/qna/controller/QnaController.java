package com.goott.pj3.board.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import com.goott.pj3.board.qna.dto.QnaDTO;
import com.goott.pj3.board.qna.service.QnaService;
import com.goott.pj3.common.util.paging.Criteria;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("qna/**")
public class QnaController {

	@Autowired
	QnaService qnaService;

	// 처음 qna시작화면
	@RequestMapping("main")
	public ModelAndView main(ModelAndView mv){
		mv.addObject("data_n", qnaService.list_n());
		mv.addObject("data_q", qnaService.list_q());
		mv.setViewName("board/qna/qna_main");
		return mv;
	}

	@RequestMapping("create")
	public String Enroll() {
		return "board/qna/qna_enroll";
	}

	@RequestMapping(value = "enroll", method = RequestMethod.POST)
	public String enroll(QnaDTO qnaDTO, HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		String auth = (String) session.getAttribute("auth");
		qnaDTO.setUser_id(user_id);
		qnaDTO.setAuth(auth);
		return qnaService.enroll(qnaDTO);
	}

	@RequestMapping(value = {"list_N","list_Q","list_U","list_R"}, produces="application/text; charset=UTF-8;")
	public ModelAndView list(ModelAndView mv, Criteria cri, HttpServletRequest request, HttpSession session) {
		String requestUrl = request.getRequestURL().toString();
		String auth = (String) session.getAttribute("auth");
		mv.addObject("paging", qnaService.paging(requestUrl, cri, auth));
		mv.addObject("list", qnaService.list(requestUrl, cri, auth));
		mv.setViewName("board/qna/qna_list");
		return mv;
	}

	@RequestMapping("detail/{qna_idx}")
	public ModelAndView freeDetail(ModelAndView mv, @PathVariable int qna_idx) {
		mv.addObject("data", this.qnaService.detail(qna_idx));
		mv.setViewName("board/qna/qna_detail");
		return mv;
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST, produces="text/plain; charset=UTF-8;")
	@ResponseBody
	public String modify(QnaDTO qnaDTO) {
		String category = qnaService.modify(qnaDTO);
		return category;
	}

	//
	@RequestMapping("delete")
	@ResponseBody
	public String delete(QnaDTO qnaDTO) {
		String category = qnaService.delete(qnaDTO);
		return category;
	}
}