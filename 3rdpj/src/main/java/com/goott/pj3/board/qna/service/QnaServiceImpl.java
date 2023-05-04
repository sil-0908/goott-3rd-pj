package com.goott.pj3.board.qna.service;

import com.goott.pj3.board.qna.dto.QnaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.pj3.board.qna.repo.QnaDAO;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;

import java.util.List;

import javax.servlet.http.HttpSession;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	QnaDAO qnaDAO;

	@Override
	public String enroll(QnaDTO qnaDTO) {
		if(qnaDTO.getUser_id() == null){
			return "redirect:/user/signin";
		}
		qnaDAO.enroll(qnaDTO);
		if(qnaDTO.getCategory().equals("N")){
			return "redirect:/qna/list_N";
		} else if (qnaDTO.getCategory().equals("Q")) {
			return "redirect:/qna/list_Q";
		} else if (qnaDTO.getCategory().equals("R")) {
			return "redirect:/qna/list_R";
		} else {
			return "redirect:/qna/list_U";
		}
	}

	@Override
	public List<QnaDTO> list(String requestUrl, Criteria cri, String auth) {
		cri.setAuth(auth);
		if(requestUrl.contains("list_R")) {
			return qnaDAO.UR_list(cri);
		}
		else if(requestUrl.contains("list_U")) {
			return qnaDAO.UR_list(cri);
		}
		return qnaDAO.list(cri);
	}

	@Override
	public PagingDTO paging(String requestUrl, Criteria cri, String auth) {
		PagingDTO paging = new PagingDTO();
		cri.setAuth(auth);
		if(requestUrl.contains("list_N")){
			cri.setCategory("N");
			paging.setCri(cri);
			paging.setTotalCount(qnaDAO.totalCount(cri));

		} else if(requestUrl.contains("list_Q")){
			cri.setCategory("Q");
			paging.setCri(cri);
			paging.setTotalCount(qnaDAO.totalCount(cri));

		} else if(requestUrl.contains("list_R")){
			cri.setCategory("R");
			paging.setCri(cri);
			paging.setTotalCount(qnaDAO.UR_totalCount(cri));

		} else {
			cri.setCategory("U");
			paging.setCri(cri);
			paging.setTotalCount(qnaDAO.UR_totalCount(cri));
		}
		return paging;
	}

	@Override
	public QnaDTO detail(int qna_idx) {
		return qnaDAO.detail(qna_idx);
	}

	@Override
	public String modify(QnaDTO qnaDTO) {
		qnaDAO.modify(qnaDTO);
		return qnaDAO.get_category(qnaDTO);
	}

	@Override
	public String delete(QnaDTO qnaDTO) {
		qnaDAO.delete(qnaDTO);
		return qnaDAO.get_category(qnaDTO);
	}

	// 공지사항
	@Override
	public List<QnaDTO> list_n() {
		return qnaDAO.list_n();
	}

	// 자주묻는 질문
	@Override
	public List<QnaDTO> list_q() {
		return qnaDAO.list_q();
	}

}
