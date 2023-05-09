<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>

<main class="planner_page_main">
	<h2>마이페이지</h2>
	<form name="planner_page_form" method="post">
		<div class="profile_img_div"></div>
		<div class="info_div">
			<p>아이디</p>
			<input type="text" class="page_id" readonly />
			<input type="button" class="page_change_pw" value="비밀번호 변경하기" />
			<p>생년월일</p>
			<input type="text" class="page_birth" readonly />
			<p>이메일</p>
			<input type="text" class="page_email" readonly />
			<p>연락처</p>
			<input type="text" class="page_hp" readonly />
			<p>사업용 연락처</p>
			<input type="text" class="page_emphp" readonly />
			<p>자기소개</p>
			<input type="text" class="page_intro" readonly />
			<p>현재 보유 포인트</p>
			<input type="text" class="page_u_point" readonly />
			<p>사업자번호</p>
			<input type="text" class="page_empnum" readonly />
			<p>성공횟수</p>
			<input type="text" class="page_success_cnt" readonly />
			<p>회원 가입 일자</p>
			<input type="text" class="page_create_date" readonly />
			<p>마지막 수정 일자</p>
			<input type="text" class="page_update_date" readonly />
			<p>플래너 점수</p>
			<input type="text" class="page_planner_score" readonly />
		</div>
	</form>
</main>

<script src="/resources/js/user/planner_page.js"></script>
<script src="/resources/js/common/layout.js"></script>
