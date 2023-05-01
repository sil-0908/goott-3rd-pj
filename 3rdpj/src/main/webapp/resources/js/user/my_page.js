//	엔터키 입력방지 걸기(키코드 : 13, 108) - 장민실 23.04.04
	document.addEventListener('keydown', function(e){
		if(e.keyCode === 13 || e.keyCode === 108) {
			e.preventDefault();
		}
	});
//	
//// 회원가입 페이지 이동 - 장민실 23.04.04
//	$("#sign_up").click(function(){
//		location.href = "/user/signup";
//	});
//
//// 로그인 페이지 이동 - 장민실 23.04.04
//	$("#sign_in").click(function(){
//		location.href = "/user/signin";
//	});
//	
//// 로그아웃 - 장민실 23.04.04
//	$("#sign_out").click(function(){
//		location.href = "/user/signout";
//	})
//	
//// 아이디/비밀번호 찾기 이동 - 장민실 23.04.19
//	$("#find_user").click(function() {
//		location.href = "/user/find_user";
//	})
	
//	사용자 마이페이지 이동 - 장민실 23.05.01
	$(".go_user_page").click(function() {
		location.href = "/user/userpage";
	})
	
