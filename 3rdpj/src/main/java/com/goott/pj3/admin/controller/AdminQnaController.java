
package com.goott.pj3.admin.controller;

import com.goott.pj3.admin.dto.NoticeDTO;
import com.goott.pj3.admin.service.AdminQnaService;
import com.goott.pj3.board.free.dto.FreeBoardDTO;
import com.goott.pj3.board.qna.dto.QnaDTO;
import com.goott.pj3.common.util.auth.Auth;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/**")
public class AdminQnaController {

    @Autowired
    AdminQnaService qnaService;

    /**
     * 신진영 23.04.19 Q&A 목록
     * @param mv ModelAndView 객체
     * @param cri Criteria 객체
     * @return ModelAndView 객체
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("qnalist")
    public ModelAndView qnaList(ModelAndView mv, Criteria cri) {
        // 페이징 정보 추가
        mv.addObject("paging", qnaService.paging(cri));
        // Q&A 목록 추가
        mv.addObject("qnaList", qnaService.qnaList(cri));
        // 뷰 이름 설정
        mv.setViewName("admin/qna/qnalist");
        // ModelAndView 객체 반환
        return mv;
    }

    /**
     * 신진영 23.04.19 Q&A 작성페이지 호출
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("qnawrite")
    public String qnaCreate() {
        return "admin/qna/qnawrite";
    }

    /**
     * 신진영 23.04.19 Q&A 작성 처리
     * @param dto QnaDTO 객체
     * @param session HttpSession 객체
     * @return String 형태의 리다이렉트 경로
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value = "qnawrite", method = RequestMethod.POST)
    public String qnaInsert(QnaDTO dto, HttpSession session) {
        // 세션에서 사용자 ID 가져오기
        String user_id = (String) session.getAttribute("user_id");
        // QnaDTO에 사용자 ID 설정
        dto.setUser_id(user_id);
        // Q&A 데이터베이스에 삽입
        qnaService.qnaInsert(dto);
        // qnalist 페이지로 리다이렉트
        return "redirect:/admin/qnalist";
    }



     /**
     신진영 23.04.19 QnA 상세조회
     @param mv ModelAndView 객체
     @param qna_idx 조회할 QnA의 인덱스
     @return ModelAndView 객체
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("qnadetail/{qna_idx}")
    public ModelAndView qnaDetail(ModelAndView mv, @PathVariable int qna_idx) {
        mv.addObject("data", this.qnaService.qnaDetail(qna_idx));
        mv.setViewName("admin/qna/qnadetail");
        return mv;
    }

    /**
     * 신진영 23.04.19 QnA 수정 처리
     * @param dto QnA 게시물 DTO
     * @return 수정 완료 메시지
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value = "qnamodify", method = RequestMethod.POST, produces = "application/text; charset=UTF-8;")
    @ResponseBody
    public String qnaModify(QnaDTO dto) {
        qnaService.qnaModify(dto);
        return "수정완료";
    }

    /**
     * 신진영 23.04.19 Q&A 삭제 처리
     * @param qna_idx 삭제할 Q&A의 인덱스
     * @return Q&A 리스트 화면으로 redirect
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping("qnadelete")
    public String qnaDelete(int qna_idx) {
        qnaService.qnaDelete(qna_idx);
        return "redirect:/admin/qnalist";
    }



}