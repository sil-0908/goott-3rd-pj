<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				<td><input type="text" name="user_id" id="user_id" maxlength='20' oninput="id_chk()"></td>
				<td id="id_chk_text">6자리~20자리 영문,숫자를 포함해 주세요</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw" id="pw" maxlength='20' oninput="pwd_chk()"></td>
				<td id="pwd_valid_text">8자리~20자리 영문,숫자,특수문자를 포함해 주세요<br>
				허용가능 특수문자 : ?!@#$%^&*</td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="text" name="pw_chk" id="pw_chk" maxlength='20' oninput="pwd_match()"></td>
				<td id="pwd_chk_text"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" id="email" oninput="email_chk()"></td>
				<td id="email_chk_text">이메일을 입력해 주세요</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth" id="birth" maxlength='10' oninput="birth_chk()"></td>
				<td id="birth_chk_text">생년월일 8자리를 입력해 주세요</td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td><input type="text" name="hp" id="hp" maxlength='11' oninput="hp_chk()"></td>
				<td id="hp_chk_text">핸드폰 번호를 입력해 주세요</td>
			</tr>
			<tr>
				<td><input type="button" name="sign_up_btn" id="sign_up_btn" value="가입하기"></td>
			</tr>
			<!--  disabled="true" -->
		</table>
	</form>
	
<script src="/resources/js/user/sign_up.js"></script>
</body>
</html>