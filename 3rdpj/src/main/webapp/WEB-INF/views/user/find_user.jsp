<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main class="finduser_main">
	<form name="finduser_form" method="post">
		<div class="finduser_div">		
			<!-- 아이디 찾기 -->		
			<div class="find_id_div">
				<p class="finduser_text find_id_text">아이디 찾기</p>
				<div class="findid_email_div">
					<p class="finduser_p id_email_p">이메일</p>
					<input type="text" class="finduser_input id_email" maxlength="50" />
					<i class="fa-solid fa-envelope icon"></i>
				</div>
				<div class="findid_hp_div">
					<p class="finduser_p id_hp_p">핸드폰번호</p>			
					<input type="text" class="finduser_input id_hp" maxlength='11' />
					<i class="fa-solid fa-phone icon"></i>
				</div>				
				<input type="button" class="finduser_btn find_id" value="아이디 찾기" />
				<p class="alert_text id_text"></p>
			</div>
			<!-- 비밀번호 찾기 -->
			<div class="find_pw_div">
				<p class="finduser_text find_pw_text">비밀번호 찾기</p>
				<div class="findpw_id_div">
					<p class="finduser_p pw_id_p">아이디</p>
					<input type="text" class="finduser_input pw_id" maxlength='20' />
					<i class="fa-solid fa-user icon"></i>
				</div>
				<div class="findpw_hp_div">
					<p class="finduser_p pw_hp_p">핸드폰번호</p>
					<input type="text" class="finduser_input pw_hp" maxlength='11' />
					<i class="fa-solid fa-phone icon"></i>
				</div>
				<input type="button" class="finduser_btn find_pw" value="비밀번호 찾기" />
				<p class="alert_text pw_text"></p>
			</div>		
		</div>	
	</form>
	<!-- 비밀번호 변경 모달 -->
	<section class="change_pw_section">
		<div class="form change_pw_div">
			<i class="fa-solid fa-xmark close_icon"></i>
			<form name="change_pw_form" method="post">
				<h2 class="change_pw_text">비밀번호 변경</h2>
				<div class="change_input_box origin_pw_area">
					<input type="password" maxlength='20' placeholder="새로운 비밀번호" class="change_pw_origin" oninput="pwd_chk()" />
					<i class="fa-solid fa-lock origin_pw_icon"></i>
					<i class="fa-solid fa-eye-slash origin_pw_hide"></i>
					<p class="change_pw_p origin_alert_text">8자리~20자리 영문,숫자,특수문자를 포함해 주세요<br>허용가능 특수문자 : ?!@#$%^&*</p>
				</div>
				<div class="change_input_box copy_pw_area">
					<input type="password" maxlength='20' placeholder="새로운 비밀번호 확인" class="change_pw_copy" oninput="pwd_match()" />
					<i class="fa-solid fa-lock copy_pw_icon"></i>
					<i class="fa-solid fa-eye-slash copy_pw_hide"></i>
					<p class="change_pw_p copy_alert_text"></p>
				</div>
				<p class="change_pw_p change_pw_msg"></p>
				<input type="button" class="change_pw_btn" value="비밀번호 변경하기" />
			</form>
		</div>
	</section>
</main>
	
<script src="/resources/js/common/layout.js"></script>
<script src="/resources/js/user/find_user.js"></script>


