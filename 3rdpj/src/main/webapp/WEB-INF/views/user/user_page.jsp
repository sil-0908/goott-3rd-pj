<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main class="user_page_main">
	<div class="tab_area_div">
		<h2>마이페이지</h2>
		<input type="hidden" class="session_id" value="${sessionScope.user_id}" />
		<div class="profile_img_div"></div>
		<p class="page_text id_text"></p>
		<input type="text" class="page_input page_id" readonly />
		<p class="menu_tab privacy_text">개인 정보</p>
		<p class="menu_tab pay_list_text">결제 내역</p>
	</div>
	<section class="info_section">
		<div class="info_div">
			<form name="user_page_form" class="user_page_form" method="post">
				<div class="input_div birth_div">
					<p class="page_text birth_text">생년월일</p>
					<input type="text" class="page_input page_birth" readonly />
				</div>
				<div class="input_div email_div">
					<p class="page_text email_text">이메일</p>
					<input type="text" class="page_input page_email" readonly />
				</div>
				<div class="input_div hp_div">
					<p class="page_text hp_text">연락처</p>
					<input type="text" class="page_input page_hp" readonly />
				</div>
				<div class="input_div point_div">
					<p class="page_text point_text">현재 보유 포인트</p>
					<input type="text" class="page_input page_u_point" readonly />
				</div>
				<div class="input_div create_date_div">
					<p class="page_text create_date_text">회원 가입 일자</p>
					<input type="text" class="page_input page_create_date" readonly />
				</div>
				<div class="input_div update_date_div">
					<p class="page_text update_date_text">마지막 수정 일자</p>
					<input type="text" class="page_input page_update_date" readonly />
				</div>
				<div class="btn_div">
					<input type="button" class="page_btn edit_info" value="정보 수정하기" />
					<input type="button" class="page_btn change_pw" value="비밀번호 변경하기" />
				</div>
			</form>
		</div>
	</section>
	<section class="paylist_section">
		<div class="paylist_div">
			결제내역ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
		</div>
	</section>
</main>

<script src="/resources/js/user/user_page.js"></script>
<script src="/resources/js/common/layout.js"></script>