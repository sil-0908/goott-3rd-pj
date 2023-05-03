package com.goott.pj3.board.review.controller;

import com.goott.pj3.board.review.dto.LikeUnlikeDTO;
import com.goott.pj3.board.review.service.LikeUnlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LikeUnlikeController {

    @Autowired
    LikeUnlikeService likeUnlikeService;

    /**
     * 조원재 23.05.04. 리뷰 좋아요, 싫어요 처리
     * @param userId      사용자 ID
     * @param action      액션 (like 또는 unlike)
     * @param reviewIdx   리뷰 인덱스
     * @param likeUnlikeDTO 좋아요, 싫어요 DTO
     * @return 좋아요, 싫어요 정보 DTO
     */
    @ResponseBody
    @PostMapping("like_unlike")
    public LikeUnlikeDTO likeUnlike(@RequestParam("user_id") String userId,
                                    @RequestParam("action") String action,
                                    @RequestParam("review_idx") int reviewIdx,
                                    LikeUnlikeDTO likeUnlikeDTO) {
        likeUnlikeDTO.setUser_id(userId);
        likeUnlikeDTO.setReview_idx(reviewIdx);

        try {
            if ("like".equals(action)) {
                likeUnlikeService.like(likeUnlikeDTO);
            } else if ("unlike".equals(action)) {
                likeUnlikeService.unlike(likeUnlikeDTO);
            } else {
                // 예외: 잘못된 액션 값 처리
                throw new IllegalArgumentException("Invalid action: " + action);
            }

            LikeUnlikeDTO dto = likeUnlikeService.getLikeUnlikeCnt(likeUnlikeDTO);
            if (dto != null) {
                return dto;
            } else {
                // 예외: 결과가 null인 경우 처리
                throw new NullPointerException("LikeUnlikeDTO is null");
            }
        } catch (Exception e) {
            // 예외 처리
            // 로깅 등 필요한 작업 수행
            e.printStackTrace();
            // 에러 응답 반환
            throw new RuntimeException("An error occurred during like/unlike operation", e);
        }
    }
}
