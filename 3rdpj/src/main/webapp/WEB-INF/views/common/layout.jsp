<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
	<link rel="stylesheet" href="/resources/css/common/style.css"/>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<!-- navbar start -->
	<header class="header">
	  <div class="header__logo">
        <div class="logo">
          <a href="./user/mypage" class="logo__link">
            <img src="/resources/img/logo_suntour_purple.png" alt="" />
          </a>
        </div>
      </div>
      <nav class="header__nav">
        <ul class="nav">
          <li class="nav__item">플랜</li>
          <li class="nav__item">플래너</li>
          <li class="nav__item">카테고리</li>
          <c:if test="${sessionScope.user_id == null}">
            <li class="nav__item sign_in">로그인</li>
		  </c:if>
		  <c:if test="${sessionScope.user_id != null}">
		    <li class="nav__item sign_out">로그아웃</li>
		  </c:if>
        </ul>
      </nav>
    </header>
    <!-- navbar end -->
    <!-- footer start -->
    <footer class="footer">
      <section class="footer__con">
        <div class="footer__icon">
          <i class="fa-brands fa-instagram"></i>
          <i class="fa-brands fa-facebook"></i>
          <i class="fa-brands fa-twitter"></i>
          <i class="fa-brands fa-linkedin"></i>
        </div>
        <div class="footer__copy">
          <p>Copyright&copy;SunTour 2023</p>
        </div>
      </section>
    </footer>
    <!-- footer end -->
    <!-- signin modal start - 장민실 -->
    
    	<section class="signin_section">
			<div class="form login_form">
				<i class="fa-solid fa-xmark close_icon"></i>
				<form name="signin" method="post">
					<h2>로그인</h2>
					<div class="input_box id_input">
						<input type="text" placeholder="아이디를 입력해 주세요" maxlength='20' class="id" required />
						<i class="fa-solid fa-user id_icon"></i>
						<p class="id_chk_text"></p>
					</div>
					<div class="input_box pw_input">
						<input type="password" placeholder="비밀번호를 입력해 주세요" maxlength='20' class="pw" required />
						<i class="fa-solid fa-lock pw_icon"></i>
						<i class="fa-solid fa-eye-slash pw_hide"></i>
						<p class="pw_chk_text"></p>
					</div>
					<p class="forgot_info">아이디/비밀번호 찾기</p>
					<p class="signin_msg"></p>
					<input type="button" class="signin_btn" value="로그인">					
					<div class="signup_text">아직 회원이 아니신가요?<span class="sign_up">회원가입</span></div>
				</form>
			</div>
    	</section>
    
    <!-- signin modal end -->
    
    <!-- 
    <main class="signin_modal"></main>
     -->
    <script src="/resources/js/user/sign_in.js"></script>
    
</body>