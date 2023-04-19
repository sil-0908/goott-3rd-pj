<%--
  Created by IntelliJ IDEA.
  User: chowonjae
  Date: 2023-04-18
  Time: 오후 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>플래너 페이지</title>
</head>
<body>

<h1>내 정보 수정</h1>
<a href="/planner/update/${sessionScope.user_id}"> 정보 수정</a>

<h1>플랜 올리기</h1>
<a href="/plan/create">플랜 생성</a>

<h1>판매중인 플랜</h1>
<c:forEach var="row" items="${data}">
    <p><a href="/plan/detail/${row.plan_idx}">플랜번호${row.plan_idx} / 타이틀${row.plan_title} / 가격${row.plan_title} / 시작날짜${row.start_date}</a></p>
</c:forEach>

<h1>판매끝난 플랜</h1>
<c:forEach var="row" items="${deldata}">
    <p><a href="/plan/detail/${row.plan_idx}">플랜번호${row.plan_idx} / 타이틀${row.plan_title} / 가격${row.plan_title} / 시작날짜${row.start_date}</a></p>
</c:forEach>

<h1>수익부분</h1>

<a href="">수익확인하러가기</a>

</body>
</html>
