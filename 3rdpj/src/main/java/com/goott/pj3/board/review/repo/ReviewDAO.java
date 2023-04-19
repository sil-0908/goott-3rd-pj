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

	/**
	 * 조원재 23.04.05. 리뷰 생성
	 * @param map
	 * @return
	 */
	public int insert(Map<String, Object> map){
		return this.ss.insert("review.insert", map);
	}
	/**
	 * 조원재 23.04.05. 리뷰 데이터 호출
	 * @param map
	 * @return
	 */
	public Map<String, Object> detail(Map<String, Object> map){
		return this.ss.selectOne("review.detail", map);
	}
	/**
	 * 조원재 23.04.05. 리뷰 수정 
	 * @param map
	 * @return
	 */
    public int update(Map<String, Object> map) {
		return this.ss.update("review.update", map);
    }
	/**
	 * 조원재 23.04.05. 리뷰 삭제
	 * @param map
	 * @return
	 */
	public int delete(Map<String, Object> map) {
		return this.ss.update("review.delete", map);
	}
	/**
	 * 조원재 23.04.05. 리뷰 목록 호출
	 * @param cri
	 * @return
	 */
	public List<ReviewDTO> list(Criteria cri) {
		return ss.selectList("review.list", cri);
	}
	
	public int totalCount(Criteria cri) {
		return ss.selectOne("review.totalCount",cri);
	}
}
