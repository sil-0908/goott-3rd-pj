/* 전체 코드 작업자 : 장민실 */

// =================================== 공통 영역 start ===================================

	$(document).ready(function() {
// 전제 input 입력 제한
	// 아이디, 비밀번호, 비밀번호 확인 - 입력받는 영문자 무조건 소문자로 변환
		$(".user_id, .pw, .pw_chk").css("text-transform", "lowercase");
		$(".user_id, .pw, .pw_chk").on("keyup", function() {
	        $(this).val($(this).val().toLowerCase());
	    });
	    
		// 아이디 - 영문 소문자 및 숫자만 허용
	    $(".user_id").on("keydown", function() {
	        $(this).val($(this).val().replace(/[^a-z0-9]$/, ""));
	        $(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    $(".user_id").focusout(function() {	// on 만으로는 예외문자 완벽히 막지못해 추가 - 장민실 23.04.06
	        $(this).val($(this).val().replace(/[^a-z0-9]$/, ""));
	        $(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    
	    // 비밀번호, 비밀번호 확인 - 영문 소문자 및 숫자와 특수문자 ?!@#$%^&* 만 허용
	    $(".pw, .pw_chk").on("keydown", function() {
	    	$(this).val($(this).val().replace(/[^a-z0-9\?!@#\$%\^&\*]$/, ""));
	    	$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    $(".pw, .pw_chk").focusout(function() {
	    	$(this).val($(this).val().replace(/[^a-z0-9\?!@#\$%\^&\*]$/, ""));
	    	$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    
	    // 이메일 - 영문 대,소문자 / 숫자 / 특수문자 @ . 만 허용
	    $(".email").on("keydown", function() {
	        $(this).val($(this).val().replace(/[^a-zA-Z0-9@\.]$/, ""));
	        $(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    $(".email").focusout(function() {
	        $(this).val($(this).val().replace(/[^a-zA-Z0-9@\.]$/, ""));
	        $(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    
	    // 생년월일, 핸드폰번호 - 숫자만 허용
	    $(".birth, .hp").on("keydown", function() {
	    	$(this).val($(this).val().replace(/[^0-9]$/, ""));
	    	$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    $(".birth, .hp").focusout(function() {
	    	$(this).val($(this).val().replace(/[^0-9]$/, ""));
	    	$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/, ""));
	    });
	    $(".birth").focusout(function() {
	    	$(this).val($(this).val().replace(/^([0-9]{4})([0-9]{2})([0-9]{2})$/, '$1-$2-$3'));
	    });
	    $(".hp").focusout(function() {
	    	$(this).val($(this).val().replace(/^([0-9]{3})([0-9]{3,4})([0-9]{4})$/, '$1-$2-$3'));
	    }); 
	});	// function end
	
//	회원가입(엔터키)
	document.addEventListener('keydown', function(e){
		if(e.keyCode === 13 || e.keyCode === 108) {
			var id = id_chk(), origin_pwd = pwd_chk(), copy_pwd = pwd_match(), email = email_chk(),
			birth = birth_chk(), hp = hp_chk();
			var total = id+origin_pwd+copy_pwd+email+birth+hp;
			
			if(total<6) {
				$(".signup_chk_text").html("회원가입 실패! 입력 항목들을 다시 확인해주세요");
				$(".signup_chk_text").css("color", "red");
			}
			else if(total===6) {
				document.signup_form.action="/user/signup";
				document.signup_form.submit();
			}
		}
	});

// 회원가입(버튼클릭)
	$(".sign_up_btn").on('click', function(e){
	    var id = id_chk(), origin_pwd = pwd_chk(), copy_pwd = pwd_match(), email = email_chk(),
		birth = birth_chk(), hp = hp_chk();
		var total = id+origin_pwd+copy_pwd+email+birth+hp;
		
		if(total<6) {
			$(".signup_chk_text").html("회원가입 실패! 입력 항목들을 다시 확인해주세요");
			$(".signup_chk_text").css("color", "red");
		}
		else if(total===6) {
			document.signup_form.action="/user/signup";
			document.signup_form.submit();
		}
	});
	
// pw input type text/password 전환
	$(".origin_pw_hide").on("click", function() {
		if($(".pw").attr("type")==="password"){
			$(".pw").prop("type", "text");
			$(".origin_pw_hide").removeClass("fa-eye-slash").addClass("fa-eye");
		}
		else {
			$(".pw").prop("type", "password");
			$(".origin_pw_hide").removeClass("fa-eye").addClass("fa-eye-slash");
		}		
	});
	
	$(".copy_pw_hide").on("click", function() {
		if($(".pw_chk").attr("type")==="password"){
			$(".pw_chk").prop("type", "text");
			$(".copy_pw_hide").removeClass("fa-eye-slash").addClass("fa-eye");
		}
		else {
			$(".pw_chk").prop("type", "password");
			$(".copy_pw_hide").removeClass("fa-eye").addClass("fa-eye-slash");
		}		
	});

	
// =================================== 공통 영역 end ===================================
	
// =================================== 작업중 영역 start ===================================
// 차후 추가 필요 사항
	// 약관동의 완성되면 추가해서 필수체크 받을거랑 선택사항 선택해서 필수 체크 안하면 못넘어가게 처리	
	// 차후 비밀번호 text랑 password로 type바뀌는 작업 해야함 > view나오면 할 예정
	
// =================================== 작업중 영역 end ===================================
	
// =================================== 아이디 영역 start ===================================
	
// 아이디 유효성 검사, 중복검사
	function id_chk() {
		var id = $('.user_id').val();
		// 영문자 소문자,숫자만 입력 / 6~20자 / 공백X
		var id_valid = /^(?=.*[a-z])(?=.*[0-9])[a-z0-9]{6,20}$/;
		let id_cnt;
		
		if(id==="") {
			$('.id_chk_text').html("6자리~20자리 영문,숫자를 포함해 주세요");
			$('.id_chk_text').css("color", "black");
			id_cnt = 0;
		}	// id 공란일 경우 if end
		else if(id_valid.test(id)!=true) {
			$('.id_chk_text').html("아이디는 6자리~20자리의 영문,숫자 조합만 가능합니다");
			$('.id_chk_text').css("color", "red");
			id_cnt = 0;
		}	// id 유효성검사 미통과 else if end
		else if(id_valid.test(id)==true) {
			$.ajax({
				data : { id : id },
				url : "/user/id_chk",
				type : 'POST',
				async : false,	// ajax 내부의 id_cnt값이 원활하게 return 되지않아 추가 - 장민실 23.04.20 
				success : function(cnt){
					if(cnt===0){
						$('.id_chk_text').html("사용 가능한 아이디 입니다");
						$('.id_chk_text').css("color", "black");
						id_cnt = 1;
						return id_cnt;
					}	// 아이디 중복 없을경우 if end
					else if(cnt===1){
						$('.id_chk_text').html("이미 사용중인 아이디 입니다");
						$('.id_chk_text').css("color", "red");
						id_cnt = 0;
						return id_cnt;
					}	// 아이디 중복일 경우 else if end
				}	// success end
			});	// ajax end
		}	// id 유효성검사 통과 else if end
		return id_cnt;
	}	// function end
	
// =================================== 아이디 영역 end ===================================
	
// =================================== 비밀번호 영역 start ===================================
	
// 비밀번호 유효성 검사
	function pwd_chk() {
		var pwd = $('.origin_pw').val();
		// 영문 소문자,숫자,특수문자 최소 1개 이상 입력 / 8~20자 / 공백X
		var pwd_valid = /^(?=.*[a-z])(?=.*[0-9])(?=.*[\?!@#\$%\^&\*])[a-z0-9\?!@#\$%\^&\*]{8,20}$/;
		var origin_pw_cnt;
		
		if(pwd==="") {
			$(".pwd_valid_text").html("8자리~20자리 영문,숫자,특수문자를 포함해 주세요<br>허용가능 특수문자 : ?!@#$%^&*");
			$(".pwd_valid_text").css("color", "black");
			origin_pw_cnt = 0;
		}	// pwd 공란일때 if end
		else if(pwd_valid.test(pwd)!=true) {
			$(".pwd_valid_text").html("8자리~20자리 영문,숫자,특수문자를 포함해 주세요<br>허용가능 특수문자 : ?!@#$%^&*");
			$(".pwd_valid_text").css("color", "red");
			origin_pw_cnt = 0;
		}	// pwd 유효성검사 미통과 else if end
		else if(pwd_valid.test(pwd)==true) {
			$(".pwd_valid_text").html("사용가능한 비밀번호 입니다");
			$(".pwd_valid_text").css("color", "black");
			origin_pw_cnt = 1;
		}	// pwd 유효성검사 통과 else if end
		return origin_pw_cnt;
	}	// function end
	
// 비밀번호, 비밀번호 확인 값 일치여부 체크
	function pwd_match(){
		var origin_pwd = $('.origin_pw').val();
		var copy_pwd = $('.copy_pw').val();
		var copy_pw_cnt;
		
		if(copy_pwd===""){
			$('.pwd_chk_text').html("");
			copy_pw_cnt = 0;
		}	// 비밀번호 확인 공란일 경우 문구 지우기 위한 if end
		else if(origin_pwd===copy_pwd){
			$('.pwd_chk_text').html("비밀번호가 일치합니다");
			$('.pwd_chk_text').css("color", "black");
			copy_pw_cnt = 1;
		}	// 비밀번호와 비밀번호 확인이 일치할 경우 else if end
		else if(origin_pwd!==copy_pwd){
			$('.pwd_chk_text').html("비밀번호가 일치하지 않습니다");
			$('.pwd_chk_text').css("color", "red");
			copy_pw_cnt = 0;
		}	// 비밀번호와 비밀번호 확인이 불일치할 경우 else if end
		return copy_pw_cnt;
	}	// function end
	
// =================================== 비밀번호 영역 end ===================================
	
// =================================== 이메일 영역 start ===================================
	
// 이메일 유효성 검사
	function email_chk() {
		var email = $(".email").val();
		// 영문자 대,소문자랑 숫자만 입력 / 특문은 @랑 .만 / 공백X
		var email_valid = /^([a-zA-Z0-9_\.-]+)@([a-z\.-]+)\.([a-z\.]{2,6})$/;
		var email_cnt;
		
		if(email==="") {
			$(".email_chk_text").html("이메일을 입력해 주세요");
			$(".email_chk_text").css("color", "black");
			email_cnt = 0;
		}	// 이메일 공란일때 if end
		else if(email_valid.test(email)!=true) {
			$(".email_chk_text").html("이메일 형식에 맞게 입력해 주세요");
			$(".email_chk_text").css("color", "red");
			email_cnt = 0;
		}	// 이메일 유효성 검사 미통과 else if end
		else if(email_valid.test(email)==true) {
			$(".email_chk_text").html("입력완료");
			$(".email_chk_text").css("color", "black");
			email_cnt = 1;
		}	// 이메일 유효성 검사 통과 else if end
		return email_cnt;
	}
	
// =================================== 이메일 영역 end ===================================
	
// =================================== 생년월일 영역 start ===================================

// 생년월일 유효성 검사
	function birth_chk() {
		var birth = $('.birth').val();
		// 숫자만 입력 / 무조건 8자리 / - 자동입력 / 공백X
		var birth_valid = /^([0-9]{4})-?(0[1-9]|1[0-2]{2})-?(0[1-9]|1[0-9]|2[0-9]|3[0-1]{2})$/;
		
		var birth_cnt;
		
		if(birth==="") {
			$(".birth_chk_text").html("생년월일 8자리를 입력해 주세요");
			birth_cnt = 0;
		}	// 생년월일 공란일 경우 if end
		else if(birth_valid.test(birth)!=true) {
			$(".birth_chk_text").html("생년월일 8자리를 입력해 주세요");
			$(".birth_chk_text").css("color", "red");
			birth_cnt = 0;
		}	// 생년월일 유효성 미통과 else if end
		else if(birth_valid.test(birth)==true) {
			$(".birth_chk_text").html("입력완료");
			$(".birth_chk_text").css("color", "black");
			birth_cnt = 1;
		}	// 생년월일 유효성 통과 else if end
		return birth_cnt;
	}
	
// =================================== 생년월일 영역 end ===================================
	
// =================================== 핸드폰 영역 start ===================================
	
// 연락처 유효성 검사
	function hp_chk() {
		var hp = $(".hp").val();
		// 숫자만입력 / 공백X / - 자동 입력 / 차후 연락처로 인증 시도예정(변경가능성O) / 10~11자릿수 고정(3/3~4/4)
		var hp_valid = /^(01[0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
		var hp_cnt;
		
		if(hp==="") {
			$(".hp_chk_text").html("핸드폰 번호를 입력해 주세요");
			$(".hp_chk_text").css("color", "black");
			hp_cnt = 0;
		}	// 핸드폰 공란일때 if end
		else if(hp_valid.test(hp)!=true) {
			$(".hp_chk_text").html("형식에 맞게 입력해 주세요");
			$(".hp_chk_text").css("color", "red");
			hp_cnt = 0;
		}	// 핸드폰 유효성 검사 미통과시 else if end
		else if(hp_valid.test(hp)==true) {
			$(".hp_chk_text").html("입력완료");
			$(".hp_chk_text").css("color", "black");
			hp_cnt = 1;
		}	// 핸드폰 유효성 검사 통과시 else if end
		return hp_cnt;
	}
	
// =================================== 핸드폰 영역 end ===================================