<%--
  Created by IntelliJ IDEA.
  User: goott4
  Date: 2023-04-05
  Time: 오후 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>리뷰 작성</title>
</head>
<body>
<h1>리뷰 작성</h1>
<form method="POST">
    <input type="hidden" name="plan_idx" value="1">
    <p>내용 : <input type="text" name="review_content"></p>
    <p>사진 : <input type="file" name="review_img"></p>
    <p>평점 :
        <input type="radio" name="review_rating" value="1">1
        <input type="radio" name="review_rating" value="2">2
        <input type="radio" name="review_rating" value="3">3
        <input type="radio" name="review_rating" value="4">4
        <input type="radio" name="review_rating" value="5">5
    </p>
    <p><input type="submit" value="저장"></p>
</form>
</body>
</html>
