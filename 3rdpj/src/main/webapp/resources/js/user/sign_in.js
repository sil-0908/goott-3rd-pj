//	엔터키 입력방지 걸기(키코드 : 13, 108) - 장민실 23.04.04
	document.addEventListener('keydown', function(e){
		if(e.keyCode === 13 || e.keyCode === 108) {
			e.preventDefault();
		}
	});

// 메인으로 페이지 이동 - 장민실 23.04.04
	$("#main").click(function() {
		location.href = "/user/mypage";
	})

// 회원가입 페이지 이동 - 장민실 23.04.04
	$("#sign_up").click(function(){
		location.href = "/user/signup";
	});

// 그냥 로그인 버튼 클릭했을때 로그인 진행하기 - 장민실 23.04.04
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
				url : "/user/signin",
				type : "POST",
				dataType : "json",
				success : function(data) {
					console.log(data.signin_msg.msg);
					var msg_area = $("#signin_msg");
					if(data.signin_msg.msg==="success") {
						location.href = "/user/mypage";
					}
					else if(data.signin_msg.msg==="user_del_y") {
						$("#signin_msg").html("탈퇴한 사용자 입니다. 탈퇴 취소는 고객센터로 문의 바랍니다.");
						$("#signin_msg").css("color", "red");
					}
					else if(data.signin_msg.msg==="not_user") {
						$("#signin_msg").html("아이디 또는 비밀번호를 확인해주세요");
						$("#signin_msg").css("color", "red");
					}
				},	// success end
				error: function(xhr, status, error) {
		               console.log(xhr);
		               console.log(status);
		               console.log(error);
				}	// error end
			});	// ajax end
		}	// 모두 입력되었을때 else if end		
	});	// function end
	
	
	// ============================================= test
	const formOpenBtn = document.querySelector("#form-open"),
		home = document.querySelector(".home"),
		formContainer = document.querySelector(".form_container"),
		formCloseBtn = document.querySelector(".form_close"),
		signupBtn = document.querySelector("#signup"),
		loginBtn = document.querySelector("#login"),
		pwShowHide = document.querySelectorAll(".pw_hide");

	formOpenBtn.addEventListener("click", () => home.classList.add("show"));
	formCloseBtn.addEventListener("click", () => home.classList.remove("show"));

	pwShowHide.forEach((icon) => {
		icon.addEventListener("click", () => {
			let getPwInput = icon.parentElement.querySelector("input");
			if (getPwInput.type === "password") {
				getPwInput.type = "text";
				icon.classList.replace("uil-eye-slash", "uil-eye");
			}
			else {
				getPwInput.type = "password";
				icon.classList.replace("uil-eye", "uil-eye-slash");
			}
		});
	});

	signupBtn.addEventListener("click", (e) => {
		e.preventDefault();
		formContainer.classList.add("active");
	});
	loginBtn.addEventListener("click", (e) => {
		e.preventDefault();
		formContainer.classList.remove("active");
	});