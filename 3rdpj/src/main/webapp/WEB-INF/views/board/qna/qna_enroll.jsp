<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/common/style.css"/>
<title>Insert title here</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<form name="enroll" action="/qna/enroll" method="post">
    <div class="input_wrap">
        <label>문의 사항</label>
        <select id="selectBox" name="category">
            <option value="ID">ID</option>
            <option value="SUBJECT">제목</option>
            <option value="CONTENT">내용</option>
            <option value="SUBJECT,CONTENT">제목+내용</option>
        </select>
    </div>
    <div class="input_wrap">
        <label>문의 제목</label>
        <input id="title" name="qna_title">
    </div>
    <div class="input_wrap">
        <label>문의 내용</label>
        <textarea rows="3" name="qna_content" id="content"></textarea>
    </div>
    <div class="input_wrap">
        <label class="form-check-label">비밀글 설정</label>
        <input type="password" name="password" placeholder="비밀번호 입력" maxlength="4">
    </div>
	<input type="button" value="등록" onclick="create()">
</form>
<script src="/resources/js/common/layout.js"></script>
<script>
function create() {
    const title = document.querySelector('input[id=title]');
    const content = document.querySelector('textarea[id=content]');

    if(title.value == "") {
        alert("제목을 입력하세요");
        $('#title').focus();
        return;
    }
    if(content.value == ""){
        alert("내용을 입력하세요");
        $('#content').focus();
        return;
    }
	document.enroll.submit();
}

</script>
</body>
</html>