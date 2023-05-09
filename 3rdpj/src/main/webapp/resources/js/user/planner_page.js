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
			$(".page_emphp").attr('value', data.dto.hp_emp);
			if(data.dto.intro===null) {
				$(".page_intro").attr('value', "아직 입력된 자기소개가 없습니다");
			}
			else {
				$(".page_intro").attr('value', data.dto.intro);
			}
			$(".page_u_point").attr('value', data.dto.u_point);
			$(".page_empnum").attr('value', data.dto.emp_num);
			$(".page_success_cnt").attr('value', data.dto.success_count);
			$(".page_create_date").attr('value', data.dto.create_date);
			$(".page_update_date").attr('value', data.dto.update_date);
			$(".page_planner_score").attr('value', data.dto.planner_score);
		},	// success end
		error: function(xhr, status, error) {
               console.log(xhr);
               console.log(status);
               console.log(error);
		}	// error end
	});	// ajax end
});