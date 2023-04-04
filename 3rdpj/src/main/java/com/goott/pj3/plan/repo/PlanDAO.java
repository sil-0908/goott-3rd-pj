package com.goott.pj3.plan.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlanDAO {

	@Autowired
	SqlSession ss;
	
}
