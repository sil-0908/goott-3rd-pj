<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="test1" action="/free/enroll" method="post">
    <div class="input_wrap">
        <label>Title</label>
        <input name="free_title">
    </div>
    <div class="input_wrap">
        <label>Content</label>
        <textarea rows="3" name="free_content"></textarea>
    </div>
	<input type="button" value="등록" onclick="test()">
</form>
<script>
function test() {
	document.test1.submit();
}

</script>
</body>
</html>