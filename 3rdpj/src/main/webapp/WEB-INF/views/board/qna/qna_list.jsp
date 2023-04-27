<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<%@ include file="/WEB-INF/views/common/modal_right.jsp" %>
<main class="qna">
      <hgroup class="qna__title">
        <h1>공지사항</h1>
      </hgroup>
        <form name="search_notice">
  			<select class="search__selectBox" id="selectBox" name="option">
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
					<a class="link__detail"><c:out value="${list.qna_title}"/></a>
					<div>
						<c:if test="${list.qna_pw != '' && list.qna_pw != null}">
							<span><i class="fa-solid fa-lock"></i></span>
							<input class="passwordInput" type="hidden" value="${list.qna_pw}">
						</c:if>
					</div>
	          	</li>
        		</c:if>
			</c:forEach>
        </ul>
        <div class="pagination">
			<form action="form1">
				<ul class="btn-group pagination">
					<c:if test="${paging.prev}">
						<li>
							<a href='<c:url value="/qna/list_${paging.cri.category}?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.startPage-1}"/>'><i class="fa fa-chevron-left"></i></a>
						</li>
					</c:if>
					<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="pageNum">
						<li>
							<a href='<c:url value="/qna/list_${paging.cri.category}?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${pageNum}"/>'><i class="fa">${pageNum}</i></a>
						</li>
					</c:forEach>
					<c:if test="${paging.next && paging.endPage >0 }">
						<li>
							<a href='<c:url value="/qna/list_${paging.cri.category}?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.endPage+1}"/>'><i class="fa fa-chevron-right"></i></a>
						</li>
					</c:if>
				</ul>
				<input type="hidden" name="category" value="${paging.cri.category}">
				<input type="hidden" name="page" value="${paging.cri.page}">
				<input type="hidden" name="keyword" value="${paging.cri.keyword}">
				<input type="hidden" name="option" value="${paging.cri.option}">
			</form>
		</div>
      </section>
    </main>
	<script src="/resources/js/common/layout.js"></script>
	<script src="/resources/js/common/modal_right.js"></script>

	<script>
	// 23.04.27 김규동
		/* const CATEGORY_IDX = 3;
		$(function() {
	        $('.link__detail').click(function(e) {
	            const idx = e.target.parentElement.previousElementSibling.children[0]
	            const arrUrl = document.location.href.split("/")
	            location.href="/"+arrUrl[CATEGORY_IDX]+"/detail/"+idx.value
	        })
	    }) */
      $(function() {
         $('.link__detail').click(function(e) {
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
            location.href='/qna/detail/'+idx.value;
         })
      })


      $('#search').click(function(){
         if($("input[name=keyword]").val() == 'undefined' || $('input[name=keyword]').val() == ''){
            alert("검색어를 입력하세요");
            return;
         }
      });
   </script>