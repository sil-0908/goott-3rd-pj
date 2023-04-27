<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>

    <title>관리자로그인</title>
</head>
<body>
<form name="login" method="post">
    <table>
        <tr>
            <td>아이디</td>
            <td><input name="user_id" id="user_id" required></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input name="pw" id="pw" required></td>
        </tr>
        <tr>
            <td id="login_check"></td>
            <td>
                <button type="button" id="login_chk">로그인</button>
            </td>
            <c:if test="${data == 'error'}">
                <div style="color : red">
                    아이디 및 비밀번호가 일치하지 않습니다.
                </div>
            </c:if>
        </tr>
    </table>
</form>

<script>
    $(function () {
        $("#login_chk").click(function () {
            var user_id = $("#user_id").val(); // 태그에 입력한 값
            var pw = $("#pw").val();

//	      alert(userid);
//	      alert(passwd);
            document.login.action = "/admin/login_check";
            document.login.submit(); // submit을 이벤트 객체를 통해 변경 가능한것을 보여주는것

        });
    });



</script>
</body>
</html>