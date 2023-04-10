<%--
  Created by IntelliJ IDEA.
  User: chowonjae
  Date: 2023-04-06
  Time: 오전 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>여행지 정보 목록</title>
</head>
<body>
<h1>여행지 정보 목록</h1>
<c:if test="${sessionScope.auth ne 'auth_c'}">
<p>
  <a href="/travelinfo/create">리뷰 작성</a>
</p>
</c:if>
<p>
  <form>
      <input type="text" placeholder="검색" name="keyword" value="${keyword}">
      <input type="submit" value="검색">
  </form>
</p>
<table>
  <thead>
  <tr>
    <td>리뷰사진 : </td>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="row" items="${data}">
    <tr>
      <td>
          <p>번호 : ${row.travel_location_idx}</p>
        <a href="/travelinfo/detail?travel_location_idx=${row.travel_location_idx}">
          <img src="${row.country_img}" height="200px" width="200px" style="border: 1px solid red";>
        </a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
