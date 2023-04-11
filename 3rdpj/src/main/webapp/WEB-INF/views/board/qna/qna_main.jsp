<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
    <link rel="stylesheet" href="/resources/css/common/style.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
    <h1>Q&A</h1>
    <div>
        <h2>공지사항</h2>
        <table class="comment">
            <c:forEach items="${data_n}" var="list">
            <tr>
                <td><input type="hidden" name="qna_idx" value="${list.qna_idx}"></td>
                <td class="title">${list.qna_title}</td>
            </tr>
            </c:forEach>
        </table>
        <a href="/qna/list_n">더보기</a>
    </div>
    <div>
        <h2>관광지 문의</h2>
        <table class="comment">
            <c:forEach items="${data_u}" var="list">
                <tr>
                    <td><input type="hidden" name="qna_idx" value="${list.qna_idx}"></td>
                    <td class="title">${list.qna_title}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="/qna/list_u">더보기</a>
    </div>
    <div>
        <h2>여행 문의</h2>
        <table class="comment">
            <c:forEach items="${data_r}" var="list">
                <tr>
                    <td><input type="hidden" name="qna_idx" value="${list.qna_idx}"></td>
                    <td class="title">${list.qna_title}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="/qna/list_r">더보기</a>
    </div>
    <div>
        <h2>플래너 문의</h2>
        <table class="comment">
            <c:forEach items="${data_e}" var="list">
                <tr>
                    <td><input type="hidden" name="qna_idx" value="${list.qna_idx}"></td>
                    <td class="title">${list.qna_title}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="/qna/list_e">더보기</a>
    </div>
	<script src="/resources/js/common/layout.js"></script>
    <script>
        $(function() {
            $('.title').click(function(e) {
                const idx = e.target.parentElement.children[0].children[0].value
                location.href='/qna/detail/'+idx
            })
        })
    </script>
</body>
</html>