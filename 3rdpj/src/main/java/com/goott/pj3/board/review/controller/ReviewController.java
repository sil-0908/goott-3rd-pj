package com.goott.pj3.board.review.controller;

import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.FileUploadUtil;
import com.goott.pj3.common.util.S3FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.goott.pj3.board.review.service.ReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
	@RequestMapping("create")
	public ModelAndView create(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/review/review_create");
		return mv;
	}

	/**
	 * 조원재 23.04.05 리뷰 생성
	 * 		 23.04.17 파일 업로드 기능 추가
	 * @param map
	 * @param httpSession
	 * @return
	 */

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map, HttpSession httpSession,
								   @RequestParam("file") MultipartFile multipartFile) {
		String user_id = httpSession.getAttribute("user_id").toString();
		ModelAndView mv = new ModelAndView();
		imgUpload(map, multipartFile); // 이미지 파일 업로드 API
		map.put("user_id", user_id);
		String review_idx = this.reviewService.create(map);
		if (review_idx.equals(null)) {
			mv.setViewName("redirect:/review/review_create");
		} else {
			mv.setViewName("redirect:/review/detail?review_idx=" + review_idx);
		}
		return mv;
	}

	// 23.04.17. 이미지 파일 업로드 API
	private void imgUpload(Map<String, Object> map, MultipartFile multipartFile) {
		try {
			if(multipartFile != null){
				String uploadData = s3FileUploadService.upload(multipartFile);
				map.put("review_img", uploadData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
		 * 조원재 23.04.05 리뷰 디테일 페이지 호출
		 * @param map
		 * @return
		 */
		@RequestMapping("detail")
		public ModelAndView detail(@RequestParam Map<String, Object> map){
			ModelAndView mv = new ModelAndView();
			Map<String, Object> detail = this.reviewService.detail(map);
			mv.addObject("data", detail);
			String review_idx = map.get("review_idx").toString();
			mv.addObject("review_idx", review_idx);
			mv.setViewName("/board/review/review_detail");
			return mv;
		}
		return mv;
	}
  
	/**
	 * 조원재 23.04.05 리뷰 리스트 조회 및 검색
	 * @param map
	 * @return
	 */	
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv, Criteria cri){
		mv.addObject("paging", reviewService.paging(cri));
		mv.addObject("data", reviewService.list(cri));
		mv.setViewName("/board/review/review_list");
		return mv;
	}
  
		/**
		 * 조원재 23.04.05 리뷰 수정 화면 호출
		 * @param map
		 * @return
		 */
		@RequestMapping("update")
		public ModelAndView update(@RequestParam Map<String, Object> map) {
			ModelAndView mv = new ModelAndView();
			Map<String, Object> detail = this.reviewService.detail(map);
			mv.addObject("data", detail);
			mv.setViewName("board/review/review_update");
			return mv;
		}
    
		/**
		 * 조원재 23.04.05 리뷰 수정 기능
		 * @param map
		 * @return
		 */
		@RequestMapping(value = "update", method = RequestMethod.POST)
		public ModelAndView updatePost(@RequestParam Map<String, Object> map){
			ModelAndView mv = new ModelAndView();
			boolean update = this.reviewService.update(map);
			if(update){
				String review_idx = map.get("review_idx").toString();
				mv.setViewName("redirect:/review/detail?review_idx="+review_idx);
			} else {
				mv = this.update(map);
			}
			return mv;
		}
    
		/**
		 * 조원재 23.04.05 리뷰 삭제
		 * @param map
		 * @return
		 */
		@RequestMapping(value="delete", method = RequestMethod.POST)
		public ModelAndView delete(@RequestParam Map<String, Object> map){
			ModelAndView mv = new ModelAndView();
			boolean delete = this.reviewService.delete(map);
			if (delete){
				mv.setViewName("redirect:/review/review_list");
			} else {
				String review_idx = map.get("review_idx").toString();
				mv.setViewName("redirect:/review/detail?review_idx="+review_idx);
			}
			return mv;
		}
    
		/**
		 * 조원재 23.04.05 리뷰 리스트 조회 및 검색
		 * @param map
		 * @return
		 */
		@RequestMapping("list")
		public ModelAndView list(@RequestParam Map<String, Object> map){
			System.out.println("listMap : " + map);
			ModelAndView mv = new ModelAndView();
			List<Map<String, Object>> reviewList = this.reviewService.list(map);
			mv.addObject("data", reviewList);
			if(map.containsKey("keyword")){
				mv.addObject("keyword", map.get("keyword"));
			}
			mv.setViewName("/board/review/review_list");
			return mv;
		}
}
