<%--
  Created by IntelliJ IDEA.
  User: goott4
  Date: 2023-04-05
  Time: 오후 7:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

    <title></title>
</head>
<body>
<p>제목 : ${data.plan_title}</p>
<p>내용 : ${data.plan_detail}</p>
<p>가격 : ${data.price}</p>
<%--<c:set var = "date_count" value = "${data.end_date - data.start_date}"/>--%>
<%--<c:out value="${date_count}"/>--%>
<p>기간 : </p>
<p>시작날짜 : ${data.start_date}</p>
<p>종료날짜 : ${data.end_date}</p>
<p>작성자 : ${data.user_id}</p>
<c:if test="${data.user_id == sessionScope.user_id}">
    <button type="button" onclick="location.href='edit/${data.plan_idx}'">수정</button>
    <button data-id="${data.plan_idx}" id="delete">삭제</button>
</c:if>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script>
    $('#delete').click(function (e) {
        let number = e.target.dataset.id;
        $.ajax({
            method: 'POST',
            url: '/plan/list/delete',
            data: {plan_idx: number}
        }).done(function (result) {
            alert('요청 성공')
            window.location.href = "/plan/list";
        }).fail(function (xhr, textStatus, errorThrown) {
            console.log(xhr, textStatus, errorThrown);  // 실패시 실행할 코드
        });
    });
</script>
</body>
</html>
