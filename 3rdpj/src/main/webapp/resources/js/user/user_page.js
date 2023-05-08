$(document).ready(function() {	
	$.ajax({
		url : "/user/mypage",
		type : "POST",
		success : function(data) {
			$(".page_id").attr('value', data.dto.user_id);
			$(".page_birth").attr('value', data.dto.birth);
			$(".page_email").attr('value', data.dto.email);
			$(".page_hp").attr('value', data.dto.hp);
			$(".page_u_point").attr('value', data.dto.u_point);
			$(".page_create_date").attr('value', data.dto.create_date);
			$(".page_update_date").attr('value', data.dto.update_date);
		},	// success end
		error: function(xhr, status, error) {
               console.log(xhr);
               console.log(status);
               console.log(error);
		}	// error end
	});	// ajax end
});

$(".page_change_pw").on('click', function() {
	// input 창 하나 열리면서 거기에 입력되는걸로 비밀번호 변경시키기(유효성검사 적용시키고 값 넘겨서 컨트롤러에서 암호화)
});