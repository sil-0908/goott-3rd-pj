<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main class="user_page_main">
	<h2>사용자님의 마이페이지</h2>
	<form name="user_page_form" method="post">
		<div class="profile_img_div"></div>
		<div class="info_div">
			<p>아이디</p>
			<input type="text" class="id" value="${user_info.id}" readonly />
			<p>비밀번호 변경하기</p>
			<p>이메일</p>
			<input type="text" class="email" value="${user_info.email}" />
			<p>생년월일</p>
			<input type="text" class="birth" value="${user_info.birth}" />
			<p>핸드폰번호</p>
			<input type="text" class="hp" value="${user_info.hp}" />
			<p>현재 보유 포인트</p>
			<input type="text" class="u_point" value="${user_info.u_point}" readonly />
			<p>회원 가입 일자</p>
			<input type="text" class="create_date" value="${user_info.create_date}" readonly />
			<p>마지막 수정 일자</p>
			<input type="text" class="update_date" value="${user_info.update_date}" readonly />
		</div>
	</form>
</main>

<script src="/resources/js/common/layout.js"></script>
