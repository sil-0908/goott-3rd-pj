// 아이디 실시간 중복체크
	function id_chk(){
		var id = $('#user_id').val();
		
		$.ajax({
			data : { id : id },
			url : "/user/id_chk/",
			type : 'POST',
			success : function(cnt){
				if(id==="") {
					$('#id_chk_text').html(" ");
				}	// 아이디 공란일 경우 문구 지우기 위한 if end
				else if(cnt===0){
					$('#id_chk_text').html("사용 가능한 아이디 입니다");
					$('#id_chk_text').css("color", "black");
				}	// 아이디 중복 없을경우 else if end
				else if(cnt===1){
					$('#id_chk_text').html("이미 사용중인 아이디 입니다");
					$('#id_chk_text').css("color", "red");
				}	// 아이디 중복일 경우 else if end
			}
		});
	};
	
// 비밀번호, 비밀번호 확인 값 일치여부 실시간 체크
	function pwd_chk(){
		var origin_pwd = $('#pw').val();
		var copy_pwd = $('#pw_chk').val();
		
		if(copy_pwd==""){
			$('#pwd_chk_text').html("");
		}	// 비밀번호 확인 공란일 경우 문구 지우기 위한 if end
		else if(origin_pwd==copy_pwd){
			$('#pwd_chk_text').html("비밀번호가 일치합니다");
			$('#pwd_chk_text').css("color", "black");
		}	// 비밀번호와 비밀번호 확인이 일치할 경우 else if end
		else if(origin_pwd!=copy_pwd){
			$('#pwd_chk_text').html("비밀번호가 일치하지 않습니다");
			$('#pwd_chk_text').css("color", "red");
		}	// 비밀번호와 비밀번호 확인이 불일치할 경우 else if end
	}

// 회원가입 (엔터키로 회원가입 진행하기는 가장 마지막에 추가예정, 그전까진 엔터키 이벤트 막아놓음)
	$("#sign_up_btn").on('click', function(e){
		document.signup.action="/user/signup";
		document.signup.submit();
	});
	
//	엔터키 입력방지 걸기(키코드 : 13, 108)
	document.addEventListener('keydown', function(e){
		if(e.keyCode === 13 || e.keyCode === 108) {
			e.preventDefault();
		}
	});