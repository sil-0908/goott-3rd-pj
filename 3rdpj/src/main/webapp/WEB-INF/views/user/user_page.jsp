<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main class="user_page_main">
	<h2>사용자님의 마이페이지</h2>
	<div class="profile_img_div">
		
	</div>
	<div class="info_div">
		<p>아이디</p>
		<input type="text" class="id" value="${user_info_dto.id}" />
		<p>비밀번호 변경하기</p>
		<p>이메일</p>
		<input type="text" class="id" value="${user_info_dto.email}" />
		<p>생년월일</p>
		<input type="text" class="id" value="${info.birth}" />
		<p>핸드폰번호</p>
		<input type="text" class="id" value="${info.hp}" />
		<p>현재 보유 포인트</p>
		<input type="text" class="id" value="${info.u_point}" />
		<p>회원 가입 일자</p>
		<input type="text" class="id" value="${info.create_date}" />
		<p>마지막 수정 일자</p>
		<input type="text" class="id" value="${info.update_date}" />
	</div>
	
</main>

<script src="/resources/js/common/layout.js"></script>
<script src="/resources/js/user/user_page.js"></script>