package com.goott.pj3.board.qna.repo;

import com.goott.pj3.board.free.dto.Criteria;
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

    public void delete(int qna_idx) {
        ss.update("qna.delete", qna_idx);
    }

    public List<QnaDTO> list_n() {
        return ss.selectList("qna.list_n");
    }

    public List<QnaDTO> list_u() {
        return ss.selectList("qna.list_u");
    }

    public List<QnaDTO> list_r() {
        return ss.selectList("qna.list_r");
    }

    public List<QnaDTO> list_e() {
        return ss.selectList("qna.list_e");
    }
}
