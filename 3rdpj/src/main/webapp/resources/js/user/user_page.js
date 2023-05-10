$(document).ready(function() {
	var id = $(".session_id").val();
	$.ajax({		
		url : "/user/user_page",
		type : "POST",
		data : { "id" : id },
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

$(".change_pw").on('click', function() {
	$(".newpw_modal_section").load("/user/go_newpw_modal");
	$(".change_pw_section").addClass("show");
});

// 좌측 탭마다 표시될 화면변경
$(".privacy_text").on('click', function() {
	$(".paylist_section").removeClass("show");
	$(".pay_list_text").removeClass("active");
	$(".info_section").removeClass("none");
	$(".info_section").addClass("show");
	$(".privacy_text").addClass("active");
});

$(".pay_list_text").on('click', function() {
	$(".info_section").removeClass("show");
	$(".info_section").addClass("none");
	$(".privacy_text").removeClass("active");
	$(".paylist_section").addClass("show");
	$(".pay_list_text").addClass("active");
});

