<%--
  Created by IntelliJ IDEA.
  User: goott4
  Date: 2023-04-25
  Time: 오후 6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="delete" action="cart/delete" method="POST">
    <input type="hidden" name="_method" value="delete"/>
    <c:if test="${not empty cart}">
        <tr>
            <c:forEach var="item" items="${cart}">
                <c:if test="${item.p_del_yn eq 'N'}">
                    <td><a href="list/${item.plan_idx}">${item.plan_title}</a></td>
                    <td>${item.plan_idx}</td>
                    <input name="delList" type="checkbox" value="${item.plan_idx}"/>
                    <br>
                </c:if>
            </c:forEach>
            <button type="submit">삭제</button>
        </tr>
    </c:if>
</form>
</body>
</html>
