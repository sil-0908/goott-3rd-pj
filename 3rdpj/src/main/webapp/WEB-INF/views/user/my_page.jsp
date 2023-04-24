<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main>
	<!-- 
	<c:if test="${sessionScope.user_id == null}">
		<input type="button" id="sign_in" value="로그인">
		<input type="button" id="sign_up" value="회원가입">
		<input type="button" id="find_user" value="아이디/비밀번호 찾기">
	</c:if>
	
	 -->
	 <h1>mypage</h1>
	 <c:if test="${sessionScope.user_id != null}">
		<input type="text" value="${sessionScope.user_id}">
		<input type="text" value="${sessionScope.auth}">
	</c:if>
</main>

<script src="/resources/js/user/my_page.js"></script>
<script src="/resources/js/common/layout.js"></script>