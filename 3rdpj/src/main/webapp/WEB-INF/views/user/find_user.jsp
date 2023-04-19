<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<title>아이디, 비밀번호 찾기</title>
</head>
<body>
	<form name="find_id" method="post">
		<p>아이디 찾기</p>
		<input type="text" id="email">
		<input type="text" id="hp">
		<input type="submit" id="find_id" value="아이디 찾기">
	</form>
	<form name="find_pw" method="post">
		<p>비밀번호 찾기</p>
		<input type="text" id="id">
		<input type="text" id="hp">
		<input type="submit" id="find_pw" value="비밀번호 찾기">
	</form>
	
<script src="/resources/js/user/find_user.js"></script>
</body>
</html>