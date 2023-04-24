<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="/resources/css/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
</head>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
		var originalContent = $("#qna_content").val();
		$("#btnUpdate").click(function(){
			var currentContent = $("#qna_content").val();
			if (currentContent !== originalContent) {
			  document.form1.action="/admin/noticeupdate";
			  document.form1.submit();
		  }
		});
	    $("#btnDelete").click(function(){
	        if(confirm("공지를 삭제하시겠습니까?")){
	            document.form1.action="/admin/noticedelete";
	            document.form1.submit();
	        }
	    });
	    $("#btnDeleteRe").click(function(){
	        if(confirm("공지를 복원하시겠습니까?")){
	            document.form1.action="/admin/noticedeletere";
	            document.form1.submit();
	        }
	    });
	});
</script>

<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<!-- 김규동 23.04.24 admin_detail -->
	<main class="admin">
      <section class="admin__notice-detail">
        <hgroup class="admin__notice-detail--title">
          <h1>공지사항 상세</h1>
          <!-- <div class="admin__notice-create--btn">
            <a href="/admin/noticewrite">관리자 등록</a>
          </div> -->
        </hgroup>
        <article class="admin__notice-detail--sheet">
          <form class="admin__notice-detail--form">
            <ul class="admin__noitce-detail--list">
              <li class="admin__notice-component">
                <span>작성자: </span>
                <span>${dto.user_id}</span>
              </li>
              <li class="admin__notice-component">
                <span>권한: </span>
                <span>${dto.auth}</span>
              </li>
              <li class="admin__notice-component">
                <span>카테고리: </span>
                <span>${dto.category}</span>
              </li>
              <li class="admin__notice-component">
                <label for="qna_title">제목: </label>
                <input
                  name="qna_title"
                  id="qna_title"
                  type="text"
                  value="${dto.qna_title}"
                />
              </li>
              <li class="admin__notice-component">
                <label for="qna_content">내용: </label>
                <textarea rows="5" cols="64" id="qna_content" name="qna_content">${dto.qna_content}</textarea>
              </li>
              <li class="admin__notice-detail--btns">
                <input type="hidden" name="qna_idx" value="${dto.qna_idx}" />
                <button
                  class="btn btn__normal btn__normal--admin-noticedetail"
                  id="btnUpdate"
                >
                  수정
                </button>
                <button
                  class="btn btn__normal btn__normal--admin-noticedetail"
                  id="btnDelete"
                >
                  삭제
                </button>
                <button
                  class="btn btn__normal btn__normal--admin-noticedetail"
                  id="btnDeleteRe"
                >
                  복원
                </button>
              </li>
            </ul>
          </form>
        </article>
      </section>
    </main>
    <%-- <div class="page-wrapper">
        <div class="container-fluid">
            <div class="col-lg-8"><!--게시판 넓이 -->
                <div class="col-lg-12">
                    <h1 class="page-header">공지사항 상세내역</h1>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">공지사항 </div>
                    <div class="panel-body">
					<form id="form1" name="form1" method="post">
						<div>작성자 : ${dto.user_id}</div>
						<div>
							제목 : <input name="qna_title" id="qna_title" value="${dto.qna_title}">
						</div>
						<div>
							권한 :${dto.auth}
						</div>
						<div>카테고리 : ${dto.category}</div>
						<div>내용 : 
							<textarea rows="5" cols="80" id="qna_content" name="qna_content">${dto.qna_content}</textarea>
						</div>
						<div style="width:700px; text-align:center;">
							<input type="hidden" name="qna_idx" value="${dto.qna_idx}">
							<button style="button" id="btnUpdate">수정</button>
							<button style="button" id="btnDelete">삭제</button>
							<button style="button" id="btnDeleteRe">복원</button>
						</div>
					</form>
                    </div>
                </div>
            </div>
        </div>
    </div> --%>
<script src="/resources/js/common/layout.js"></script>
</body>
</html>