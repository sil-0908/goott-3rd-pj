<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/common/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$("#btnSave").click(function(){
	let category = document.form1.category.value;
	if(category!="N"){
		alert("공지사항 카테고리는 N입니다")
		document.form1.category.focus();
		return;
	}
	document.form1.submit();
	
});
</script>

<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
    <div class="page-wrapper">
        <div class="container-fluid">
            <div class="col-lg-8"><!--게시판 넓이 -->
                <div class="col-lg-12">
                    <h1 class="page-header">공지사항 등록</h1>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">공지사항 작성 </div>
                    <div class="panel-body">
					<form id="form1" name="form1" method="post" action="/admin/noticeinsert">
						<div>
							<input name="user_id" id="user_id" value="admin">
						</div>
						<div>
							<input name="qna_title" id="qna_title" size="80" placeholder=" 제목을 입력하세요.">
						</div>
						<div>
							<input name="auth" id="auth" value="auth_a">
						</div>
						<div>
							<input name="category" id="category"  value="N">
						</div>
						<div style="width:800px">
							<textarea rows="5" cols="80" id="qna_content" name="qna_content" placeholder="내용을 입력하세요"></textarea>
						</div>
						<div style="width:700px; text-align:center;">
						<button style="button" id="btnSave">등록하기</button>
						</div>
					</form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script src="/resources/js/common/layout.js"></script>
</body>
</html>