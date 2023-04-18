package com.goott.pj3.board.qna.service;

import java.util.List;

import com.goott.pj3.board.qna.dto.QnaDTO;
import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;

public interface QnaService {

    String enroll(QnaDTO qnaDTO);

    List<QnaDTO> list(Criteria cri);

    PagingDTO paging(String requestUrl, Criteria cri);

    QnaDTO detail(int qna_idx);

    String modify(QnaDTO qnaDTO);

    String delete(QnaDTO qnaDTO);

    List<QnaDTO> list_n();

    List<QnaDTO> list_u();

    List<QnaDTO> list_r();

    List<QnaDTO> list_e();
}
