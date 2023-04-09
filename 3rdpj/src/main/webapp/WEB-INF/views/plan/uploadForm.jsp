<%--
  Created by IntelliJ IDEA.
  User: Ang
  Date: 2023-04-09
  Time: 오후 11:51
  To change this template use File | Settings | File Templates.
  2023.04.09 길영준 업로드 테스트용 jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload Form</title>
</head>
<body>
<h1>File Upload Form</h1>
<form method="post" enctype="multipart/form-data" action="/upload">
    <input type="file" name="file" /><br/><br/>
    <input type="submit" value="Upload"/>
</form>
</body>
</html>