<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<header class="header">
      <div class="header__logo">
        <div class="logo">
          <a href="./index.html" class="logo__link">
            <img src="/resources/img/logo_suntour_purple.png" alt="" />
          </a>
        </div>
      </div>
      <nav class="header__nav">
        <ul class="nav">
          <li class="nav__item">플랜</li>
          <li class="nav__item">플래너</li>
          <li class="nav__item">카테고리</li>
          <li class="nav__item">
          	<a href="/user/signin"></a>
          	로그인
    	  </li>
        </ul>
      </nav>
    </header>
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