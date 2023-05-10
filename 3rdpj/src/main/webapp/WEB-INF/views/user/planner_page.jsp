<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main class="planner_page_main">
	<div class="tab_area_div">
		<h2>마이페이지</h2>
		<input type="hidden" class="session_id" value="${sessionScope.user_id}" />
		<div class="profile_img_div"></div>
		<p class="page_text id_text"></p>
		<input type="text" class="page_input page_id" readonly />
			<p class="menu_tab planner_info_text">플래너 정보</p>
			<p class="menu_tab privacy_text">개인 정보</p>
	</div>
	<!-- 본인 이외에도 보여줄 영역 -->
	<section class="planner_info_section">
		<div class="planner_info_div">
			<form name="planner_info_form" class="planner_info_form" method="post">
				<div class="input_div birth_div">
					<p class="page_text birth_text">생년월일</p>
					<input type="text" class="page_input page_birth" readonly />
				</div>
				<div class="input_div email_div">
					<p class="page_text email_text">이메일</p>
					<input type="text" class="page_input page_email" readonly />
				</div>
				<div class="input_div emp_hp_div">
					<p class="page_text emp_hp_text">사업용 연락처</p>
					<input type="text" class="page_input page_emp_hp" readonly />
				</div>
				<div class="input_div success_cnt_div">
					<p class="page_text success_cnt_text">성공횟수</p>
					<input type="text" class="page_input page_success_cnt" readonly />
				</div>
				<div class="input_div update_date_div">
					<p class="page_text update_date_text">마지막 수정 일자</p>
					<input type="text" class="page_input page_update_date" readonly />
				</div>
				<div class="input_div planner_score_div">
					<p class="page_text planner_score_text">플래너 점수</p>
					<input type="text" class="page_input page_planner_score" readonly />
				</div>
				<div class="input_div intro_div">
					<p class="page_text intro_text">자기소개</p>
					<input type="text" class="page_input page_intro" readonly />
				</div>
				<div class="btn_div">
					<input type="button" class="page_btn planner_info_edit" value="플래너 정보 수정하기" />
					<input type="button" class="page_btn write_review" value="이 플래너에게 리뷰달기" />
				</div>
			</form>
		</div>
	</section>
	<!-- 플래너 본인만 볼 영역 -->
	<section class="privacy_info_section">
		<div class="privacy_info_div">
			<form name="privacy_info_form" class="privacy_info_form" method="post">
				<div class="input_div hp_div">
					<p class="page_text hp_text">개인 연락처</p>
					<input type="text" class="page_input page_hp" readonly />
				</div>
				<div class="input_div point_div">
					<p class="page_text point_text">현재 보유 포인트</p>
					<input type="text" class="page_input page_u_point" readonly />
				</div>
				<div class="input_div emp_num_div">
					<p class="page_text emp_num_text">사업자번호</p>
					<input type="text" class="page_input page_emp_num" readonly />
				</div>
				<div class="input_div create_date_div">
					<p class="page_text create_date_text">회원 가입 일자</p>
					<input type="text" class="page_input page_create_date" readonly />
				</div>
				<div class="btn_div">
					<input type="button" class="page_btn my_info_edit" value="개인 정보 수정하기" />
					<input type="button" class="page_btn change_pw" value="비밀번호 변경하기" />
					<div class="change_pw_area"></div>
				</div>
			</form>
		</div>
	</section>
</main>

<script src="/resources/js/user/planner_page.js"></script>
<script src="/resources/js/common/layout.js"></script>