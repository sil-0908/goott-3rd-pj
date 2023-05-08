package com.goott.pj3.travelinfo.controller;


import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.goott.pj3.common.util.auth.Auth;
import com.goott.pj3.common.util.aws.S3FileUploadService;
import com.goott.pj3.common.util.paging.Criteria;
import com.goott.pj3.travelinfo.dto.TravelInfoDTO;
import com.goott.pj3.travelinfo.service.TravelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/travelinfo/**")
public class TravelInfoController {

	@Autowired
	TravelInfoService travelInfoService;

	// AWS S3 파일 업로드
	@Autowired
	S3FileUploadService s3FileUploadService;

	/**
	 * 여행지 정보 생성 페이지 호출
	 * 페이지 URL: /create
	 * GET 요청
	 * @return ModelAndView 객체를 통해 여행지 정보 뷰에 반환
	 */
	@Auth(role = Auth.Role.ADMIN)
	@GetMapping("create")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/travelinfo/travelinfo_create");
		return mv;
	}

	/**
	 * 여행지 정보 생성
	 * 이미지 파일 업로드 기능 추가
	 * @param travelInfoDTO    여행지 정보를 담은 TravelInfoDTO 객체
	 * @param mv               ModelAndView 객체
	 * @param httpSession      현재의 HttpSession 객체
	 * @param multipartFile    업로드된 이미지 파일 리스트
	 * @return ModelAndView 객체를 통해 처리 결과에 따른 뷰 이름을 설정하여 반환
	 */
	@Auth(role = Auth.Role.ADMIN)
	@PostMapping("create")
	public ModelAndView createPost(TravelInfoDTO travelInfoDTO, ModelAndView mv, HttpSession httpSession,
								   @RequestParam("file[]") List<MultipartFile> multipartFile) {
		try {
			// 현재 로그인한 유저의 아이디를 세션
			String user_id = (String) httpSession.getAttribute("user_id");
			// DTO에 유저 아이디 할당
			travelInfoDTO.setUser_id(user_id);
			// 여행지 정보를 생성, 생성된 게시글의 인덱스 리턴
			int travel_location_idx = this.travelInfoService.create(travelInfoDTO);
			// 이미지 파일 업로드를 수행합니다.
			if (travel_location_idx != 0) {
				// 이미지 파일 업로드
				imgFileUpload(travelInfoDTO, multipartFile, travel_location_idx);
				mv.setViewName("redirect:/travelinfo/detail/" + travel_location_idx);
			} else {
				mv.setViewName("travelinfo/travelinfo_create");
			}
		} catch (Exception e) {
			// 에러 처리
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 이미지 파일 업로드 API
	 * @param travelInfoDTO 여행지 정보 DTO
	 * @param multipartFile 업로드할 이미지 파일 리스트
	 * @param travel_location_idx 생성된 여행지 게시글의 인덱스
	 */
	private void imgFileUpload(TravelInfoDTO travelInfoDTO, List<MultipartFile> multipartFile, int travel_location_idx) {
		try {
			if (multipartFile != null && !multipartFile.isEmpty()) {
				// 이미지 파일이 존재하는 경우
				List<String> imgList = s3FileUploadService.upload(multipartFile);
				travelInfoDTO.setT_img(imgList);
				travelInfoDTO.setTravel_location_idx(travel_location_idx);
				this.travelInfoService.createImg(travelInfoDTO);
			} else {
				// 이미지 파일이 없는 경우
				travelInfoDTO.setTravel_location_idx(travel_location_idx);
				this.travelInfoService.createImg(travelInfoDTO);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 여행지 정보 디테일 페이지 호출
	 * @param travel_location_idx 조회할 여행지 게시글의 인덱스
	 * @param travelInfoDTO 여행지 정보 DTO
	 * @param mv ModelAndView 객체
	 * @return ModelAndView 여행 상세 정보 뷰로 리턴
	 */
	@GetMapping("detail/{travel_location_idx}")
	public ModelAndView detail(@PathVariable int travel_location_idx,
							   TravelInfoDTO travelInfoDTO, ModelAndView mv) {
		// 여행 정보 인덱스 할당
		travelInfoDTO.setTravel_location_idx(travel_location_idx);
		// 여행 정보 조회
		TravelInfoDTO detail = this.travelInfoService.detail(travelInfoDTO);
		mv.addObject("data", detail);
		mv.setViewName("travelinfo/travelinfo_detail");
		return mv;
	}

	/**
	 * 여행지 정보 수정 페이지 호출
	 * @param travel_location_idx 수정할 여행 정보 인덱스
	 * @param travelInfoDTO 여행지 정보 DTO
	 * @param mv ModelAndView
	 * @return ModelAndView 기존 여행 상세 정보 리턴
	 */
	@GetMapping("update/{travel_location_idx}")
	public ModelAndView update(@PathVariable int travel_location_idx,
							   TravelInfoDTO travelInfoDTO, ModelAndView mv) {
		// 조회 할 인덱스 번호 할당
		travelInfoDTO.setTravel_location_idx(travel_location_idx);
		// 여행 정보 게시글 리턴
		TravelInfoDTO detail = this.travelInfoService.detail(travelInfoDTO);
		mv.addObject("data", detail); // 게시글 정보
		mv.setViewName("travelinfo/travelinfo_update");
		return mv;
	}

	/**
	 * 여행지 정보 수정
	 * @param travel_location_idx 수정할 여행지 게시글의 인덱스
	 * @param travelInfoDTO 여행지 정보 DTO
	 * @param mv ModelAndView 객체
	 * @param multipartFile 업데이트할 이미지 파일 리스트
	 * @return ModelAndView 수정된 상세 페이지 리턴
	 */
	@PostMapping("update/{travel_location_idx}")
	public ModelAndView updatePost(@PathVariable int travel_location_idx, TravelInfoDTO travelInfoDTO,
								   ModelAndView mv,
								   @RequestParam("file[]") List<MultipartFile> multipartFile) {
		// 조회 할 인덱스 할당
		travelInfoDTO.setTravel_location_idx(travel_location_idx);
		// 본문 내용 업데이트 (이미지 제외) 및 성공한 인덱스 반환
		int succeessIdx = this.travelInfoService.update(travelInfoDTO);
		// 서버 기존 이미지 파일 삭제
		for(String fileName : this.travelInfoService.detail(travelInfoDTO).getT_img()){ // URL주소 하나씩 가져와서
			s3FileUploadService.deleteFromS3(fileName); // 서버에서 삭제
		}
		// 기존 이미지 URL 주소 DB에서 삭제
		this.travelInfoService.deleteImg(travelInfoDTO);
		// 이미지 파일 업데이트
		ImgFileUpdate(travelInfoDTO, multipartFile, succeessIdx);
		mv.setViewName("redirect:/travelinfo/detail/" + travel_location_idx);
		return mv;
	}

	/**
	 * 이미지 파일 업데이트 API
	 * @param travelInfoDTO 여행지 정보 DTO
	 * @param multipartFile 업데이트할 이미지 파일 리스트
	 * @param successIdx 성공한 인덱스
	 */
	private void ImgFileUpdate(TravelInfoDTO travelInfoDTO,
							   List<MultipartFile> multipartFile, int successIdx) {
		try {
			if (multipartFile !=null || !multipartFile.isEmpty()) {
				List<String> imgList = s3FileUploadService.upload(multipartFile);
				travelInfoDTO.setT_img(imgList);
				travelInfoDTO.setTravel_location_idx(successIdx);
				this.travelInfoService.updateImg(travelInfoDTO);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 여행지 정보 삭제
	 * @param travel_location_idx 여행지 게시글의 인덱스
	 * @param travelInfoDTO 여행지 정보 DTO
	 * @param mv ModelAndView 객체
	 * @return 여행지 게시글
	 */
	@PostMapping("delete/{travel_location_idx}")
	public ModelAndView delete(@PathVariable int travel_location_idx,
							   TravelInfoDTO travelInfoDTO, ModelAndView mv) {
		travelInfoDTO.setTravel_location_idx(travel_location_idx);
		boolean success = this.travelInfoService.delete(travelInfoDTO); // 게시글 삭제(이미지 제외)
		try {
			TravelInfoDTO detailDTO = this.travelInfoService.detail(travelInfoDTO); // 리뷰 상세 정보 가져오기
			if (detailDTO != null && detailDTO.getT_img() != null){ // 이미지 파일 있는 경우
				for(String fileName : detailDTO.getT_img()){ // 서버에서 이미지 삭제
					s3FileUploadService.deleteFromS3(fileName);
				}
			}
			this.travelInfoService.deleteImg(travelInfoDTO); // DB에서 이미지 URL삭제
		} catch (Exception e) {
			//예외 처리
			e.printStackTrace();;
		}
		if (success) {
			mv.setViewName("redirect:/travelinfo/list");
		} else {
			mv.setViewName("redirect:/travelinfo/detail/" + travel_location_idx);
		}
		return mv;
	}

	/**
	 * 리스트 조회, 검색, 페이징
	 * @param mv ModelAndView 객체
	 * @param cri 페이징 및 검색 조건을 담은 Criteria 객체
	 * @param travelInfoDTO 여행지 정보 DTO
	 * @return 리스트 조회 결과 리턴
	 */
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv, Criteria cri, TravelInfoDTO travelInfoDTO) {
		try {
			travelInfoDTO.setKeyword(cri.getKeyword()); // 검색어 할당
			travelInfoDTO.setOption(cri.getOption()); // 검색 옵션 할당
			List<TravelInfoDTO> originalList = travelInfoService.imgList(travelInfoDTO);
			System.out.println("originalList : " + originalList);
			List<TravelInfoDTO> newList = new ArrayList<>(); // 인덱스와 첫번째 이미지만 담을 List 생생
			for (TravelInfoDTO dto : originalList) {
				List<String> tImgList = dto.getT_img(); // 이미지만 List에 담기
				if (tImgList != null && !tImgList.isEmpty()) { // 이미지가 있는 경우
					String firstImg = tImgList.get(0); // 첫번째 이미지 변수에 담기
					TravelInfoDTO newDto = new TravelInfoDTO(); // 인덱스+첫번째 이미지 값 담을 dto
					newDto.setTravel_location_idx(dto.getTravel_location_idx()); // 인덱스 담기
					newDto.setT_img(Collections.singletonList(firstImg)); // 첫번째 이미지 담기
					newList.add(newDto);
				}
			}
			System.out.println("newList" + newList);
			mv.addObject("imgList", newList);
			mv.addObject("paging", travelInfoService.paging(cri));
			mv.addObject("data", travelInfoService.list(cri));
			mv.setViewName("/travelinfo/travelinfo_list");
		} catch (Exception e) {
			// 예외 처리
			System.out.println("여행정보 목록 조회 중 오류가 발생했습니다 : " + e.getMessage());
			mv.setViewName("error/500");
		}
		return mv;
	}
}
