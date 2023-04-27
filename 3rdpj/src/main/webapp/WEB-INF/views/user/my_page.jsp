<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main>
	 <h1>mypage</h1>
	 <c:if test="${sessionScope.user_id != null}">
		<input type="text" value="${sessionScope.user_id}">
		<input type="text" value="${sessionScope.auth}">
	</c:if>
</main>

<script src="/resources/js/common/layout.js"></script>
<script src="/resources/js/user/my_page.js"></script>