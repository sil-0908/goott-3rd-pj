<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<title>로그인</title>
</head>
<body>

	<form name="signin" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="user_id" id="user_id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw" id="pw"></td>
			</tr>
			<tr>
				<td id="signin_chk_text"></td>
				<td><input type="button" id="sign_up" value="회원가입"></td>
				<td><input type="button" id="sign_in" value="로그인"></td>
				<td><input type="button" id="main" value="홈으로"></td>
			</tr>
		</table>
	</form>
	<p id="signin_msg"></p>

<script src="/resources/js/user/sign_in.js"></script>
</body>
</html>