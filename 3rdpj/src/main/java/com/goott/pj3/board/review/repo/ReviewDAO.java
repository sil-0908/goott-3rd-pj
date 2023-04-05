package com.goott.pj3.board.review.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;

@Repository
public class ReviewDAO {

	@Autowired
	SqlSession ss;

	public int insert(Map<String, Object> map){
		return this.ss.insert("review.insert", map);
	}

	public Map<String, Object> detail(Map<String, Object> map){
		System.out.println("daoMap : " + map);
		return this.ss.selectOne("review.detail", map);
	}

}
