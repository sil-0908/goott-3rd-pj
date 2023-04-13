package com.goott.pj3.board.qna.service;

import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.board.qna.dto.QnaDTO;

import java.util.List;

public interface QnaService {

    void enroll(QnaDTO qnaDTO);

    List<QnaDTO> list(Criteria cri);

    int totalCount(Criteria cri);

    QnaDTO detail(int qna_idx);

    void modify(QnaDTO qnaDTO);

    void delete(QnaDTO qnaDTO);

    List<QnaDTO> list_n();

    List<QnaDTO> list_u();

    List<QnaDTO> list_r();

    List<QnaDTO> list_e();

    String get_category(QnaDTO qnaDTO);

}
