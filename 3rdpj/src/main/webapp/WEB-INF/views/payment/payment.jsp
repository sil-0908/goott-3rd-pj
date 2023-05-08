<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
  Created by STS.
  User: 김규동
  Date: 2023-05-04
  Time: 오후 4:00
--%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %> 
<main class="payment">
      <section class="payment__doc">
        <section class="payment__info">
          <article class="payment__prof--img"></article>
          <article class="payment__prof--description">
            <ul class="payment__prof--description-list">
              <li>가입자:</li>
              <li>결제일:</li>
              <li>결제금액:</li>
              <li>매칭플래너:</li>
            </ul>
          </article>
        </section>
        <section class="payment__list">
          <h1>결제 수단 선택</h1>
          <form class="payment__form" method="post">
            <label>
              <input name="pay-method" type="radio" />신용카드 or 체크카드
            </label>
            <label><input name="pay-method" type="radio" />카카오페이</label>
            <label><input name="pay-method" type="radio" />네이버페이</label>
            <label><input name="pay-method" type="radio" />페이코</label>
            <label><input name="pay-method" type="radio" />토스페이</label>
            <button class="payment__btn" type="submit">구매</button>
          </form>
          <div class="payment__rule">
            <p>취소와 환불에 관해 자세히 알아보기</p>
            <p> 
              계속 진행함으로써 본인이 해당
              플래너와의 매칭을 확인하고, 본 약관에 동의함을 확인합니다. 계속
              진행하면 서비스 약관에 동의하는 것으로 간주됩니다.
              개인정보처리방침 개인정보 수집 및 공유에 사용자의 데이터를
              처리하는 방식이 설명되어 있습니다.
            </p>
          </div>
        </section>
      </section>
    </main>
<script src="/resources/js/common/layout.js"></script>
	<script src="/resources/js/common/payment.js"></script>
    <!-- <script src="/resources/js/common/search.js"></script> -->
    <script 
    	type="text/javascript" 
    	src="https://service.iamport.kr/js/iamport.payment-1.2.0.js">
    </script>
    <script
      src="https://kit.fontawesome.com/7723a79ab5.js"
      crossorigin="anonymous"
    ></script>