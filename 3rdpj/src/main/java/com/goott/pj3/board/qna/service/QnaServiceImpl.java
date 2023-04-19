package com.goott.pj3.board.qna.service;

import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;
import com.goott.pj3.board.qna.dto.QnaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.pj3.board.qna.repo.QnaDAO;

import java.util.List;

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
		} else if (qnaDTO.getCategory().equals("U")) {
			return "redirect:/qna/list_U";
		} else if (qnaDTO.getCategory().equals("R")) {
			return "redirect:/qna/list_R";
		} else {
			return "redirect:/qna/list_E";
		}
	}

	@Override
	public List<QnaDTO> list(Criteria cri) {
		return qnaDAO.list(cri);
	}

	@Override
	public PagingDTO paging(String requestUrl, Criteria cri) {
		PagingDTO paging = new PagingDTO();
		if(requestUrl.contains("list_N")){
			cri.setCategory("N");
			paging.setCri(cri);

		} else if(requestUrl.contains("list_U")){
			cri.setCategory("U");
			paging.setCri(cri);

		} else if(requestUrl.contains("list_R")){
			cri.setCategory("R");
			paging.setCri(cri);

		} else {
			cri.setCategory("E");
			paging.setCri(cri);
		}
		paging.setTotalCount(qnaDAO.totalCount(cri));
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

	@Override
	public List<QnaDTO> list_n() {
		return qnaDAO.list_n();
	}

	@Override
	public List<QnaDTO> list_u() {
		return qnaDAO.list_u();
	}

	@Override
	public List<QnaDTO> list_r() {
		return qnaDAO.list_r();
	}

	@Override
	public List<QnaDTO> list_e() {
		return qnaDAO.list_e();
	}



}
