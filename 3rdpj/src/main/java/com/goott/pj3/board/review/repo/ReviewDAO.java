package com.goott.pj3.board.review.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.common.util.Criteria;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ReviewDAO {

	@Autowired
	SqlSession ss;

	public int create(ReviewDTO reviewDTO) {
		return this.ss.insert("review.insert", reviewDTO);
	}
	public void createFile(List<String> files) {
		this.ss.insert("review.file", files);
	}
	public ReviewDTO detail(ReviewDTO reviewDTO) {
		return this.ss.selectOne("review_detail", reviewDTO);
	}
	public int update(ReviewDTO reviewDTO) {
		return this.ss.update("review.update", reviewDTO);
	}
	public int delete(ReviewDTO reviewDTO) {
		return this.ss.update("review.delete", reviewDTO);
	}
	public List<ReviewDTO> list(Criteria cri) {
		return ss.selectList("review.list", cri);
	}
	public int totalCount(Criteria cri) {
		return ss.selectOne("review.totalCount",cri);
	}

}
