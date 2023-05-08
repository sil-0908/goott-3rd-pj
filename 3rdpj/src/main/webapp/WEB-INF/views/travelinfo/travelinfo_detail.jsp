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
    <title>여행지</title>
</head>
<body>
<h1>여행지</h1>
<p>번호 : ${data.travel_location_idx}</p>
<p>리뷰 사진 : </p>
<c:forEach var="img" items="${data.t_img}">
<img src="${img}" height="200px" width="200px" style="border: 1px solid red;">
</c:forEach>
<p>장소 : ${data.country_c}</p>
<p>국가 : ${data.country_a}</p>
<p>위치 : ${data.country_b}</p>
<p>상세주소 : ${data.country_script}</p>
<p>여행지 상세 내용 : ${data.country_detail}</p>
<c:if test="${data.user_id == sessionScope.user_id}">
<p>
    <a href="/travelinfo/update/${data.travel_location_idx}">수정</a>
</p>

<form method="POST" action="/travelinfo/delete/${data.travel_location_idx}">
    <input type="submit" value="삭제">
</form>
</c:if>
<p>
    <a href="/travelinfo/list">목록</a>
</p>
</body>
</html>
