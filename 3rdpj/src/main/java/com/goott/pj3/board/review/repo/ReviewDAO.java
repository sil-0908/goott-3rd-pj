package com.goott.pj3.board.review.repo;

import org.apache.ibatis.annotations.Param;
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

	public void createFile(ReviewDTO reviewDTO) {
		System.out.println("files : " + reviewDTO);
		this.ss.insert("review.file", reviewDTO);
	}

	public ReviewDTO detail(ReviewDTO reviewDTO) {
		return this.ss.selectOne("review.detail", reviewDTO);
	}

	public int update(ReviewDTO reviewDTO) {
		return this.ss.update("review.update", reviewDTO);
	}

	public void updateFile(ReviewDTO reviewDTO) {
		System.out.println("updateFile : " + reviewDTO);
		this.ss.update("review.updatefile", reviewDTO);
	}

	public int delete(ReviewDTO reviewDTO) {
		return this.ss.update("review.delete", reviewDTO);
	}

	public List<ReviewDTO> list(Criteria cri) {
		return this.ss.selectList("review.list", cri);
	}

	public int totalCount(Criteria cri) {
		return this.ss.selectOne("review.totalCount",cri);
	}



}
