$(document).ready(function() {
	$.ajax({
		url : "/user/userpage",
		type : "POST",
		success : function(data) {
			console.log(data.user_dto.user_id);
//			if(data.msg==="success") {
//				location.href = data.view;
//			}
//			else if(data.msg==="user_del_y") {
//				$(".signin_msg").html("탈퇴한 사용자 입니다. 탈퇴 취소는 고객센터로 문의 바랍니다.");
//				$(".signin_msg").css("color", "red");
//			}
//			else if(data.msg==="not_user") {
//				$(".signin_msg").html("로그인 실패. 다시 확인해주세요");
//				$(".signin_msg").css("color", "red");
//			}
		},	// success end
		error: function(xhr, status, error) {
               console.log(xhr);
               console.log(status);
               console.log(error);
		}	// error end
	});	// ajax end
});