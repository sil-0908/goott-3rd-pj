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
<div class="modal modal__detail">
        <section class="modal__window">
          <ul class="modal__grid">
          	<% List<PlanDTO> listModal = (ArrayList<PlanDTO>) request.getAttribute("data");
	        for (int i = 0; i < listModal.size(); i++) { %>
	            <li class="thumbnail thumbnail--theme-modal">
	              <img src="../img/slave.jpg" alt="" />
	              <div class="thumbnail__txt--theme-modal">
	                <p><a href="/plan/list/<%=listModal.get(i).getPlan_idx()%>" style="text-decoration: none;">
		            <%=listModal.get(i).getPlan_title()%></a></p>
	              </div>
	            </li>
            <%} %>
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
      </div>
      
    
<!-- </body> -->