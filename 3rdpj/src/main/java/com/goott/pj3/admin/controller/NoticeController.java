package com.goott.pj3.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.goott.pj3.common.util.auth.Auth;
import com.goott.pj3.common.util.paging.Criteria;

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
     * 신진영 23.04.04 공지사항 리스트 페이지 요청
     * @param mv ModelAndView 객체
     * @param cri Criteria 객체
     * @return ModelAndView 객체
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value = "noticelist", produces="application/text; charset=UTF-8;")
    public ModelAndView noticeList(ModelAndView mv, Criteria cri) {
        mv.addObject("paging", noticeService.paging(cri));
        mv.addObject("noticelist", noticeService.noticeList(cri));
        mv.setViewName("admin/notice/noticelist");
        return mv;
    }

    /**
     * 신진영 23.04.04  관리자 공지사항 작성 페이지로 이동하는 메소드
     * @return 관리자 공지사항 작성 페이지
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("noticewrite")
    public String noticeWrite() {
        return "admin/notice/noticewrite";
    }


    /**
     * 신진영 23.04.04 공지사항 입력
     @param dto 등록할 공지사항 정보
     @param session 세션 객체
     @return 공지사항 목록 페이지로 리다이렉트
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("noticeinsert")
    public String noticeInsert(NoticeDTO dto, HttpSession session) {
        // 로그인한 관리자의 아이디 가져오기
        String user_id = (String) session.getAttribute("user_id");
        // 공지사항 작성자로 등록
        dto.setUser_id(user_id);
        // 공지사항 등록 서비스 호출
        noticeService.noticeInsert(dto);
        // 공지사항 목록 페이지로 리다이렉트
        return "redirect:/admin/notice/noticelist";
    }


    /**
     * 신진영 23.04.04 공지사항 상세페이지
     * @param idx 조회할 공지사항의 인덱스
     * @return ModelAndView 객체를 반환하며, 뷰 이름과 조회된 데이터를 담아 전달
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
     * @param dto : 수정할 공지사항 정보가 담긴 DTO
     * @return : 공지사항 목록 페이지로 리다이렉트
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("noticeupdate")
    public String noticeUpdate(NoticeDTO dto) {
        noticeService.noticeUpdate(dto);
        return "redirect:/admin/notice/noticelist";
    }


    /**
     * 신진영 23.04.04 공지사항 삭제
     * @param dto 공지사항 DTO
     * @return 공지사항 목록 페이지로 이동
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("noticedelete")
    public String noticeDelete(NoticeDTO dto) {
        noticeService.noticeDelete(dto);
        return "redirect:/admin/notice/noticelist";
    }


    /**
     * 신진영 23.04.04 공지사항 복원
     * @param dto 삭제 복구할 공지사항 정보를 담은 DTO
     * @return 공지사항 목록 페이지로 리다이렉트
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("noticedeletere")
    public String noticeDeleteReturn(NoticeDTO dto) {
        noticeService.noticeDeleteReturn(dto);
        return "redirect:/admin/notice/noticelist";
    }

}
