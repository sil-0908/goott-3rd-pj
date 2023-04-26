package com.goott.pj3.travelinfo.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.travelinfo.dto.TravelInfoDTO;

import java.util.List;
import java.util.Map;

@Repository
public class TravelInfoDAO {

    @Autowired
    SqlSession ss;

    /**
     * 조원재 23.04.08. 여행지 정보 리스트
     * @param
     * @return
     */
    public List<TravelInfoDTO> list(Criteria cri) {
        return ss.selectList("travelinfo.list", cri);
    }

    public int totalCount(Criteria cri) {
        return ss.selectOne("travelinfo.totalCount", cri);
    }

    public int create(TravelInfoDTO travelInfoDTO) {
        return this.ss.insert("travelinfo.insert");
    }

    public void createImg(TravelInfoDTO travelInfoDTO) {
        this.ss.insert("travelinfo.insertfile", travelInfoDTO);
    }

    public TravelInfoDTO detail(TravelInfoDTO travelInfoDTO) {
        return this.ss.selectOne("travelinfo.detail", travelInfoDTO);
    }

    public int update(TravelInfoDTO travelInfoDTO) {
        return this.ss.update("travelinfo.update", travelInfoDTO);
    }

    public void deleteImg(TravelInfoDTO travelInfoDTO) {
        this.ss.delete("travelinfo.deleteImg", travelInfoDTO);
    }

    public void updateImg(TravelInfoDTO travelInfoDTO) {
        this.ss.insert("travelinfo.updateImg", travelInfoDTO);
    }

    public int delete(TravelInfoDTO travelInfoDTO) {
        return this.ss.update("travelinfo.delete", travelInfoDTO);
    }

    public List<TravelInfoDTO> imgList(TravelInfoDAO travelInfoDAO) {
        return this.ss.selectList("travelinfo.imgList", travelInfoDAO);
    }
}
