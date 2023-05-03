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

    @ResponseBody
    @PostMapping("like_unlike")
    public ModelAndView likeUnlike(@RequestParam("user_id") String user_id,
                                   @RequestParam("action") String action,
                                   @RequestParam("review_idx") int review_idx,
                                   LikeUnlikeDTO likeUnlikeDTO, ModelAndView mv) {
//        likeUnlikeDTO.setUser_id(user_id);
        if (action.equals("like")) {
            this.likeUnlikeService.like(likeUnlikeDTO);
        } else if (action.equals("unlike")) {
            this.likeUnlikeService.unlike(likeUnlikeDTO);
        }
////        LikeUnlikeDTO dto = likeUnlikeService.getLikeUnlikeCnt(likeUnlikeDTO);
//        mv.addObject("likeCount", dto.getP_like());
//        mv.addObject("unlikeCount", dto.getP_unlike());
//        return mv;
//    }
        return mv;
    }
}
