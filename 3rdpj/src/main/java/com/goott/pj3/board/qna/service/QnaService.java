package com.goott.pj3.board.qna.service;

import java.util.List;

import com.goott.pj3.board.qna.dto.QnaDTO;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.common.util.paging.PagingDTO;

public interface QnaService {

    String enroll(QnaDTO qnaDTO);

    List<QnaDTO> list(String requestUrl, Criteria cri, String auth);

    PagingDTO paging(String requestUrl, Criteria cri, String auth);

    QnaDTO detail(int qna_idx);

    String modify(QnaDTO qnaDTO);

    String delete(QnaDTO qnaDTO);

    List<QnaDTO> list_n();

    List<QnaDTO> list_q();

}
