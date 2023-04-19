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
  <form name="search">
  <div>
	<select id="selectBox" name="option">
		<option value="">=======</option>
		<option value="country_a">나라</option>
		<option value="country_b">시/군/구</option>
		<option value="country_c">동</option>
		<option value="country_detail">상세주소</option>
		<option value="country_script">상세설명</option>
	</select>
  </div>
      <input type="text" placeholder="검색" name="keyword" value="${paging.cri.keyword}">
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
	<div class="pagination">
		<form action="form1">
			<ul class="btn-group pagination">
				<c:if test="${paging.prev}">
					<li>
						<a href='<c:url value="/travelinfo/list?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.startPage-1}"/>'><i class="fa fa-chevron-left"></i></a>
					</li>
				</c:if>
				<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="pageNum">
					<li>
						<a href='<c:url value="/travelinfo/list?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${pageNum}"/>'><i class="fa">${pageNum}</i></a>
					</li>
				</c:forEach>
				<c:if test="${paging.next && paging.endPage >0 }">
					<li>
						<a href='<c:url value="/travelinfo/list?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.endPage+1}"/>'><i class="fa fa-chevron-right"></i></a>
					</li>
				</c:if>
			</ul>
			<input type="hidden" name="page" value="${paging.cri.page}">
			<input type="hidden" name="keyword" value="${paging.cri.keyword}">
			<input type="hidden" name="option" value="${paging.cri.option}">
		</form>
	</div>
</body>
</html>
