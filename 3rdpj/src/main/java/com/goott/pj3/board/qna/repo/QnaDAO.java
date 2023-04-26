package com.goott.pj3.board.qna.repo;

import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.board.qna.dto.QnaDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QnaDAO {

	@Autowired
	SqlSession ss;

    public void enroll(QnaDTO qnaDTO) {
        ss.insert("qna.insert", qnaDTO);
    }

    public List<QnaDTO> list(Criteria cri) {
        return ss.selectList("qna.list", cri);
    }

    public int totalCount(Criteria cri) {
        return ss.selectOne("qna.totalCount", cri);
    }

    public QnaDTO detail(int qna_idx) {
        return ss.selectOne("qna.detail", qna_idx);
    }

    public void modify(QnaDTO qnaDTO) {
        ss.update("qna.modify",qnaDTO);
    }

    public void delete(QnaDTO qnaDTO) {
        ss.update("qna.delete", qnaDTO);
    }

    public List<QnaDTO> list_n() {
        return ss.selectList("qna.list_n");
    }

    public List<QnaDTO> list_q() {
        return ss.selectList("qna.list_q");
    }

    public String get_category(QnaDTO qnaDTO) {
        return ss.selectOne("qna.get_category",qnaDTO);
    }

	public List<QnaDTO> UR_list(Criteria cri) {
		return ss.selectList("qna.UR_list", cri);
	}

	public int UR_totalCount(Criteria cri) {
		return ss.selectOne("qna.UR_totalCount", cri);
	}

}
