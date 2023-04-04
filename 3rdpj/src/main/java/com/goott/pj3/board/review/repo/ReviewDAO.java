package com.goott.pj3.board.review.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO {

	@Autowired
	SqlSession ss;
	
}
