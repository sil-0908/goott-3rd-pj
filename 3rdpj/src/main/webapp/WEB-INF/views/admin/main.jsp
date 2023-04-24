<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin_main</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<%-- 	<c:if test="${sessionScope.auth =='auth_a'}">--%>
	<div>
		<a href="userlist">회원관리</a>
		<a href="logout">로그아웃</a>
		<a href="qnalist">질문게시판</a>
		<a href="reviewlist">리뷰관리</a>
	</div>
<%-- 	</c:if>--%>

</body>
</html>