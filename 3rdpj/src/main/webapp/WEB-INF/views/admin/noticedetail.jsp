<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
    <div class="page-wrapper">
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
    </div>
</body>
</html>