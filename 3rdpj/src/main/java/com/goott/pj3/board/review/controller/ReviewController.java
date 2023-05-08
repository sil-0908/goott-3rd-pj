package com.goott.pj3.board.review.controller;

import com.goott.pj3.board.review.dto.LikeUnlikeDTO;
import com.goott.pj3.board.review.dto.ReviewDTO;
import com.goott.pj3.board.review.dto.PlannerRatingDTO;
import com.goott.pj3.common.util.auth.Auth;
import com.goott.pj3.common.util.aws.S3FileUploadService;
import com.goott.pj3.common.util.paging.Criteria;

import com.goott.pj3.plan.dto.PlanDTO;
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
	 * @param httpSession 현재 세션 정보
	 * @param planDTO 리뷰에 필요한 데이터를 담은 PlanDTO 객체
	 * @param mv ModelAndView 객체
	 * @return ModelAndView 객체에 데이터를 추가하고 view를 설정한 후 반환
	 */
	@Auth(role=Auth.Role.USER)
	@GetMapping("create")
	public ModelAndView create(HttpSession httpSession, PlanDTO planDTO, ModelAndView mv){
		// 아이디 값 파라미터로 받기 -> 로그인 아이디 세션과 아이디 값 비교 (마이 페이지 구현 후 진행예정)
//		String longinId = httpSession.getAttribute("user_id");
//		if(user_id.equals(longinId)){ 아래 코드 넣기 }
		planDTO.setPlan_idx(66);
		PlanDTO planData = this.reviewService.getCreate(planDTO);
		mv.addObject("data", planData);
		mv.setViewName("/board/review/review_create");
		return mv;
	}

	/**
	 * 조원재 23.04.05 리뷰 생성
	 * 		 23.04.21 파일 업로드 기능 추가
	 * @param reviewDTO 리뷰 데이터를 담은 ReviewDTO 객체
	 * @param plannerRatingDTO 플래너 평점 데이터를 담은 PlannerRatingDTO 객체
	 * @param mv ModelAndView 객체
	 * @param httpSession 현재 세션 정보
	 * @param multipartFiles 업로드된 파일을 담은 List<MultipartFile> 객체
	 * @param plannerId 플래너 아이디
	 * @return ModelAndView 객체에 view를 설정한 후 반환합니다.
	 */
	@Auth(role=Auth.Role.USER)
	@PostMapping("create")
	public ModelAndView createPost(ReviewDTO reviewDTO, PlannerRatingDTO plannerRatingDTO, ModelAndView mv, HttpSession httpSession,
								   @RequestParam("file[]") List<MultipartFile> multipartFiles,
								   @RequestParam("planner_id") String plannerId) {
		try {
			String user_id = (String) httpSession.getAttribute("user_id"); // 로그인한 유저 아이디 세션
			plannerRatingDTO.setPlan_idx(66);
			plannerRatingDTO.setUser_id(user_id);
			this.reviewService.plannerRating(plannerRatingDTO); // 플래너 평점
			reviewDTO.setUser_id(user_id); // DTO에 유저 아이디 할당
			reviewDTO.setPlan_idx(66); // 임시 plan_idx값
			int review_idx = this.reviewService.create(reviewDTO); // 생성된 게시글 idx
			imgFileUpload(reviewDTO, multipartFiles, review_idx); // 이미지 파일 업로드 API
			if (review_idx != 0) {
				mv.setViewName("redirect:/review/detail/" + review_idx);
			} else {
				mv.setViewName("review/review_create");
			}
		} catch (Exception e) {
			// 예외 처리
			e.printStackTrace();
		}

		return mv;
	}

	/**
	 * 조원재 23.04.21 이미지 파일 업로드 API
	 * @param reviewDTO 리뷰 데이터를 담은 ReviewDTO 객체
	 * @param multipartFiles 업로드된 이미지 파일들을 담은 List<MultipartFile> 객체
	 * @param review_idx 생성된 리뷰의 인덱스 값
	 */
	private void imgFileUpload(ReviewDTO reviewDTO, List<MultipartFile> multipartFiles, int review_idx) {
		try {
			if(multipartFiles !=null && !multipartFiles.isEmpty()) { // 이미지 파일이 존재하는 경우
				List<String> imgList = s3FileUploadService.upload(multipartFiles); // AWS서버 저장 후 URL값 List에 담기
				reviewDTO.setR_img(imgList); //
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
	 * 조원재 리뷰 디테일 페이지 호출
	 * 		 리뷰 디테일 페이지 이미지 파일 추가
	 * @param review_idx 조회할 리뷰의 인덱스
	 * @param reviewDTO 리뷰 데이터를 담은 ReviewDTO 객체
	 * @param mv ModelAndView 객체
	 * @return ModelAndView 객체에 데이터와 view를 설정한 후 반환
	 */
	@GetMapping("detail/{review_idx}")
	public ModelAndView detail(@PathVariable int review_idx,
							   ReviewDTO reviewDTO, ModelAndView mv){
		LikeUnlikeDTO likeUnlikeDTO = new LikeUnlikeDTO();
		reviewDTO.setReview_idx(review_idx);
		likeUnlikeDTO.setReview_idx(review_idx); // 조회할 게시글 인덱스 할당
		LikeUnlikeDTO dto = this.reviewService.likeUnlikeCnt(likeUnlikeDTO);
		ReviewDTO detail = this.reviewService.detail(reviewDTO); // review 게시글 정보
		mv.addObject("likeUnlike", dto); // 좋아요, 싫어요 정보
		mv.addObject("data", detail); // 게시글 정보
		mv.setViewName("/board/review/review_detail");
		return mv;
	}

	/**
	 * 조원재 리뷰 수정 화면 호출
	 * @param review_idx 리뷰의 인덱스 값
	 * @param reviewDTO 리뷰 데이터를 담은 ReviewDTO 객체
	 * @param mv ModelAndView 객체
	 * @return ModelAndView 객체에 데이터를 추가하고 view를 설정한 후 반환
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
	 * 조원재 리뷰 수정 기능
	 * 		 리뷰 이미지 파일 업데이트 기능 수정
	 * @param review_idx 수정할 리뷰의 인덱스 값
	 * @param reviewDTO 수정할 리뷰 데이터를 담은 ReviewDTO 객체
	 * @param mv ModelAndView 객체
	 * @param multipartFile 업데이트할 이미지 파일들을 담은 List<MultipartFile> 객체
	 * @return ModelAndView 객체에 view를 설정한 후 반환
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
	 * 조원재 이미지 파일 업데이트 API
	 * @param review_idx 리뷰의 인덱스 값
	 * @param reviewDTO 리뷰 데이터를 담은 ReviewDTO 객체
	 * @param mv ModelAndView 객체
	 * @param multipartFile 업데이트할 이미지 파일들을 담은 List<MultipartFile> 객체
	 * @param succeessIdx 성공적으로 업데이트된 리뷰의 인덱스 값
	 */
	private void ImgFileUpdate(int review_idx, ReviewDTO reviewDTO, ModelAndView mv,
							   List<MultipartFile> multipartFile, int succeessIdx) {
		try {
			if(multipartFile !=null || !multipartFile.isEmpty()) { // 이미지 파일이 존재하는 경우
				List<String> imgList = s3FileUploadService.upload(multipartFile); // 서버에 이미지 저장 후 URL 주소 list에 담기
				reviewDTO.setR_img(imgList);
				reviewDTO.setReview_idx(succeessIdx);
				this.reviewService.updateImg(reviewDTO);
			}
		} catch (IOException e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 조원재 리뷰 삭제
	 * @param review_idx 삭제할 리뷰의 인덱스 값
	 * @param reviewDTO 삭제할 리뷰 데이터를 담은 ReviewDTO 객체
	 * @param mv ModelAndView 객체
	 * @return ModelAndView 객체에 view를 설정한 후 반환
	 */
	@PostMapping("delete/{review_idx}")
	public ModelAndView delete(@PathVariable int review_idx, ReviewDTO reviewDTO, ModelAndView mv) {
		reviewDTO.setReview_idx(review_idx);
		boolean success = this.reviewService.delete(reviewDTO); // 게시글 삭제 (이미지 제외)
		try {
			this.reviewService.updateDeleteImg(reviewDTO); // 이미지 삭제(실제 삭제x)
		} catch (Exception e) {
			// 예외 처리
			e.printStackTrace();;
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
	 * 조원재 리스트 조회, 검색, 페이징
	 * @param mv ModelAndView 객체
	 * @param cri 페이징을 위한 Criteria 객체
	 * @param reviewDTO 리뷰 데이터를 담은 ReviewDTO 객체
	 * @return ModelAndView 객체에 데이터와 view를 설정한 후 반환
	 */
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv, Criteria cri, ReviewDTO reviewDTO) {
		try {
			reviewDTO.setKeyword(cri.getKeyword()); // 검색 키워드 할당
			reviewDTO.setOption(cri.getOption()); // 검색 옵션 할당
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
			e.printStackTrace();;
		}
		return mv;
	}
}
