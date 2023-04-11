<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
	<link rel="stylesheet" href="/resources/css/common/style.css"/>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<%@ include file="/WEB-INF/views/common/qna_modal.jsp" %>
	<a href="/qna/create">게시판 등록</a>

	<form name="keyword_transfer">
		<div>
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
				<td>${list.qna_idx}</td>
				<td class="title"><c:out value="${list.qna_title}"/></td>
				<td><c:out value="${list.user_id}"/></td>
				<td>
					<c:if test="'${list.create_date}' eq '${list.update_date}' ">
						<fmt:formatDate pattern="yyyy/MM/dd" value="${list.create_date}"/>(<fmt:formatDate pattern="yyyy/MM/dd" value="${list.update_date}"/>)
					</c:if>
					<c:if test="'${list.create_date}' ne '${list.update_date}' ">
						<fmt:formatDate pattern="yyyy/MM/dd" value="${list.create_date}"/>
					</c:if>
				</td>
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
	<script src="/resources/js/common/layout.js"></script>
	<script src="/resources/js/common/qna_main.js"></script>

	<script>
		$(function() {
			$('.title').click(function(e) {
				const idx = e.target.parentElement.children[0]
				location.href='/qna/detail/'+idx.textContent
			})
		})


		$('#search').click(function(){
			if($("input[name=keyword]").val() == 'undefined' || $('input[name=keyword]').val() == ''){
				alert("검색어를 입력하세요");
				return;
			}
			document.keyword_transfer.submit();
		});
	</script>
</body>
</html>