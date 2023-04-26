
package com.goott.pj3.admin.service;

import com.goott.pj3.board.free.dto.FreeBoardDTO;
import com.goott.pj3.board.qna.dto.QnaDTO;
import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;

import java.util.List;

public interface AdminQnaService {


    List<QnaDTO> qnaList(Criteria cri);

    PagingDTO paging(Criteria cri);

    int totalCount(Criteria cri);

    void qnaInsert(QnaDTO dto);

    QnaDTO qnaDetail(int qna_idx);

    void qnaDelete(int qna_idx);

    void qnaModify(QnaDTO dto);


}