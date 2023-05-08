<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main class="user_page_main">	
	<div class="tab_area_div">
		<h2>마이페이지</h2>
		<div class="profile_img_div"></div>
		<input type="text" class="page_id" readonly />
		<p>개인정보</p>
		<p>결제내역</p>
	</div>
	<div class="info_div">
		<form name="user_page_form" method="post">				
			<input type="button" class="page_change_pw" value="비밀번호 변경하기" />
			<p>생년월일</p>
			<input type="text" class="page_birth" readonly />
			<p>이메일</p>
			<input type="text" class="page_email" readonly />
			<p>연락처</p>
			<input type="text" class="page_hp" readonly />
			<p>현재 보유 포인트</p>
			<input type="text" class="page_u_point" readonly />
			<p>회원 가입 일자</p>
			<input type="text" class="page_create_date" readonly />
			<p>마지막 수정 일자</p>
			<input type="text" class="page_update_date" readonly />		
		</form>
	</div>
	<div class="payment_list_div">
		결제내역ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
	</div>
</main>

<script src="/resources/js/user/user_page.js"></script>
<script src="/resources/js/common/layout.js"></script>
