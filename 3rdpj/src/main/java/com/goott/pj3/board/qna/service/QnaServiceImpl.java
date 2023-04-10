package com.goott.pj3.board.qna.service;

import com.goott.pj3.common.util.Criteria;
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
	public void enroll(QnaDTO qnaDTO) {
		qnaDAO.enroll(qnaDTO);
	}

	@Override
	public List<QnaDTO> list(Criteria cri) {
		return qnaDAO.list(cri);
	}

	@Override
	public int totalCount(Criteria cri) {
		return qnaDAO.totalCount(cri);
	}

	@Override
	public QnaDTO detail(int qna_idx) {
		return qnaDAO.detail(qna_idx);
	}

	@Override
	public void modify(QnaDTO qnaDTO) {
		qnaDAO.modify(qnaDTO);
	}

	@Override
	public void delete(QnaDTO qnaDTO) {
		qnaDAO.delete(qnaDTO);
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

	@Override
	public String get_category(QnaDTO qnaDTO) {
		return qnaDAO.get_category(qnaDTO);
	}


}
