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
<main class="qna">
      <hgroup class="qna__title">
        <h1>공지사항</h1>
      </hgroup>
      <article class="qna__search">
        <form name="search_notice">
          <input class="qna__typing" name="keyword" type="search" value="${paging.cri.keyword}" />
          <button class="qna__btn qna__submit" type="submit">검색</button>
        </form>
      </article>
      <section class="qna__notice">
        <ul class="qna__list">
           <c:forEach items="${list}" var="list" varStatus="status">
	          <c:if test="${status.count <= 6}">
           		<li><input type="hidden" name="qna_idx" value="${list.qna_idx}"></li>
	          	<li class="qna__list--question">
					<c:out value="${list.qna_title}"/>
	          	</li>
        		</c:if>
			</c:forEach>
        </ul>
      </section>
      <dialog class="qna__guide">
        <hgroup class="qna__guide--title">
          <h1>도움이 더 필요하신가요?</h1>
        </hgroup>
        <article class="qna__guide--list">
          <a href="">- 이용가이드 바로가기</a><br />
          <a href="">- Q&A 문의글 작성</a>
        </article>
        <button class="qna__guide--btn-close">
          <i class="fa-solid fa-xmark"></i>
        </button>
      </dialog>
    </main>
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