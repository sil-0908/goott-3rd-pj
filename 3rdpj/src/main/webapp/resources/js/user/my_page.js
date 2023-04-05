//	엔터키 입력방지 걸기(키코드 : 13, 108)
	document.addEventListener('keydown', function(e){
		if(e.keyCode === 13 || e.keyCode === 108) {
			e.preventDefault();
		}
	});

// 로그인 페이지 이동
	$("#sign_in").click(function(){
		location.href = "/user/signin";
	});
	
// 로그아웃
	$("#sign_out").click(function(){
		location.href = "/user/signout";
	})
	
// 회원가입 페이지 이동
	$("#sign_up").click(function(){
		location.href = "/user/signup";
	});