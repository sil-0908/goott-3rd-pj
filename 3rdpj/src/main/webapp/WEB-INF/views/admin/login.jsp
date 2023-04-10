<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<title>로그인</title>
</head>
<body>
	<form name="login" method="post">
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
				<td id="login_chk"></td>
				<td><input type="button" id="login" value="로그인"></td>
				<td><input type="button" id="main" value="홈으로"></td>
			</tr>
		</table>
	</form>	
	
</body>
</html>