<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<html>
<head>
    <title>리뷰 상세 페이지</title>
</head>
<body>
<h1> 리뷰 상세페이지 </h1>

<p>번호 : ${data.review_idx}</p>
<p>리뷰 사진 :
<c:forEach var="img" items="${data.r_img}" >
    <img src="${img}" height="200px" width="200px" style="border: 1px solid red;">
</c:forEach>
<p>내용 : ${data.review_content}</p>
<p>작성자 : ${data.user_id}</p>
<p>작성일 :
    <fmt:formatDate
            pattern="yyyy-MM-dd HH:mm:ss"
            value="${data.create_date}"/></p>
<p>
    <a href="/review/update/${data.review_idx}">수정</a>
</p>
<form method="POST" action="/review/delete/${data.review_idx}">
    <input type="submit" value="삭제">
</form>
<p>
    <a href="/admin/reviewlist">목록</a>
</p>
</body>
</html>
