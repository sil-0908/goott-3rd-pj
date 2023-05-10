package com.goott.pj3.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goott.pj3.user.dto.UserDTO;
import com.goott.pj3.user.service.UserService;

// 장민실 23.04.04
@Controller
@RequestMapping("/user/**")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	// 추가필요 : 카카오, 네이버, 구글 로그인 API / 회원가입할때 핸드폰 인증 / 비밀번호 찾기
	
//	회원가입 페이지 이동
	@GetMapping("signup")
	public String go_sign_up() {
		return "user/sign_up";
	}
	
//	아이디 비밀번호 찾기 페이지 이동
	@GetMapping("find_user")
	public String go_find_user() {
		return "user/find_user";
	}
	
//	사용자 마이페이지 이동
	@GetMapping("userpage")
	public String go_user_page() {
		return "user/user_page";
	}
	
//	플래너 마이페이지 이동
	@GetMapping("plannerpage")
	public String go_planner_page() {
		return "user/planner_page";
	}
	
//	회원가입
	@PostMapping("signup")
	public String sign_up(UserDTO u_dto) {
		userService.sign_up(u_dto);
		return "redirect:/";
	}
	
//	회원가입 이용약관
	@GetMapping("signup_accept")
	public Map<String, UserDTO> signup_accept() {
		List<UserDTO> accept_list = userService.get_signup_accept();
		Map<String, UserDTO> accept_map = new HashMap<String, UserDTO>();
		for (UserDTO accept : accept_list) {
			accept_map.put(accept.getAccept_id(), accept);
		}
		return accept_map;
	}
	
//	아이디 중복체크
	@PostMapping("id_chk")
	@ResponseBody
	public int id_chk(@RequestParam String id) {
		int cnt = userService.id_chk(id);
		return cnt;
	}
	
//	로그인
	@PostMapping("signin")
	@ResponseBody
	public Map<String, String> sign_in(@RequestParam("id") String id, @RequestParam("pw") String pw, UserDTO u_dto, HttpSession session) {
		u_dto.setUser_id(id);
		u_dto.setPw(pw);
		UserDTO ur_dto = userService.sign_in(u_dto);
        Map<String, String> signin_map = new HashMap<>();
		if(ur_dto != null) {
			if(ur_dto.getAuth().equals("auth_a")) {
				signin_map.put("msg", "admin");
			}	// 로그인 시도 계정이 관리자 권한일때 if end
			else {
				// 사용자 탈퇴여부 확인 추가 - 장민실 23.04.07
				String user_del_yn = ur_dto.getU_del_yn();	// 사용자 탈퇴 여부 : n=미탈퇴, y=탈퇴
				if(user_del_yn.equals("n")) {
					session.setAttribute("user_id", ur_dto.getUser_id());
					session.setAttribute("auth", ur_dto.getAuth());
					session.setMaxInactiveInterval(1800);	// 초 단위 : 30분
					signin_map.put("msg", "success");
					signin_map.put("view", "/");
				}	// 탈퇴하지 않은 사용자일때 if end
				else {
					signin_map.put("msg", "user_del_y");
				}	// 탈퇴한 사용자일때 else if end
			}	// 로그인 시도 계정이 관리자 이외일때 else if end
		}	// 사용자 있을때 if end
		else {
			signin_map.put("msg", "not_user");
		}	// 사용자 없을때 else if end
		return signin_map;
	}
	
//	로그아웃
	@GetMapping("sign_out")
	public String sign_out(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
//	아이디 찾기
	@PostMapping("find_id")
	@ResponseBody
	public String find_id(@RequestParam("email") String email, @RequestParam("hp") String hp, UserDTO u_dto) {
//		휴대폰 인증기능 완료되면 휴대폰인증 추가하기
		u_dto.setEmail(email);
		u_dto.setHp(hp);
		String id = userService.find_id(u_dto);
		return id;
	}
	
//	비밀번호 찾기
	@PostMapping("find_get_pw")
	@ResponseBody
	public String find_get_pw(@RequestParam("id") String id, @RequestParam("hp") String hp, UserDTO u_dto) {
		u_dto.setUser_id(id);
		u_dto.setHp(hp);
		String origin_pw = userService.find_get_pw(u_dto);	// 입력정보와 일치하는 비밀번호 담아오기
		return origin_pw;
	}
	
//	새로운 비밀번호 저장
	@PostMapping("find_set_pw")
	@ResponseBody
	public Map<String, String> find_set_pw(@RequestParam("id") String id, @RequestParam("hp") String hp, @RequestParam("pw") String pw, UserDTO u_dto) {
		u_dto.setUser_id(id);
		u_dto.setHp(hp);
		u_dto.setPw(pw);
		int pw_cnt = userService.pw_cnt(u_dto);	// 비밀번호 일치 여부 : 1=새로운 비밀번호와 DB 비밀번호 동일, 0=동일하지 않음
		Map<String, String> setpw_map = new HashMap<>();
		if(pw_cnt==1) {
			setpw_map.put("msg", "same_pw");
		}
		else if(pw_cnt==0) {
			userService.set_new_pw(u_dto);
			setpw_map.put("msg", "different_pw");
			setpw_map.put("view", "/");
		}
		return setpw_map;
	}
	
//	사용자 마이페이지
	@PostMapping("user_page")
	@ResponseBody
	public Map<String, UserDTO> user_page(@RequestParam("id") String id, HttpSession session, UserDTO u_dto) {
		Map<String, UserDTO> mypage_map = new HashMap<>();
		String session_id = (String)session.getAttribute("user_id");
		String auth = (String)session.getAttribute("auth");
		if(!id.equals(session_id)) {
			u_dto.setUser_id(id);
			mypage_map.put("planner_dto", userService.get_planner_info(u_dto));
		}	// 로그인 사용자와 마이페이지 주인이 동일할 경우 if end
		else {
			if(auth.equals("auth_c")) {
				u_dto.setUser_id(session_id);
				mypage_map.put("dto", userService.get_user_my_info(u_dto));
			}	// 접속자가 일반사용자 본인일때 if end
			else if(auth.equals("auth_b")) {
				u_dto.setUser_id(session_id);
				mypage_map.put("dto", userService.get_planner_my_info(u_dto));
			}	// 접속자가 플래너 본인일때 else if end
		}	// 로그인 사용자와 마이페이지 주인이 동일할 경우 else if end
		return mypage_map;
	}
	
	
	
}
