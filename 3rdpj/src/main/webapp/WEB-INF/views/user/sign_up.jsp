<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main class="signup_main">
	<!-- 이용약관 -->
	<div class="accept_menu">
		<div class="menu_h2"><h2>약관동의</h2></div>
		<div class="accept_menu_tab">
			<p class="accept_tab accecpt_1_p active">목적 및 약관동의</p>
			<p class="accept_tab accecpt_2_p">서비스 제공 및 회원관리</p>
			<p class="accept_tab accecpt_3_p">구매, 계약 및 지급서비스</p>
			<p class="accept_tab accecpt_4_p">개인정보 보호 및 법정의무</p>
			<p class="accept_tab pravacy_p">개인정보 처리방침</p>
		</div>
	</div>
	<section class="accept_section">
		<div class="accept_box">
			<div class="accept_div accept1_div">
				<c:forEach var="accept1" items="${accept}" begin="0" end="2">
					<c:out value="${accept1.accept_detail}"/>
				</c:forEach>
			</div>
			<div class="accept_div accept2_div">
				<c:forEach var="accept2" items="${accept}" begin="3" end="7">
					<c:out value="${accept2.accept_detail}"/>
				</c:forEach>
			</div>
			<div class="accept_div accept3_div">
				<c:forEach var="accept3" items="${accept}" begin="8" end="15">
					<c:out value="${accept3.accept_detail}"/>
				</c:forEach>
			</div>
			<div class="accept_div accept4_div">
				<c:forEach var="accept4" items="${accept}" begin="16" end="23">
					<c:out value="${accept4.accept_detail}"/>
				</c:forEach>
			</div>
			<div class="accept_div privacy_div">
				<c:forEach var="privacy" items="${privacy}" begin="0" end="14">
					<c:out value="${privacy.privacy_detail}"/>
				</c:forEach>
			</div>
		</div>	
	</section>
	<!-- 회원가입 -->
	<section class="signup_section">
		<div class="signup_box">
			<h2>개인정보 입력</h2>
			<form name="signup_form" method="post">
				<!-- 아이디 -->
				<div class="input_box id_area">
					<p class="p_text id_p_text">아이디</p>
					<input type="text" name="user_id" class="sign_input user_id" maxlength='20' oninput="id_chk()" />
					<i class="fa-solid fa-user icon"></i>
					<p class="chk_text id_chk_text">6자리~20자리 영문,숫자를 포함해 주세요</p>
				</div>
				<!-- 비밀번호 -->
				<div class="input_box origin_pw_area">
					<p class="p_text origin_pw_p_text">비밀번호</p>
					<input type="password" name="pw" class="sign_input origin_pw" maxlength='20' oninput="pwd_chk()" />
					<i class="fa-solid fa-lock icon"></i>
					<i class="fa-solid fa-eye-slash origin_pw_hide"></i>
					<p class="chk_text pwd_valid_text">8자리~20자리 영문,숫자,특수문자를 포함해 주세요<br>허용가능 특수문자 : ?!@#$%^&*</p>
				</div>
				<!-- 비밀번호 확인 -->
				<div class="input_box copy_pw_area">
					<p class="p_text copy_pw_p_text">비밀번호 확인</p>
					<input type="password" name="pw_chk" class="sign_input copy_pw" maxlength='20' oninput="pwd_match()" />
					<i class="fa-solid fa-lock icon"></i>
					<i class="fa-solid fa-eye-slash copy_pw_hide"></i>
					<p class="chk_text pwd_chk_text"></p>
				</div>
				<!-- 이메일 -->
				<div class="input_box email_area">
					<p class="p_text email_p_text">이메일</p>
					<input type="email" name="email" class="sign_input email" maxlength="50" oninput="email_chk()" />
					<i class="fa-solid fa-envelope icon"></i>
					<p class="chk_text email_chk_text"></p>
				</div>
				<!-- 생년월일 -->
				<div class="input_box birth_area">
					<p class="p_text birth_p_text">생년월일</p>
					<input type="text" name="birth" class="sign_input birth" maxlength='10' oninput="birth_chk()" />
					<i class="fa-solid fa-user icon"></i>
					<p class="chk_text birth_chk_text">생년월일 8자리로 입력해 주세요</p>
				</div>
				<!-- 핸드폰번호 -->
				<div class="input_box hp_area">
					<p class="p_text hp_p_text">핸드폰번호</p>
					<i class="fa-solid fa-phone icon"></i>
					<input type="text" name="hp" class="sign_input hp" maxlength='11' oninput="hp_chk()" />
					<p class="chk_text hp_chk_text"></p>
					<!-- 
					<input type="button" name="certi_btn" class="sign_input certi_btn" value="인증번호 발송" onclick="certi_chk()"/>
					<p class="p_text certi_text">인증번호 입력</p>
					<input type="text" name="certi_num" class="sign_input certi_num" />
					<p class="chk_text certi_chk_text"></p>
					 -->
				</div>
				<!-- 버튼 -->
				<div class="input_box btn_area">
					<input type="button" name="sign_up_btn" class="sign_up_btn" value="회원가입" />
					<p class="chk_text signup_chk_text"></p>
				</div>
			</form>
		</div>
	</section>
</main>
	
<script src="/resources/js/user/sign_up.js"></script>
<script src="/resources/js/common/layout.js"></script>
