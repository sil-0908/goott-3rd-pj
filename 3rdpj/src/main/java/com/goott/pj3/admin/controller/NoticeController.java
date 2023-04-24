package com.goott.pj3.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.goott.pj3.common.util.Auth;
import com.goott.pj3.common.util.Criteria;
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

    /**
     * 신진영 23.04.04 공지사항 리스트
     * @param mv
     * @param cri
     * @param session
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value = "noticelist", produces="application/text; charset=UTF-8;")
    public ModelAndView noticeList(ModelAndView mv, Criteria cri, HttpSession session) {
        mv.addObject("paging", noticeService.paging(cri));
        mv.addObject("noticelist", noticeService.noticeList(cri));
        mv.setViewName("admin/notice/noticelist");
        return mv;
    }

    /**
     * 신진영 23.04.04 공지사항 작성
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("noticewrite")
    public String noticeWrite() {
        return "admin/notice/noticewrite";
    }


    /**
     * 신진영 23.04.04 공지사항 입력
     * @param dto
     * @param session
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("noticeinsert")
    public String noticeInsert(NoticeDTO dto, HttpSession session) {
        String user_id = (String) session.getAttribute("user_id");
        dto.setUser_id(user_id);
        noticeService.noticeInsert(dto);
        return "redirect:/admin/notice/noticelist";
    }


    /**
     * 신진영 23.04.04 공지사항 상세페이지
     * @param idx
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("noticedetail")
    public ModelAndView noticeDetail(int idx) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/notice/noticedetail");
        mv.addObject("dto", noticeService.noticeDetail(idx));
        return mv;
    }


    /**
     * 신진영 23.04.04 공지사항 수정
     * @param dto
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("noticeupdate")
    public String noticeUpdate(NoticeDTO dto) {
        noticeService.noticeUpdate(dto);
        return "redirect:/admin/notice/noticelist";
    }


    /**
     * 신진영 23.04.04 공지사항 삭제
     * @param dto
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("noticedelete")
    public String noticeDelete(NoticeDTO dto) {
        noticeService.noticeDelete(dto);
        return "redirect:/admin/notice/noticelist";
    }


    /**
     * 신진영 23.04.04 공지사항 복원
     * @param dto
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("noticedeletere")
    public String noticeDeleteReturn(NoticeDTO dto) {
        noticeService.noticeDeleteReturn(dto);
        return "redirect:/admin/notice/noticelist";
    }

}
