
package com.goott.pj3.admin.service;

import com.goott.pj3.admin.repo.AdminQnaDAO;
import com.goott.pj3.board.qna.dto.QnaDTO;
import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminQnaServiceImpl implements AdminQnaService{

    @Autowired
    AdminQnaDAO qnaDAO;


    @Override
    public List<QnaDTO> qnaList(Criteria cri) {
        return qnaDAO.qnaList(cri);
    }

    @Override
    public PagingDTO paging(Criteria cri) {
        PagingDTO paging = new PagingDTO();
        paging.setCri(cri);
        paging.setTotalCount(qnaDAO.totalCount(cri));
        return paging;
    }

    @Override
    public int totalCount(Criteria cri) {
        return qnaDAO.totalCount(cri);
    }

    @Override
    public void qnaInsert(QnaDTO dto) {
        qnaDAO.qnaInsert(dto);
    }

    @Override
    public QnaDTO qnaDetail(int qna_idx) {
        return qnaDAO.qnaDetail(qna_idx);
    }

    @Override
    public void qnaDelete(int qna_idx) {
        qnaDAO.qnaDelete(qna_idx);

    }

    @Override
    public void qnaModify(QnaDTO dto) {
        qnaDAO.qnaModify(dto);
    }
}