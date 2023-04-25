/* 전체 코드 작업자 : 장민실 */

// input 입력 제한
	$(document).ready(function() {
		// 이메일 - 영문 대,소문자 / 숫자 / 특수문자 @ . 만 허용
	    $(".id_email").on("keydown", function() {
	        $(this).val($(this).val().replace(/[^a-zA-Z0-9@\.]$/, ""));
	        $(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    $(".id_email").focusout(function() {
	        $(this).val($(this).val().replace(/[^a-zA-Z0-9@\.]$/, ""));
	        $(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    
		// 아이디 - 입력받는 영문자 무조건 소문자로 변환
		$(".pw_id").css("text-transform", "lowercase");
	    $(".pw_id").on("keyup", function() {
	        $(this).val($(this).val().toLowerCase());
	    });
	    
		// 아이디 - 영문 소문자 및 숫자만 허용
	    $(".pw_id").on("keydown", function() {
	        $(this).val($(this).val().replace(/[^a-z0-9]$/, ""));
	        $(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    $(".pw_id").focusout(function() {
	        $(this).val($(this).val().replace(/[^a-z0-9]$/, ""));
	        $(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    
		 // 핸드폰번호 - 숫자만 허용
		    $(".id_hp, .pw_hp").on("keydown", function() {
		    	$(this).val($(this).val().replace(/[^0-9]$/, ""));
		    	$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
		    });
		    $(".id_hp, .pw_hp").focusout(function() {
		    	$(this).val($(this).val().replace(/[^0-9]$/, ""));
		    	$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
		    });
		    $(".id_hp, .pw_hp").focusout(function() {
		    	$(this).val($(this).val().replace(/^([0-9]{3})([0-9]{3,4})([0-9]{4})$/, '$1-$2-$3'));
		    }); 
	});	// function end

// 아이디 찾기 > 현재 DB에 중복정보 다량으로 기능구현 완료 후 주석처리
//$(".find_id").on('click', function() {
//	var email = $(".id_email").val();
//	var hp = $(".id_hp").val();
//	
//	if(email==="") {
//		$(".id_text").html("이메일을 입력해 주세요");
//		$(".id_text").css("color", "red");
//	}	// email 공란 if end
//	else if(hp==="") {
//		$(".id_text").html("핸드폰번호를 입력해 주세요");
//		$(".id_text").css("color", "red");
//	}	// hp 공란 else if end
//	else if(email!=""||hp!="") {
//		$.ajax({
//			data : { email : email, hp : hp },
//			url : "/user/find_id",
//			type : "POST",
//			success : function(id) {
//				$(".id_text").html("회원님의 아이디는 " + id +"입니다");
//				$(".id_text").css("color", "black");
//			}	// success end
//		});	// ajax end
//	}	// 둘다 입력 else if end
//});	// function end

// 비밀번호 찾기
$(".find_pw").on('click', function() {
//	var id = $(".pw_id").val();
//	var hp = $(".pw_hp").val();
//	var change_pw = $(".change_pw").val();
//	
//	if(id==="") {
//		$(".pw_text").html("아이디를 입력해 주세요");
//		$(".pw_text").css("color", "red");
//	}	// id 공란 if end
//	else if(hp==="") {
//		$(".pw_text").html("핸드폰번호를 입력해 주세요");
//		$(".pw_text").css("color", "red");
//	}	// hp 공란 else if end
//	else if(id!=""||hp!="") {
//		$.ajax({
//			data : { id : id, hp : hp },
//			url : "/user/find_get_pw",
//			type : "POST",
//			success : function(before_pw) {
//				if(before_pw===null) {
//					$(".pw_text").html("정보를 다시 확인해주세요");
//					$(".pw_text").css("color", "red");
//				}	// id, hp 일치하는 정보의 pw가 DB에 없을경우 if end
//				else if(before_pw!=null) {
					$(".change_pw_section").addClass("show");
//				}	// id, hp 일치하는 정보의 pw가 DB에 있을경우 else if end
//			}	// success end
//		});	// ajax end
//	}	// 둘다 입력 else if end
});	// function end

// 비밀번호 변경 모달창 닫기
$(".close_icon").on("click", function() {
	$(".change_pw_section").removeClass("show");
	$(".change_pw_origin").val("");
	$(".change_pw_copy").val("");
	$(".origin_alert_text").empty();
	$(".copy_alert_text").empty();
	$(".change_pw_msg").empty();
});
	
// 비밀번호 변경 input type text/password 전환
$(".origin_pw_hide").on("click", function() {
	if($(".change_pw_origin").attr("type")==="password"){
		$(".change_pw_origin").prop("type", "text");
		$(".origin_pw_hide").removeClass("fa-eye-slash").addClass("fa-eye");
	}
	else {
		$(".change_pw_origin").prop("type", "password");
		$(".origin_pw_hide").removeClass("fa-eye").addClass("fa-eye-slash");
	}		
});

$(".copy_pw_hide").on("click", function() {
	if($(".change_pw_copy").attr("type")==="password"){
		$(".change_pw_copy").prop("type", "text");
		$(".copy_pw_hide").removeClass("fa-eye-slash").addClass("fa-eye");
	}
	else {
		$(".change_pw_copy").prop("type", "password");
		$(".copy_pw_hide").removeClass("fa-eye").addClass("fa-eye-slash");
	}		
});