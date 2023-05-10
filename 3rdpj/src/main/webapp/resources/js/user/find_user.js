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
		
		// 비밀번호, 비밀번호 확인 - 입력받는 영문자 무조건 소문자로 변환
		$(".change_pw_origin, .change_pw_copy").css("text-transform", "lowercase");
	    $(".change_pw_origin, .change_pw_copy").on("keyup", function() {
	        $(this).val($(this).val().toLowerCase());
	    });
	    
	    // 비밀번호, 비밀번호 확인 - 영문 소문자 및 숫자와 특수문자 ?!@#$%^&* 만 허용
	    $(".change_pw_origin, .change_pw_copy").on("keydown", function() {
	    	$(this).val($(this).val().replace(/[^a-z0-9\?!@#\$%\^&\*]$/, ""));
	    	$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    $(".change_pw_origin, .change_pw_copy").focusout(function() {
	    	$(this).val($(this).val().replace(/[^a-z0-9\?!@#\$%\^&\*]$/, ""));
	    	$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
});	// function end

// 아이디 찾기
$(".find_id").on('click', function() {
	var email = $(".id_email").val();
	var hp = $(".id_hp").val();
	
	if(email==="") {
		$(".id_text").html("이메일을 입력해 주세요");
		$(".id_text").css("color", "red");
	}	// email 공란 if end
	else if(hp==="") {
		$(".id_text").html("핸드폰번호를 입력해 주세요");
		$(".id_text").css("color", "red");
	}	// hp 공란 else if end
	else if(email!=""||hp!="") {
		$.ajax({
			data : { email : email, hp : hp },
			url : "/user/find_id",
			type : "POST",
			success : function(id) {
				$(".id_text").html("회원님의 아이디는 " + id +"입니다");
				$(".id_text").css("color", "black");
			}	// success end
		});	// ajax end
	}	// 둘다 입력 else if end
});	// function end

// 비밀번호 찾기
$(".find_pw").on('click', function() {
	var id = $(".pw_id").val();
	var hp = $(".pw_hp").val();
	
	if(id==="") {
		$(".pw_text").html("아이디를 입력해 주세요");
		$(".pw_text").css("color", "red");
	}	// id 공란 if end
	else if(hp==="") {
		$(".pw_text").html("핸드폰번호를 입력해 주세요");
		$(".pw_text").css("color", "red");
	}	// hp 공란 else if end
	else if(id!=""||hp!="") {
		$.ajax({
			data : { "id" : id, "hp" : hp },
			url : "/user/find_get_pw",
			type : "POST",
			success : function(origin_pw) {
				if(origin_pw==="") {
					$(".pw_text").html("정보를 다시 확인해주세요");
					$(".pw_text").css("color", "red");
				}	// id, hp 일치하는 정보의 pw가 DB에 없을경우 if end
				else {
					$(".change_pw_section").addClass("show");
				}	// id, hp 일치하는 정보의 pw가 DB에 있을경우 else if end
			}	// success end
		});	// ajax end
	}	// 둘다 입력 else if end
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

// 새로운 비밀번호 유효성 검사
function pwd_chk() {
	var pwd = $('.change_pw_origin').val();
	var origin_pw_cnt;
	
	// 영문 소문자,숫자,특수문자 최소 1개 이상 입력 / 8~20자 / 공백X
	var pwd_valid = /^(?=.*[a-z])(?=.*[0-9])(?=.*[\?!@#\$%\^&\*])[a-z0-9\?!@#\$%\^&\*]{8,20}$/;
	
	if(pwd==="") {
		$(".origin_alert_text").html("8자리~20자리 영문,숫자,특수문자를 포함해 주세요<br>허용가능 특수문자 : ?!@#$%^&*");
		$(".origin_alert_text").css("color", "black");
		origin_pw_cnt = 0;
	}	// pwd 공란일때 if end
	else if(pwd_valid.test(pwd)!=true) {
		$(".origin_alert_text").html("8자리~20자리 영문,숫자,특수문자를 포함해 주세요<br>허용가능 특수문자 : ?!@#$%^&*");
		$(".origin_alert_text").css("color", "red");
		origin_pw_cnt = 0;
	}	// pwd 유효성검사 미통과 else if end
	else if(pwd_valid.test(pwd)==true) {
		$(".origin_alert_text").html("사용가능한 비밀번호 입니다");
		$(".origin_alert_text").css("color", "black");
		origin_pw_cnt = 1;
	}	// pwd 유효성검사 통과 else if end
	return origin_pw_cnt;
}	// function end

//비밀번호, 비밀번호 확인 값 일치여부 체크
function pwd_match(){
	var origin_pwd = $('.change_pw_origin').val();
	var copy_pwd = $('.change_pw_copy').val();
	var copy_pw_cnt;
	
	if(copy_pwd===""){
		$('.copy_alert_text').html("");
		copy_pw_cnt = 0;
	}	// 비밀번호 확인 공란일 경우 문구 지우기 위한 if end
	else if(origin_pwd===copy_pwd){
		$('.copy_alert_text').html("비밀번호가 일치합니다");
		$('.copy_alert_text').css("color", "black");
		copy_pw_cnt = 1;
	}	// 비밀번호와 비밀번호 확인이 일치할 경우 else if end
	else if(origin_pwd!==copy_pwd){
		$('.copy_alert_text').html("비밀번호가 일치하지 않습니다");
		$('.copy_alert_text').css("color", "red");
		copy_pw_cnt = 0;
	}	// 비밀번호와 비밀번호 확인이 불일치할 경우 else if end
	return copy_pw_cnt;
}	// function end

// 비밀번호 변경
$(".change_pw_btn").on('click', function() {
	var id = $(".pw_id").val();
	var hp = $(".pw_hp").val();
	var pw = $(".change_pw_origin").val();
	var origin_pw = pwd_chk();
	var copy_pw = pwd_match();
	var total = origin_pw+copy_pw;
	
	if(total<2) {
		$(".change_pw_msg").html("다시 확인해주세요");
		$(".change_pw_msg").css("style", "red");
	}	// 유효성 검사 미통과 혹은 불일치 할 경우 if end
	else if(total===2) {
		$.ajax({
			data : { "id" : id, "hp" : hp, "pw" : pw },
			url : "/user/find_set_pw",
			type : "POST",
			success : function(data) {
				if(data.msg==="same_pw") {
					$(".change_pw_msg").html("현재 사용중인 비밀번호와 일치합니다");
					$(".change_pw_msg").css("style", "red");
				}	// 해당 사용자가 사용중인 비밀번호일 경우 if end
				else if(data.msg==="different_pw") {
					alert("변경 완료");
					location.href = data.view;
				}	// 다른 비밀번호일 경우 else if end
			},	// success end
			error: function(xhr, status, error) {
	               console.log(xhr);
	               console.log(status);
	               console.log(error);
			}	// error end
		});	// ajax end
	}	// 유효성 검사 통과 및 일치할 경우 else if end
});	// function end