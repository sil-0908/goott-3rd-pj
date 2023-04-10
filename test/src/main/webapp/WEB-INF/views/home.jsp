<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<h1>메인화면ㅋㅋ</h1>
<h1>세션아이디 : ${sessionScope.id}</h1>
<h1>권한 : ${sessionScope.auth}</h1>
<form action="/planner" method="post">
	<input type="hidden" name="user_id" value="${sessionScope.id}">
	<input type="submit" value="플래너등록">
</form>
</body>
</html>