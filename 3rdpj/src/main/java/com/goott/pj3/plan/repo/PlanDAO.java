package com.goott.pj3.plan.repo;

import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.plan.dto.ImgDTO;
import com.goott.pj3.plan.dto.PlanDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

//2023.04.05 길영준
//2023.04.26 길영준 주석추가
@Repository
public class PlanDAO {

    final
    SqlSession ss;

    public PlanDAO(SqlSession ss) {
        this.ss = ss;
    }

    //플랜 생성
    public int create(PlanDTO planDTO) {
        int affecrRowCnt= this.ss.insert("plan.create", planDTO);
        if(affecrRowCnt != 0){
            return planDTO.getPlan_idx();
        }
        return 0;
    }

    //플랜이미지 업로드
    public int planImgCreate(PlanDTO planDTO) {
        return this.ss.insert("plan.createImg", planDTO);
    }

    //플랜리스트
    public List<PlanDTO> list(Criteria cri) {
        return ss.selectList("plan.list", cri);
    }

    //페이징을 위한 총 플랜 카운트
    public int totalConut(Criteria cri) {
        return ss.selectOne("plan.totalCount", cri);
    }

    //플랜 디테일
    public PlanDTO detail(int plan_idx) {
        return ss.selectOne("plan.detail", plan_idx);
    }

    //플랜 수정
    public void edit(PlanDTO planDTO) {
        ss.update("plan.edit", planDTO);
    }

    //플랜 삭제(DB삭제는 안함)
    public void delete(int plan_idx) {
        ss.delete("plan.delete", plan_idx);
    }

    public int planImgDelete(PlanDTO planDTO) {
        return this.ss.delete("plan.planImgDelete", planDTO);
    }

    public void planImgUpdate(PlanDTO planDTO) {
        this.ss.insert("plan.planImgUpdate", planDTO);
    }
}
