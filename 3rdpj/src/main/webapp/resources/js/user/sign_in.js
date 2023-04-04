// 그냥 로그인 버튼 클릭했을때 로그인 진행하기
	$("#sign_in").on('click', function(){
		var id = $("#user_id").val();
		var pw = $("#pw").val();
		
		if(id==="") {
			$("#signin_chk_text").html("아이디를 입력해 주세요");
			$("#signin_chk_text").css("color", "red");
		}	// 아이디 공란일 경우 if end
		else if(pw==="") {
			$("#signin_chk_text").html("비밀번호를 입력해 주세요");
			$("#signin_chk_text").css("color", "red");
		}	// 비밀번호 공란일 경우 else if end
		else if(id!=""||pw!="") {
			$.ajax({
				data : { id : id, pw : pw },
				url : "/user/signin/",
				type : "POST",
				success : function() {
					// 처리중
				}
			})
		}	// 모두 입력되었을때 else if end
	});

// 회원가입 페이지 이동
	$("#sign_up").click(function(){
		location.href = "/user/signup";
	});
	
// 메인으로 페이지 이동
	$("#main").click(function() {
		location.href = "/user/mypage";
	})
	
//	엔터키 입력방지 걸기(키코드 : 13, 108)
	document.addEventListener('keydown', function(e){
		if(e.keyCode === 13 || e.keyCode === 108) {
			e.preventDefault();
		}
	});