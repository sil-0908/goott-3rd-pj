package com.goott.pj3.travelinfo.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TravelInfoDAO {

	@Autowired
	SqlSession ss;

	public int insert(Map<String, Object> map){
		return this.ss.insert("travelinfo.insert", map);
	}

//	public Map<String, Object> detail(Map<String, Object> map){
//		return this.ss.selectOne("review.detail", map);
//	}
//
//    public int update(Map<String, Object> map) {
//		return this.ss.update("review.update", map);
//    }
//
//	public int delete(Map<String, Object> map) {
//		return this.ss.delete("review.delete", map);
//	}
//
//	public List<Map<String, Object>> list(Map<String, Object> map) {
//		return this.ss.selectList("review.list", map);
//	}
}
