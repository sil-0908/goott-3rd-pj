<%--
  Created by IntelliJ IDEA.
  User: goott4
  Date: 2023-04-27
  Time: 오후 5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title></title>
</head>
<body>
<div class="container">
    <div>
        <ul>
            <c:forEach items="${list}" var="room">
                <c:if test="${sessionScope.user_id == room.send_id}">
                <li><a href="/chat/room/${room.msg_idx}" id="room-name">${room.receive_id} 와 대화하기</a></li>
                    <p>채팅 생성날짜 :${room.create_date}</p>
                </c:if>
                <c:if test="${sessionScope.user_id == room.receive_id}">
                    <li><a href="/chat/room/${room.msg_idx}" id="room-name2">${room.send_id} 와 대화하기</a></li>
                    <p>채팅 생성날짜 :${room.create_date}</p>
                </c:if>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous">
</script>
<script>
    // $(document).ready(function () {
    //
    //     var roomName = $('#room-name').val();
    //
    //     if (roomName != null)
    //         alert(roomName + "방이 개설되었습니다.");
    //
    //     $(".btn-create").on("click", function (e) {
    //         e.preventDefault();
    //
    //         var name = $("#name").val();
    //
    //         if (name == "")
    //             alert("Please write the name.")
    //         else
    //             $("form").submit();
    //     });
    // });
</script>
</html>
