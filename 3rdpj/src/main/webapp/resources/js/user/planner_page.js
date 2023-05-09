$(document).ready(function() {
	$.ajax({
		url : "/user/mypage",
		type : "POST",
		success : function(data) {
			console.log(data.dto.intro);
			$(".page_id").attr('value', data.dto.user_id);
			$(".page_birth").attr('value', data.dto.birth);
			$(".page_email").attr('value', data.dto.email);
			$(".page_hp").attr('value', data.dto.hp);
			$(".page_emp_hp").attr('value', data.dto.hp_emp);
			if(data.dto.intro===null) {
				$(".page_intro").attr('value', "아직 입력된 자기소개가 없습니다");
			}
			else {
				$(".page_intro").attr('value', data.dto.intro);
			}
			$(".page_u_point").attr('value', data.dto.u_point);
			$(".page_emp_num").attr('value', data.dto.emp_num);
			$(".page_success_cnt").attr('value', data.dto.success_count);
			$(".page_create_date").attr('value', data.dto.create_date);
			$(".page_update_date").attr('value', data.dto.update_date);
			$(".page_planner_score").attr('value', data.dto.planner_score);
			if($(".page_id").val()!=$(".session_id").val()) {
				$(".privacy_text").css("display", "none");
			}
			else {
				$(".privacy_text").css("display", "block");
			}
		},	// success end
		error: function(xhr, status, error) {
               console.log(xhr);
               console.log(status);
               console.log(error);
		}	// error end
	});	// ajax end
});

//좌측 탭마다 표시될 화면변경
$(".planner_info_text").on('click', function() {
	$(".privacy_info_section").removeClass("show");
	$(".privacy_text").removeClass("active");
	$(".planner_info_section").removeClass("none");
	$(".planner_info_section").addClass("show");
	$(".planner_info_text").addClass("active");
});

$(".privacy_text").on('click', function() {
	$(".planner_info_section").removeClass("show");
	$(".planner_info_section").addClass("none");
	$(".planner_info_text").removeClass("active");
	$(".privacy_info_section").addClass("show");
	$(".privacy_text").addClass("active");
});