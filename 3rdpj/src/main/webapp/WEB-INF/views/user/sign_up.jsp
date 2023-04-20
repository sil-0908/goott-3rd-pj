<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main>
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
				<td><input type="button" name="sign_up_btn" id="sign_up_btn"  value="가입하기"></td>
				<td id="chk_text"></td>
			</tr>
		</table>
	</form>
</main>
	
<script src="/resources/js/user/sign_up.js"></script>
<script src="/resources/js/common/layout.js"></script>
