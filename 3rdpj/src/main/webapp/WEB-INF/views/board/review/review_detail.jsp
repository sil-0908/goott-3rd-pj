<%--
  Created by IntelliJ IDEA.
  User: goott4
  Date: 2023-04-05
  Time: 오후 6:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>리뷰 화면</title>
</head>
<body>
<h1> 리뷰 화면</h1>

<p>번호 : ${data.review_idx}</p>
<p>리뷰 사진 : <img src="${data.reiew_img} height="200px" width="200px" style="border: 1px solid red;"></p>
<p>내용 : ${data.review_content}</p>
<p>작성자 : ${data.user_id}</p>
<p>작성일 : ${data.create_date}"</p>
<c:if test="${data.user_id == sessionScope.user_id}">
<p>
    <a href="/review/update?review_idx=${review_idx}">수정</a>
</p>

<form method="POST" action="/review/delete">
    <input type="hidden" name="review_idx" value="${review_idx}">
    <input type="submit" value="삭제">
</form>
</c:if>
<p>
    <a href="/review/list">목록</a>
</p>
</body>
</html>
