<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main>
	<div class="signup_box">
		<form name="signup_form" method="post">
			<h2>회원가입</h2>
			<div class="input_box id_area">
				<p>아이디</p>
				<input type="text" name="user_id" id="user_id" maxlength='20' oninput="id_chk()">
				<i class="fa-solid fa-user id_icon"></i>
				<p class="chk_text id_chk_text">6자리~20자리 영문,숫자를 포함해 주세요</p>
			</div>
			<div class="input_box origin_pw_area">
				<p>비밀번호</p>
				<input type="text" name="pw" id="pw" maxlength='20' oninput="pwd_chk()">
				<i class="fa-solid fa-lock origin_pw_icon"></i>
				<p class="chk_text pwd_valid_text">8자리~20자리 영문,숫자,특수문자를 포함해 주세요<br>허용가능 특수문자 : ?!@#$%^&*</p>
			</div>
			<div class="input_box copy_pw_area">
				<p>비밀번호 확인</p>
				<input type="text" name="pw_chk" id="pw_chk" maxlength='20' oninput="pwd_match()">
				<i class="fa-solid fa-lock copy_pw_icon"></i>
				<p class="chk_text pwd_chk_text"></p>
			</div>
			<div class="input_box email_area">
				<p>이메일</p>
				<input type="email" name="email" id="email" oninput="email_chk()">
				<p class="chk_text email_chk_text"></p>
			</div>
			<div class="input_box birth_area">
				<p>생년월일</p>
				<input type="text" name="birth" id="birth" maxlength='10' oninput="birth_chk()">
				<p class="chk_text birth_chk_text">8자리로 입력해 주세요</p>
			</div>
			<div class="input_box hp_area">
				<p>핸드폰번호</p>
				<input type="text" name="hp" id="hp" maxlength='11' oninput="hp_chk()">
				<p class="chk_text hp_chk_text"></p>
			</div>
		</form>
	</div>
</main>
	
<script src="/resources/js/user/sign_up.js"></script>
<script src="/resources/js/common/layout.js"></script>
