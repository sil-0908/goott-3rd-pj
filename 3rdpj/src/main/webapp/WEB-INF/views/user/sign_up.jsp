<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main class="signup_main">
	<div class="signup_box">
		<form name="signup_form" method="post">
			<h2 class="signup_text">회원가입</h2>
			<div class="input_box id_area">
				<p>아이디</p>
				<input type="text" name="user_id" class="sign_input user_id" maxlength='20' oninput="id_chk()">
				<i class="fa-solid fa-user icon"></i>
				<p class="chk_text id_chk_text">6자리~20자리 영문,숫자를 포함해 주세요</p>
			</div>
			<div class="input_box origin_pw_area">
				<p>비밀번호</p>
				<input type="text" name="pw" class="sign_input pw" maxlength='20' oninput="pwd_chk()">
				<i class="fa-solid fa-lock  icon"></i>
				<p class="chk_text pwd_valid_text">8자리~20자리 영문,숫자,특수문자를 포함해 주세요<br>허용가능 특수문자 : ?!@#$%^&*</p>
			</div>
			<div class="input_box copy_pw_area">
				<p>비밀번호 확인</p>
				<input type="text" name="pw_chk" class="sign_input pw_chk" maxlength='20' oninput="pwd_match()">
				<i class="fa-solid fa-lock icon"></i>
				<p class="chk_text pwd_chk_text"></p>
			</div>
			<div class="input_box email_area">
				<p>이메일</p>
				<input type="email" name="email" class="sign_input email" oninput="email_chk()">
				<i class="fa-solid fa-envelope icon"></i>
				<p class="chk_text email_chk_text"></p>
			</div>
			<div class="input_box birth_area">
				<p>생년월일</p>
				<input type="text" name="birth" class="sign_input birth" maxlength='10' oninput="birth_chk()">
				<i class="fa-solid fa-user icon"></i>
				<p class="chk_text birth_chk_text">8자리로 입력해 주세요</p>
			</div>
			<div class="input_box hp_area">
				<p>핸드폰번호</p>
				<input type="text" name="hp" class="sign_input hp" maxlength='11' oninput="hp_chk()">
				<i class="fa-solid fa-phone icon"></i>
				<p class="chk_text hp_chk_text"></p>
			</div>
			<div class="input_box btn_area">
				<input type="button" name="sign_up_btn" class="sign_up_btn" value="회원가입">
				<p class="chk_text signup_chk_text"></p>
			</div>
		</form>
	</div>
	<div class="signup_accept">
		
	</div>
</main>
	
<script src="/resources/js/user/sign_up.js"></script>
<script src="/resources/js/common/layout.js"></script>
