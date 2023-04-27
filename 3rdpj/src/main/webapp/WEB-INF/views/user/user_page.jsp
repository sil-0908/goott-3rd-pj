<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main class="user_page_main">
	<h2>사용자님의 마이페이지</h2>
	<div class="profile_img_div">
		
	</div>
	<div class="info_div">
		<form name="user_info_form" method="post">
			<p>아이디</p>
			<input type="text" class="">
			<p>비밀번호</p>
			<p>이메일</p>
			<p>생년월일</p>
			<p>핸드폰번호</p>
			<p>현재 보유 포인트</p>
			<p>회원 가입 일자</p>
			<p>마지막 수정 일자</p>
		</form>
	</div>
	
</main>

<script src="/resources/js/common/layout.js"></script>
<script src="/resources/js/user/user_page.js"></script>