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
    <title>리뷰 목록</title>
</head>
<body>
<h1>리뷰 목록</h1>
<p>
  <a href="/review/create">리뷰 작성</a>
</p>
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
    <td></td>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="row" items="${data}">
    <tr>
      <td>
        <a href="/review/detail?review_idx=${row.review_idx}">
          <img src="${row.review_img}" height="200px" width="200px" style="border: 1px solid red";>
        </a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
