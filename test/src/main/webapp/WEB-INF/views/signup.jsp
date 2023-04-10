<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<h1>회원가입</h1>
<form method="post" action="/signup">
	<input type="text" name="user_id" placeholder="아이디">
	<input type="password" name="pw" placeholder="비밀번호" autocomplete="off">
	<input type="text" name="birth" placeholder="생년월일">
	<input type="text" name="email" placeholder="이메일">
	<input type="text" name="hp" placeholder="휴대폰">
	<input type="submit" value="회원가입">
</form>
</body>
</html>