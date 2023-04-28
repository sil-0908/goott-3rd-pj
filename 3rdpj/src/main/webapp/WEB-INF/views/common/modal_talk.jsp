<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
	<link rel="stylesheet" href="/resources/css/style.css"/>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body> --%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.goott.pj3.plan.dto.PlanDTO" %>

<div class="modal modal__talk">
  <section class="chatbox">
    <section class="chatbox__doc">
      <div class="chatbox__title">
        <h1>ㅇㅇ플래너와의 대화</h1>
      </div>
      <div class="chatbox__window"></div>
      <div class="chatbox__form">
        <form action="#">
          <input class="chatbox__typing" name="chat" type="search" />
          <button class="chatbox__btn chatbox__submit" type="submit">
            보내기
          </button>
        </form>
      </div>
    </section>
    <div class="chatbox__btns">
      <button class="chatbox__btn modal__btn--talk-close">닫기</button>
      <button class="chatbox__btn modal__btn--pay-open">
        <a href="../html/payment.html">결제하기</a>
      </button>
    </div>
  </section>
</div>