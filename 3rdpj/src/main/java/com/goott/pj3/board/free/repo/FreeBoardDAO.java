package com.goott.pj3.board.free.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FreeBoardDAO {

	@Autowired
	SqlSession ss;
	
}
