<%--
  Created by IntelliJ IDEA.
  User: chowonjae
  Date: 2023-04-06
  Time: 오전 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>리뷰 수정</title>
</head>
<body>

<h1>리뷰 수정</h1>
<p>이전 사진 뷰 : <img src="${date.review_img}" height="200px" width="200px" style="border: 1px solid red;"></p>

<form method="POST">
    <p>리뷰 내용 : <input type="text" name="review_content" value="${data.review_content}"></p>
    <p>리뷰 사진 : <input type="file" multiple name="review_img" value="${data.review_img}"></p>
    <input type="submit" value="저장">
</form>


</body>
</html>
