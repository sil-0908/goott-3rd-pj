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

    // 여행 정보 게시글 생성
    public int create(TravelInfoDTO travelInfoDTO) {
        return this.ss.insert("travelinfo.insert", travelInfoDTO);
    }
    // 여행 정보 이미지 생성
    public void createImg(TravelInfoDTO travelInfoDTO) {
        this.ss.insert("travelinfo.insertfile", travelInfoDTO);
    }
    // 여행 정보 상세 정보 호출
    public TravelInfoDTO detail(TravelInfoDTO travelInfoDTO) {
        return this.ss.selectOne("travelinfo.detail", travelInfoDTO);
    }
    // 여행 정보 게시글 업데이트
    public int update(TravelInfoDTO travelInfoDTO) {
        return this.ss.update("travelinfo.update", travelInfoDTO);
    }
    // 여행 정보 기존 이미지 삭제
    public void deleteImg(TravelInfoDTO travelInfoDTO) {
         this.ss.delete("travelinfo.deleteImg", travelInfoDTO);
    }
    // 여행 정보 이미지 업데이트
    public void updateImg(TravelInfoDTO travelInfoDTO) {
        this.ss.insert("travelinfo.updateImg", travelInfoDTO);
    }
    // 게시글 삭제
    public int delete(TravelInfoDTO travelInfoDTO) {
        return this.ss.update("travelinfo.delete", travelInfoDTO);
    }
    // 이미지 목록 조회
    public List<TravelInfoDTO> imgList(TravelInfoDTO travelInfoDTO) {
        return this.ss.selectList("travelinfo.imgList", travelInfoDTO);
    }
    // 게시글 목록 조회
    public List<TravelInfoDTO> list(Criteria cri) {
        return ss.selectList("travelinfo.list", cri);
    }
    // 게시글 전체 수
    public int totalCount(Criteria cri) {
        return ss.selectOne("travelinfo.totalCount", cri);
    }
}
