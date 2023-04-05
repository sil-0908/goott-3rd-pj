<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: goott4
  Date: 2023-04-05
  Time: 오전 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="create" method="POST">
    <label for="title">제목<input id="title" type="text" name="plan_title"></label>
    <br>
    <label for="start_date">여행시작날짜</label>
    <input type="date" id="start_date" name="start_date">
    <br>
    <label for="finish_date">여행종료날짜</label>
    <input type="date" id="finish_date" name="end_date">
    <br>
    <label for="price">가격</label>
    <input type="number" id="price" name="price">
    <br>
    <label for="plan_detail">내용</label>
    <textarea id="plan_detail" name="plan_detail"></textarea>
    <button type="submit">등록</button>
</form>


</body>
</html>
