<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
  <title>QnA List</title>
  <link rel="stylesheet" href="/resources/css/common/style.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  // $(function(){
  //   $("#btnWrite").click(function(){
  //     location.href ="/admin/qnawrite";
  //
  //   });
  // });

</script>
<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<section>
  <hgroup>
    <h1>자주묻는 질문/답변 관리</h1>
    <button type="button" class="btn__qna-create"><a href="/admin/qnawrite">자주묻는질문/답변 작성</a></button>
  </hgroup>
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
  <hgroup>
    <h1>자주묻는 질문/답변 관리</h1>
  </hgroup>
  <article>
    <ul>
      <li>작성자</li>
      <li>제목</li>
      <li>내용</li>
      <li>삭제여부</li>
      <li>최초 등록일</li>
      <li>업데이트 날짜</li>
    </ul>
    <c:forEach var="row" items="${qnalist}">
      <ul>
        <li>${row.user_id}</li>
        <li>
          <a href="/admin/qnadetail?idx=${row.qna_idx}">${row.qna_title}</a>
        </li>
        <li>${row.qna_content}</li>
        <li>${row.q_del_yn}</li>
        <li>
          <fmt:formatDate
                  pattern="yyyy-MM-dd HH:mm:ss"
                  value="${row.create_date}"
          />
        </li>
        <li>
          <fmt:formatDate
                  pattern="yyyy-MM-dd HH:mm:ss"
                  value="${row.update_date}"
          />
        </li>
      </ul>
    </c:forEach>
    <div class="pagination" style="display: flex; justify-content: center">
      <form action="form1">
        <ul class="btn-group pagination">
          <c:if test="${paging.prev}">
            <li>
              <a href='<c:url value="/admin/qnalist?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.startPage-1}"/>'><i class="fa fa-chevron-left"></i></a>
            </li>
          </c:if>
          <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="pageNum">
            <li>
              <a href='<c:url value="/admin/qnalist?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${pageNum}"/>'><i class="fa">${pageNum}</i></a>
            </li>
          </c:forEach>
          <c:if test="${paging.next && paging.endPage >0 }">
            <li>
              <a href='<c:url value="/admin/qnalist?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.endPage+1}"/>'><i class="fa fa-chevron-right"></i></a>
            </li>
          </c:if>
        </ul>
        <input type="hidden" name="page" value="${paging.cri.page}">
        <input type="hidden" name="keyword" value="${paging.cri.keyword}">
        <input type="hidden" name="option" value="${paging.cri.option}">
      </form>
    </div>
  </article>
</section>

<script src="/resources/js/common/layout.js"></script>
</body>

</html>