<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
	<link rel="stylesheet" href="/resources/css/common/style.css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<%@ include file="/WEB-INF/views/common/qna_modal.jsp" %>
<main class="qna">
      <hgroup class="qna__title">
        <h1>공지사항</h1>
      </hgroup>
        <form name="search_notice">
  			<select class="search__selectBox" id="selectBox" name="category">
  				<option selected="" value="">검색조건을 입력하세요.</option>
	            <option selected="" value="user_id">ID</option>
	            <option selected="selected" value="title">제목</option>
	            <option selected="" value="content">내용</option>
	            <option selected="" value="title,content">제목+내용</option>
   			</select>		
		    <article class="qna__search">
       			<input class="qna__typing" name="keyword" type="search" value="${paging.cri.keyword}" />
       			<button id="search" class="qna__btn qna__submit" type="submit">검색</button>
		    </article>

        </form>
      <section class="qna__notice">
        <ul class="qna__list">
           <c:forEach items="${list}" var="list" varStatus="status">
	          <c:if test="${status.count <= 6}">
           		<li><input type="hidden" name="qna_idx" value="${list.qna_idx}"></li>
	          	<li class="qna__list--question">
					<a class="title"><c:out value="${list.qna_title}"/></a>
					<c:if test="${list.qna_pw != '' && list.qna_pw != null}">
						<span><i class="fa-solid fa-lock"></i></span>
						<input class="passwordInput" type="hidden" value="${list.qna_pw}">
					</c:if>
	          	</li>
        		</c:if>
			</c:forEach>
        </ul>
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
	<script src="/resources/js/common/layout.js"></script>
	<script src="/resources/js/common/qna_main.js"></script>

	<script>
      $(function() {
         $('.title').click(function(e) {
            const idx = e.target.parentElement.previousElementSibling.children[0]
            const lock = e.target.nextElementSibling
            if(lock.children.length == 2){
               //비밀번호 입력 값이 다를 경우 접근 불가
               const passwordCheck = prompt("비밀번호를 입력하세요", "비밀번호 입력");
               if(passwordCheck != $('.passwordInput').val()){
                  alert("비밀번호가 일치하지 않습니다.");
                  return;
               }
               else location.href='/qna/detail/'+idx.value;
            }
            location.href='/qna/detail/'+idx.value
         })
      })


      $('#search').click(function(){
         if($("input[name=keyword]").val() == 'undefined' || $('input[name=keyword]').val() == ''){
            alert("검색어를 입력하세요");
            return;
         }
         const category = document.querySelector('input[name=category]')
         $('#search_transform').attr('action','/qna/list_'+category.value).submit();
      });
   </script>
</body>
</html>