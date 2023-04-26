<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>리뷰 목록</title>
</head>
<body>
<h1>리뷰 목록</h1>
<p>
<form name="search">
  <div>
    <select id="selectBox" name="option">
      <option value="">=======</option>
      <option value="user_id">ID</option>
      <option value="review_content">리뷰 내용</option>
      <option value="del">탈퇴여부</option>
    </select>
  </div>
  <div class="search_wrap">
    <div class="search_area">
      <input type="text" name="keyword" value="${paging.cri.keyword }">
      <button id="search">Search</button>
    </div>
  </div>
</form>
</p>
<table>
  <thead>
  <tr>
    <th>번호</th>
    <th>사진</th>
    <th>작성자</th>
    <th>삭제여부</th>
    <th>최초등록일</th>
    <th>업데이트날짜</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="row" items="${data}">
    <tr>
      <td>${row.review_idx}</td>
      <td>
        <a href="/admin/reviewdetail?review_idx=${row.review_idx}">
          ${row.review_content}
<%--          <img src="${row.review_img}" height="200px" width="200px" style="border: 1px solid red";>--%>
        </a>
      </td>
      <td>${row.user_id}</td>
      <td>y/n</td>
      <td>
        <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${row.create_date}"/>
      </td>
<%--      <td>--%>
<%--        <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${row.update_date}"/>--%>
<%--      </td>--%>
    </tr>
  </c:forEach>
  </tbody>
</table>
<div class="pagination" style="display: flex; justify-content: center">
  <form action="form1">
    <ul class="btn-group pagination">
      <c:if test="${paging.prev}">
        <li>
          <a href='<c:url value="/admin/reviewlist?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.startPage-1}"/>'><i class="fa fa-chevron-left"></i></a>
        </li>
      </c:if>
      <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="pageNum">
        <li>
          <a href='<c:url value="/admin/reviewlist?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${pageNum}"/>'><i class="fa">${pageNum}</i></a>
        </li>
      </c:forEach>
      <c:if test="${paging.next && paging.endPage >0 }">
        <li>
          <a href='<c:url value="/admin/reviewlist?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.endPage+1}"/>'><i class="fa fa-chevron-right"></i></a>
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
