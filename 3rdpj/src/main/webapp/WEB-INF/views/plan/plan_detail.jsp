<%--
  Created by IntelliJ IDEA.
  User: goott4
  Date: 2023-04-05
  Time: 오후 7:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

    <title></title>
</head>
<body>
<p>제목 : ${data.plan_title}</p>
<p>내용 : ${data.plan_detail}</p>
<p>가격 : ${data.price}</p>
<p>시작날짜 : ${data.start_date}</p>
<p>종료날짜 : ${data.end_date}</p>
<p>작성자 : ${data.user_id}</p>
<p id="output"></p>
<button type="button">수정</button>
<button type="button">삭제</button>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        var output = "";
        for(var key in window.sessionStorage) {
            output += "<p>";
            output += key + " : " + sessionStorage.getItem(key);
            output += "</p>";
        }
    });
    document.querySelector("#output").innerHTML = output;
</script>
</body>
</html>
