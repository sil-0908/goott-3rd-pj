<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.goott.pj3.plan.dto.PlanDTO" %><%--
  Created by IntelliJ IDEA.
  User: 길영준
  Date: 2023-04-05
  Time: 오후 2:20
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<div data-include-path=""></div>
<main class="search">
      <nav class="search__nav">
        <ul class="keywords__ul">
          <li class="btn keywords__btn">
            <a href="">레저</a>
          </li>
          <li class="btn keywords__btn">
            <a href="">힐링</a>
          </li>
          <li class="btn keywords__btn">
            <a href="">식도락</a>
          </li>
          <li class="btn keywords__btn">
            <a href="">페스티벌</a>
          </li>
          <li class="btn keywords__btn">
            <a href="">파티</a>
          </li>
          <li class="btn keywords__btn">
            <a href="">명승지</a>
          </li>
          <li class="btn keywords__btn">
            <a href="">캠핑</a>
          </li>
        </ul>
      </nav>
      <section class="search__results">
        <ul class="grid--theme-search">
	        <% List<PlanDTO> list = (ArrayList<PlanDTO>) request.getAttribute("data");
	        for (int i = 0; i < list.size(); i++) { %>
	          <li class="thumbnail--theme-search modal__btn--detail-open"
	          data-id="<%=list.get(i).getPlan_idx()%>" data-name="<%=list.get(i).getPlan_title()%>">
	            <img src="../img/slave.jpg" alt="" />
	            <div class="thumbnail__txt--theme-search">
	              <p><%=list.get(i).getPlan_title()%></p>
	            </div>
	          </li>
	          <%-- <a href="/plan/list/<%=list.get(i).getPlan_idx()%>" style="text-decoration: none;">
	            <%=list.get(i).getPlan_title()%></a> --%>
          	<%} %>
        </ul>
      </section>

      <!-- 모달창 -->
      <dialog class="modal modal__detail">
        <section class="modal__window">
          <ul class="modal__grid">
            <li class="thumbnail thumbnail--theme-modal">
              <img src="../img/slave.jpg" alt="" />
              <div class="thumbnail__txt--theme-modal">
                <p>마우스 치워라</p>
              </div>
            </li>
          </ul>
          <section class="modal__info">
            <hgroup class="profile">
              <div class="profile__title">
                <h1>플랜 제목</h1>
                <button class="modal__btn">
                  <a href="../html/planner.html"> 플래너 페이지 바로가기 </a>
                </button>
              </div>
              <p>플랜 설명플랜 설명플랜 설명플랜 설명</p>
            </hgroup>
            <div class="modal__btns--add-day">
              <div class="modal__btn modal__btn--color-gray"></div>
              <div class="modal__btn modal__btn--color-gray"></div>
              <div class="modal__btn modal__btn--color-gray"></div>
              <div class="modal__btn"></div>
            </div>
            <section class="schedule">
              <article class="schedule__day">
                <div class="schedule__day--img-node">
                  <img src="../img/day_node.png" alt="" />
                </div>
                <div class="schedule__day--detail">
                  <hgroup class="schedule__day--detail-title">
                    <h1>DAY</h1>
                  </hgroup>
                  <div class="schedule__day--detail-info">
                    <div class="schedule__selectboxes">
                      <select class="schedule__selectbox" name="" id="">
                        <option value="">셀렉트박스1</option>
                      </select>
                      <select class="schedule__selectbox" name="" id="">
                        <option value="">셀렉트박스2</option>
                      </select>
                      <select class="schedule__selectbox" name="" id="">
                        <option value="">셀렉트박스3</option>
                      </select>
                    </div>
                    <div class="schedule__textbox">
                      <p>플랜 상세</p>
                    </div>
                  </div>
                </div>
              </article>
            </section>
            <div class="modal__btns">
              <button class="modal__btn modal__btn--detail-close">닫기</button>
              <button class="modal__btn modal__btn--talk-open">대화하기</button>
            </div>
          </section>
        </section>
      </dialog>
      <dialog class="modal modal__talk">
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
      </dialog>
      
    </main>
    <script src="/resources/js/common/layout.js"></script>
    <!-- <script src="/resources/js/common/search.js"></script> -->
    <script src="/resources/js/common/modal.js"></script>
    <script 
    	type="text/javascript" 
    	src="https://service.iamport.kr/js/iamport.payment-1.2.0.js">
    </script>
    <script
      src="https://kit.fontawesome.com/7723a79ab5.js"
      crossorigin="anonymous"
    ></script>
