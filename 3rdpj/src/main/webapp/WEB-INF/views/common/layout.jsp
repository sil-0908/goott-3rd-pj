<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
	<link rel="stylesheet" href="/resources/css/style.css"/>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<!-- navbar -->
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
    
    <!-- footer -->
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
    
    <!-- signin modal - 장민실-->
    <section class="signin_section">
		<div class="form login_div">
			<i class="fa-solid fa-xmark close_icon"></i>
			<form name="signin" method="post">
				<h2 class="login_text">로그인</h2>
				<div class="signin_input_box id_area">
					<input type="text" placeholder="아이디" maxlength='20' class="id" required />
					<i class="fa-solid fa-user id_icon"></i>
					<p class="signin_text id_alert_text"></p>
				</div>
				<div class="signin_input_box pw_area">
					<input type="password" placeholder="비밀번호" maxlength='20' class="pw" required />
					<i class="fa-solid fa-lock pw_icon"></i>
					<i class="fa-solid fa-eye-slash pw_hide"></i>
					<p class="signin_text pw_alert_text"></p>
				</div>
				<p class="signin_text signin_msg"></p>
				<input type="button" class="signin_btn" value="로그인">
				<div class="signin_text forgot_info_div"><span class="forgot_info">아이디/비밀번호 찾기</span></div>
				<div class="signin_text signup_div">아직 회원이 아니신가요?<span class="sign_up_span">회원가입</span></div>
			</form>
		</div>
   	</section> 

    <script src="/resources/js/user/sign_in.js"></script>    
</body>