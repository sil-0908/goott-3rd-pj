<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main>
	 <h1>mypage</h1>
	 <c:if test="${sessionScope.user_id != null}">
		<input type="text" value="${sessionScope.user_id}" />
		<input type="text" value="${sessionScope.auth}" />
		<input type="button" class="go_user_page" value="마이페이지" />
	</c:if>
	<h1>내가 구매한 플랜</h1>
</main>

<script src="/resources/js/common/layout.js"></script>
<script src="/resources/js/user/my_page.js"></script>