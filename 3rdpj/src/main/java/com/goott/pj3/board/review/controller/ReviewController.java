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
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/review/**")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	// AWS S3 파일 업로드
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
		reviewDTO.setPlan_idx(1); // 임시 plan_idx값    g
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
			if(multipartFile !=null && !multipartFile.isEmpty()) { // 이미지 파일이 존재하는 경우
				List<String> imgList = s3FileUploadService.upload(multipartFile);
				reviewDTO.setR_img(imgList);
				reviewDTO.setReview_idx(review_idx);
				this.reviewService.createImg(reviewDTO);
			} else { // 이미지 파일이 없는 경우
				reviewDTO.setReview_idx(review_idx);
				this.reviewService.createImg(reviewDTO);
			}
		} catch (IOException e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 조원재 23.04.05 리뷰 디테일 페이지 호출
	 * 		 23.04.25 리뷰 디테일 페이지 이미지 파일 추가
	 * @param review_idx
	 * @param reviewDTO
	 * @param mv
	 * @return
	 */
	@GetMapping("detail/{review_idx}")
	public ModelAndView detail(@PathVariable int review_idx,
							   ReviewDTO reviewDTO, ModelAndView mv){
		reviewDTO.setReview_idx(review_idx);
		ReviewDTO detail = this.reviewService.detail(reviewDTO); // review 게시글 정보
		mv.addObject("data", detail); // 게시글 정보
		mv.setViewName("/board/review/review_detail");
		return mv;
	}
	/**
	 * 조원재 23.04.05 리뷰 수정 화면 호출
	 * @param review_idx
	 * @param reviewDTO
	 * @param mv
	 * @return
	 */
	@GetMapping("update/{review_idx}")
	public ModelAndView update(@PathVariable int review_idx, ReviewDTO reviewDTO, ModelAndView mv) {
		reviewDTO.setReview_idx(review_idx);
		ReviewDTO detail = this.reviewService.detail(reviewDTO); // 게시글 정보
		mv.addObject("data", detail); // 게시글 정보
		mv.setViewName("board/review/review_update");
		return mv;
	}

	/**
	 * 조원재 23.04.05 리뷰 수정 기능
	 * 		 23.04.25 리뷰 이미지 파일 업데이트 기능 수정
	 * @param review_idx
	 * @param reviewDTO
	 * @param mv
	 * @param multipartFile
	 * @return
	 */
	@PostMapping("update/{review_idx}")
	public ModelAndView updatePost(@PathVariable int review_idx,  ReviewDTO reviewDTO, ModelAndView mv,
								   @RequestParam("file[]") List<MultipartFile> multipartFile){
		reviewDTO.setReview_idx(review_idx);
		int succeessIdx = this.reviewService.update(reviewDTO); // 본문 내용 업데이트
		this.reviewService.deleteImg(reviewDTO); // 기존 img 삭제
		ImgFileUpdate(review_idx, reviewDTO, mv, multipartFile, succeessIdx); // 이미지 파일 업데이트 API
		return mv;
	}

	/**
	 * 조원재 23.04.25 이미지 파일 업데이트 API
	 * @param review_idx
	 * @param reviewDTO
	 * @param mv
	 * @param multipartFile
	 * @param succeessIdx
	 */
	private void ImgFileUpdate(int review_idx, ReviewDTO reviewDTO, ModelAndView mv, List<MultipartFile> multipartFile, int succeessIdx) {
		try {
			if(multipartFile !=null) {
				List<String> imgList = s3FileUploadService.upload(multipartFile);
				reviewDTO.setR_img(imgList);
				reviewDTO.setReview_idx(succeessIdx);
				this.reviewService.updateImg(reviewDTO);
			}
		} catch (IOException e){
			throw new RuntimeException(e);
		}
		if(succeessIdx !=0){
			mv.setViewName("redirect:/review/detail/"+ review_idx);
		}
	}

	/**
	 * 조원재 23.04.05 리뷰 삭제
	 * @param
	 * @return
	 */
	@PostMapping("delete/{review_idx}")
	public ModelAndView delete(@PathVariable int review_idx,
							   ReviewDTO reviewDTO, ModelAndView mv){
		reviewDTO.setReview_idx(review_idx);
		boolean success = this.reviewService.delete(reviewDTO);
		this.reviewService.deleteImg(reviewDTO);
		if (success){
			mv.setViewName("redirect:/review/list");
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
	public ModelAndView list(ModelAndView mv, Criteria cri, ReviewDTO reviewDTO){
		List<ReviewDTO> originalList = reviewService.imglist(reviewDTO);
		List<ReviewDTO> newList = new ArrayList<>(); // 인덱스와 첫번째 이미지만 담을 List 생생
		for (ReviewDTO dto : originalList) {
			List<String> rImgList = dto.getR_img(); // 이미지만 List에 담기
			if (rImgList != null && !rImgList.isEmpty()) { // 이미지가 있는 경우
				String firstImg = rImgList.get(0); // 첫번째 이미지 변수에 담기
				ReviewDTO newDto = new ReviewDTO(); //
				newDto.setReview_idx(dto.getReview_idx());
				newDto.setR_img(Collections.singletonList(firstImg));
				newList.add(newDto);
			}
		}
		mv.addObject("imgList", newList);
		mv.addObject("paging", reviewService.paging(cri));
		mv.addObject("data", reviewService.list(cri));
		mv.setViewName("/board/review/review_list");
		return mv;
	}
}
