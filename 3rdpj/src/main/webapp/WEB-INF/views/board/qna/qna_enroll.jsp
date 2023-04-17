<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/common/style.css"/>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<form name="enroll" action="/qna/enroll" method="post">
    <div class="input_wrap">
        <label>문의 제목</label>
        <input name="qna_title">
    </div>
    <div class="input_wrap">
        <label>문의 내용</label>
        <textarea rows="3" name="qna_content"></textarea>
    </div>
	<input type="button" value="등록" onclick="enroll()">
</form>
<script src="/resources/js/common/layout.js"></script>
<script>
function enroll() {
	document.enroll.submit();
}

</script>
</body>
</html>