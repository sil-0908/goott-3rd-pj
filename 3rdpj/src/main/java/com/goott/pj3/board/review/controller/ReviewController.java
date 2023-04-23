package com.goott.pj3.board.review.controller;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.S3FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.goott.pj3.board.review.service.ReviewService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/review/**")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@Autowired
	S3FileUploadService s3FileUploadService;

	/**
	 * 조원재 23.04.05. 리뷰 페이지 호출
	 * @return
	 */
	@GetMapping("create")
	public ModelAndView create(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/review/review_create");
		return mv;
	}

	/**
	 * 조원재 23.04.05 리뷰 생성
	 * 		 23.04.21 파일 업로드 기능 추가
	 * @param reviewDTO
	 * @param mv
	 * @param httpSession
	 * @param multipartFile
	 * @return
	 */
	@PostMapping("create")
	public ModelAndView CreatePost(ReviewDTO reviewDTO, ModelAndView mv, HttpSession httpSession,
								   @RequestParam("file[]") List<MultipartFile> multipartFile){
		String user_id = (String) httpSession.getAttribute("user_id"); // 로그인한 유저 아이디 세션
		reviewDTO.setUser_id(user_id); // DTO에 유저 아이디 할당
		reviewDTO.setPlan_idx(1); // 임시 plan_idx값
		int review_idx = this.reviewService.create(reviewDTO); // 생성된 게시글 idx
		ImgFileUpload(reviewDTO, multipartFile, review_idx); // 이미지 파일 업로드 API
		if(review_idx!=0){
			mv.setViewName("redirect:/review/detail/"+review_idx);
		} else {
			mv.setViewName("review/review_create");
		}
		return mv;
	}

	/**
	 * 조원재 23.04.21 이미지 파일 업로드 API
	 * @param reviewDTO
	 * @param multipartFile
	 * @param review_idx
	 */
	private void ImgFileUpload(ReviewDTO reviewDTO, List<MultipartFile> multipartFile, int review_idx) {
		try {
			if(multipartFile !=null) {
				List<String> imgList = s3FileUploadService.upload(multipartFile);
				reviewDTO.setR_img(imgList);
				reviewDTO.setReview_idx(review_idx);
				this.reviewService.createFile(reviewDTO);
			}
		} catch (IOException e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * 조원재 23.04.05 리뷰 디테일 페이지 호출
	 * @param
	 * @return
	 */
	@GetMapping("detail/{review_idx}")
	public ModelAndView detail(@PathVariable int review_idx, ReviewDTO reviewDTO, ModelAndView mv){
		reviewDTO.setReview_idx(review_idx);
		List<ReviewDTO> detail = this.reviewService.detail(reviewDTO);
		System.out.println("detail : " + detail.toString());
		mv.addObject("data", detail);
		mv.addObject("review_idx", review_idx);
		mv.setViewName("/board/review/review_detail");
		return mv;
	}
	/**
	 * 조원재 23.04.05 리뷰 수정 화면 호출
	 * @param
	 * @return
	 */
	@GetMapping("update/{review_idx}")
	public ModelAndView update(@PathVariable int review_idx, ReviewDTO reviewDTO, ModelAndView mv) {
		reviewDTO.setReview_idx(review_idx);

		List<ReviewDTO> detail = this.reviewService.detail(reviewDTO);
		System.out.println("detail : " + detail.toString());
		mv.addObject("data", detail);
		mv.setViewName("board/review/review_update");
		return mv;
	}

	/**
	 * 조원재 23.04.05 리뷰 수정 기능
	 * @param
	 * @return
	 */
	@PostMapping("update/{review_idx}")
	public ModelAndView updatePost(@PathVariable int review_idx,  ReviewDTO reviewDTO, ModelAndView mv,
								   @RequestParam("file[]") List<MultipartFile> multipartFile){
		reviewDTO.setReview_idx(review_idx);
		int succeessIdx = this.reviewService.update(reviewDTO);
		try {
			if(multipartFile !=null) {
				List<String> imgList = s3FileUploadService.upload(multipartFile);
				reviewDTO.setR_img(imgList);
				reviewDTO.setReview_idx(succeessIdx);
				this.reviewService.updateFile(reviewDTO);
			}
		} catch (IOException e){
			throw new RuntimeException(e);
		}
		if(succeessIdx!=0){
			mv.setViewName("redirect:/review/detail/"+review_idx);
		}
		return mv;
	}

	/**
	 * 조원재 23.04.05 리뷰 삭제
	 * @param
	 * @return
	 */
	@GetMapping("delete/{review_idx}")
	public ModelAndView delete(@PathVariable int review_idx, ReviewDTO reviewDTO, ModelAndView mv){
		reviewDTO.setReview_idx(review_idx);
		boolean success = this.reviewService.delete(reviewDTO);
		if (success){
			mv.setViewName("redirect:/review/review_list");
		} else {
			mv.setViewName("redirect:/review/detail/"+review_idx);
		}
		return mv;
	}

	/**
	 * 조원재 23.04.05 리뷰 리스트 조회 및 검색
	 * @param
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv, Criteria cri){
		mv.addObject("paging", reviewService.paging(cri));
		mv.addObject("data", reviewService.list(cri));
		mv.setViewName("/board/review/review_list");
		return mv;
	}
}
