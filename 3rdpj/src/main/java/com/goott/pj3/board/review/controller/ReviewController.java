package com.goott.pj3.board.review.controller;

import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.common.util.auth.Auth;
import com.goott.pj3.common.util.aws.S3FileUploadService;
import com.goott.pj3.common.util.paging.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.goott.pj3.board.review.service.ReviewService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


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
	 * @param multipartFiles
	 * @return
	 */
	@Auth(role=Auth.Role.USER)
	@PostMapping("create")
	public ModelAndView createPost(ReviewDTO reviewDTO, ModelAndView mv, HttpSession httpSession,
								   @RequestParam("file[]") List<MultipartFile> multipartFiles) {
		try {
			String user_id = (String) httpSession.getAttribute("user_id"); // 로그인한 유저 아이디 세션
			reviewDTO.setUser_id(user_id); // DTO에 유저 아이디 할당
			reviewDTO.setPlan_idx(1); // 임시 plan_idx값
			int review_idx = this.reviewService.create(reviewDTO); // 생성된 게시글 idx
			imgFileUpload(reviewDTO, multipartFiles, review_idx); // 이미지 파일 업로드 API
			if (review_idx != 0) {
				mv.setViewName("redirect:/review/detail/" + review_idx);
			} else {
				mv.setViewName("review/review_create");
			}
		} catch (Exception e) {
			// 예외 처리
			System.err.println("리뷰 생성 중 오류가 발생했습니다: " + e.getMessage());
			// 오류 페이지로 리다이렉트 또는 예외 처리에 맞는 다른 로직 수행
			mv.setViewName("/error/500");
		}

		return mv;
	}

	/**
	 * 조원재 23.04.21 이미지 파일 업로드 API
	 * @param reviewDTO
	 * @param multipartFiles
	 * @param review_idx
	 */
	private void imgFileUpload(ReviewDTO reviewDTO, List<MultipartFile> multipartFiles, int review_idx) {
		try {
			if(multipartFiles !=null && !multipartFiles.isEmpty()) { // 이미지 파일이 존재하는 경우
				List<String> imgList = s3FileUploadService.upload(multipartFiles); // AWS서버 저장 후 URL값 List에 담기
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
		int succeessIdx = this.reviewService.update(reviewDTO); // 게시글 업데이트(이미지 제외)
		for (String fileName : this.reviewService.detail(reviewDTO).getR_img()){ // URL주소 하나씩 가져와서
			s3FileUploadService.deleteFromS3(fileName); // 서버에서 삭제
		}
		this.reviewService.deleteImg(reviewDTO); // 기존 img 삭제
		ImgFileUpdate(review_idx, reviewDTO, mv, multipartFile, succeessIdx); // 이미지 파일 업데이트 API
		mv.setViewName("redirect:/review/detail/"+ review_idx);
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
	private void ImgFileUpdate(int review_idx, ReviewDTO reviewDTO, ModelAndView mv,
							   List<MultipartFile> multipartFile, int succeessIdx) {
		try {
			if(multipartFile !=null || !multipartFile.isEmpty()) {
				List<String> imgList = s3FileUploadService.upload(multipartFile);
				reviewDTO.setR_img(imgList);
				reviewDTO.setReview_idx(succeessIdx);
				this.reviewService.updateImg(reviewDTO);
			}
		} catch (IOException e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 조원재 23.04.05 리뷰 삭제
	 * @param review_idx
	 * @param reviewDTO
	 * @param mv
	 * @return
	 */
	@PostMapping("delete/{review_idx}")
	public ModelAndView delete(@PathVariable int review_idx, ReviewDTO reviewDTO, ModelAndView mv) {
		reviewDTO.setReview_idx(review_idx);
		boolean success = this.reviewService.delete(reviewDTO); // 게시글 삭제 (이미지 제외)
		try {
			this.reviewService.updateDeleteImg(reviewDTO); // 이미지 삭제(실제 삭제x)
		} catch (Exception e) {
			// 예외 처리
			System.err.println("리뷰 삭제 중 오류가 발생했습니다: " + e.getMessage());
			// 오류 페이지로 리다이렉트 또는 예외 처리에 맞는 다른 로직 수행
			mv.setViewName("/error/500");
			return mv;
		}
		if (success) {
			mv.setViewName("redirect:/review/list");
		} else {
			mv.setViewName("redirect:/review/detail/" + review_idx);
		}
		return mv;
	}

	/**
	 * 조원재 23.04.05 리스트 조회, 검색, 페이징
	 * @param mv
	 * @param cri
	 * @param reviewDTO
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv, Criteria cri, ReviewDTO reviewDTO) {
		try {
			List<ReviewDTO> originalList = reviewService.imglist(reviewDTO);
			List<ReviewDTO> newList = new ArrayList<>(); // 인덱스와 첫번째 이미지만 담을 List 생성
			for (ReviewDTO dto : originalList) {
				List<String> rImgList = dto.getR_img(); // 이미지만 List에 담기
				if (rImgList != null && !rImgList.isEmpty()) { // 이미지가 있는 경우
					String firstImg = rImgList.get(0); // 첫번째 이미지 변수에 담기
					ReviewDTO newDto = new ReviewDTO(); // 인덱스+첫번째 이미지 값 담을 dto
					newDto.setReview_idx(dto.getReview_idx()); // 인덱스 담기
					newDto.setR_img(Collections.singletonList(firstImg)); // 첫번째 이미지 담기
					newList.add(newDto);
				}
			}
			mv.addObject("imgList", newList);
			mv.addObject("paging", reviewService.paging(cri));
			mv.addObject("data", reviewService.list(cri));
			mv.setViewName("/board/review/review_list");
		} catch (Exception e) {
			// 예외 처리
			System.err.println("리뷰 목록 조회 중 오류가 발생했습니다: " + e.getMessage());
			// 오류 페이지로 리다이렉트 또는 예외 처리에 맞는 다른 로직 수행
			mv.setViewName("/error/500");
		}
		return mv;
	}
}
