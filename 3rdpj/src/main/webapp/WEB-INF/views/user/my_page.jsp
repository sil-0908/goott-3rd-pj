<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<title>회원가입</title>
</head>
<body>
	<c:if test="${sessionScope.user_id == null}">
		<input type="button" id="sign_in" value="로그인">
		<input type="button" id="sign_up" value="회원가입">
	</c:if>
	<c:if test="${sessionScope.user_id != null}">
		<input type="button" id="sign_out" value="로그아웃">
		<input type="text" value="${sessionScope.user_id}">
		<input type="text" value="${sessionScope.auth}">
	</c:if>

<script src="/resources/js/user/my_page.js"></script>
</body>
</html>