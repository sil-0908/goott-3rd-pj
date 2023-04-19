<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<a href="/free/create">게시판 등록</a>
	<form name="search">
	<div>
		<select id="selectBox" name="option">
			<option value="">=======</option>
			<option value="user_id">ID</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="title,content">제목+내용</option>
		</select>
	</div>
	<div class="search_wrap">
		<div class="search_area">
			<input type="text" name="keyword" value="${paging.cri.keyword }">
			<button id="search">Search</button>
		</div>
	</div>
    </form>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일(수정일자)</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.free_idx}</td>
				<td class="test2"><c:out value="${list.free_title}"/></td>
				<td><c:out value="${list.user_id}"/></td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.create_date}"/></td>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">
		<form action="form1">
			<ul class="btn-group pagination">
				<c:if test="${paging.prev}">
					<li>
						<a href='<c:url value="/free/list?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.startPage-1}"/>'><i class="fa fa-chevron-left"></i></a>
					</li>
				</c:if>
				<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="pageNum">
					<li>
						<a href='<c:url value="/free/list?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${pageNum}"/>'><i class="fa">${pageNum}</i></a>
					</li>
				</c:forEach>
				<c:if test="${paging.next && paging.endPage >0 }">
					<li>
						<a href='<c:url value="/free/list?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.endPage+1}"/>'><i class="fa fa-chevron-right"></i></a>
					</li>
				</c:if>
			</ul>
			<input type="hidden" name="category" value="${paging.cri.category}">
			<input type="hidden" name="page" value="${paging.cri.page}">
			<input type="hidden" name="keyword" value="${paging.cri.keyword}">
			<input type="hidden" name="option" value="${paging.cri.option}">
		</form>
	</div>
	<script>
		$(function() {
			$('.test2').click(function(e) {
				const idx = e.target.parentElement.children[0]
				location.href='/free/detail/'+idx.textContent
			})
		})
	</script>
</body>
</html>