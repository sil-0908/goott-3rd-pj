<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<a href="/qna/create">게시판 등록</a>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일(수정일자)</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.qna_idx}</td>
				<td class="title"><c:out value="${list.qna_title}"/></td>
				<td><c:out value="${list.user_id}"/></td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.create_date}"/></td>
			</tr>
		</c:forEach>
	</table>
	<ul class="btn-group pagination">
		<c:if test="${paging.prev}">
			<li>
				<a href='<c:url value="/qna/list?page=${paging.startPage-1}"/>'><i class="fa fa-chevron-left"></i></a>
			</li>
		</c:if>
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="pageNum">
			<li>
				<a href='<c:url value="/qna/list?page=${pageNum}"/>'><i class="fa">${pageNum}</i></a>
			</li>
		</c:forEach>
		<c:if test="${paging.next && paging.endPage >0 }">
			<li>
				<a href='<c:url value="/qna/list?page=${paging.endPage+1}"/>'><i class="fa fa-chevron-right"></i></a>
			</li>
		</c:if>
	</ul>

	<script>
		$(function() {
			$('.title').click(function(e) {
				const idx = e.target.parentElement.children[0]
				location.href='/qna/detail/'+idx.textContent
			})
		})
	</script>
</body>
</html>