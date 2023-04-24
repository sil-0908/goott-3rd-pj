<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main>
	<p>아이디 찾기</p>
	<input type="text" class="id_email" placeholder="이메일">
	<input type="text" class="id_hp" placeholder="핸드폰번호">
	<input type="button" class="find_id" value="아이디 찾기">
	<p class="id_text" />
	<p>비밀번호 찾기</p>
	<input type="text" class="pw_id" placeholder="아이디">
	<input type="text" class="pw_hp" placeholder="핸드폰번호">
	<input type="submit" class="find_pw" value="비밀번호 찾기">
	<p class="pw_text" />
</main>
	
<script src="/resources/js/common/layout.js"></script>
<script src="/resources/js/user/find_user.js"></script>

