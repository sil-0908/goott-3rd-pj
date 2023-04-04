<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<title>회원가입</title>
</head>
<body>
	<form name="signup" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="user_id" id="user_id" oninput="id_chk()"></td>
				<td id="id_chk_text"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw" id="pw"></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="text" name="pw_chk" id="pw_chk" oninput="pwd_chk()"></td>
				<td id="pwd_chk_text"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" id="email"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth" id="birth"></td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td>
				<input type="text" name="hp" id="hp">
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="sign_up_btn" id="sign_up_btn" value="가입하기"></td>
			</tr>
		</table>
	</form>
	
<script src="/resources/js/user/sign_up.js"></script>
</body>
</html>