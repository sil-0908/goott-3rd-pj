/* 전체 코드 작업자 : 장민실 */

// 회원가입 페이지 이동
	$(".sign_up_span").on('click', function(){
		location.href = "/user/signup";
	});
	
// 아이디/비밀번호 찾기
	$(".forgot_info").on('click', function() {
		location.href = "/user/find_user";
	})
	
// input 입력 제한
	$(document).ready(function() {
		// 아이디, 비밀번호 - 입력받는 영문자 무조건 소문자로 변환
		$(".id, .pw").css("text-transform", "lowercase");
	    $(".id, .pw").on("keyup", function() {
	        $(this).val($(this).val().toLowerCase());
	    });
	    
		// 아이디 - 영문 소문자 및 숫자만 허용
	    $(".id").on("keydown", function() {
	        $(this).val($(this).val().replace(/[^a-z0-9]$/, ""));
	        $(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    $(".id").focusout(function() {
	        $(this).val($(this).val().replace(/[^a-z0-9]$/, ""));
	        $(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    
	    // 비밀번호 - 영문 소문자 및 숫자와 특수문자 ?!@#$%^&* 만 허용
	    $(".pw").on("keydown", function() {
	    	$(this).val($(this).val().replace(/[^a-z0-9\?!@#\$%\^&\*]$/, ""));
	    	$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    $(".pw").focusout(function() {
	    	$(this).val($(this).val().replace(/[^a-z0-9\?!@#\$%\^&\*]$/, ""));
	    	$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	});	// function end
	
// 로그인 모달
	// 모달창 열기
	$(".sign_in").on("click", function(){		
		$(".signin_section").addClass("show");
	});
	
	// 모달창 닫기
	$(".close_icon").on("click", function() {
		$(".signin_section").removeClass("show");
		$(".id").val("");
		$(".pw").val("");
		$(".id_alert_text").empty();
		$(".pw_alert_text").empty();
		$(".signin_msg").empty();
	});
	
	// pw input type text/password 전환
	$(".pw_hide").on("click", function() {
		if($(".pw").attr("type")==="password"){
			$(".pw").prop("type", "text");
			$(".pw_hide").removeClass("fa-eye-slash").addClass("fa-eye");
		}
		else {
			$(".pw").prop("type", "password");
			$(".pw_hide").removeClass("fa-eye").addClass("fa-eye-slash");
		}		
	});

// 로그인
	$(".signin_btn").on('click', function(){
		var id = $(".id").val();
		var pw = $(".pw").val();
		
		if(id==="") {
			$(".id_alert_text").html("아이디를 입력해 주세요");
			$(".id_alert_text").css("color", "red");
		}	// 아이디 공란일 경우 if end
		else if(pw==="") {
			$(".pw_alert_text").html("비밀번호를 입력해 주세요");
			$(".pw_alert_text").css("color", "red");
		}	// 비밀번호 공란일 경우 else if end
		
		else if(id!=""||pw!="") {
			$.ajax({
				data : { id : id, pw : pw },
				url : "/user/signin",
				type : "POST",
				dataType : "json",
				success : function(data) {
					if(data.signin_msg.msg==="success") {
						location.href = "/user/mypage";
					}
					else if(data.signin_msg.msg==="user_del_y") {
						$(".signin_msg").html("탈퇴한 사용자 입니다. 탈퇴 취소는 고객센터로 문의 바랍니다.");
						$(".signin_msg").css("color", "red");
					}
					else if(data.signin_msg.msg==="not_user") {
						$(".signin_msg").html("로그인 실패. 다시 확인해주세요");
						$(".signin_msg").css("color", "red");
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