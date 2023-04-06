<%--
  Created by IntelliJ IDEA.
  User: goott3
  Date: 2023-04-06
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <h1>Q&A</h1>
    <div>
        <h2>공지사항</h2>
        <table class="comment">
            <c:forEach items="${list_n}" var="list_n">
            <tr>
                <td class="title"><input type="text" value="${list_n.qna_idx}"><c:out value="${list_n.qna_title}"/></td>
            </tr>
            </c:forEach>
        </table>
        <a href="/qna/list_n">더보기</a>
    </div>
    <div>
        <h2>관광지 문의</h2>
        <table class="comment">
            <c:forEach items="${list_u}" var="list_u">
                <tr>
                    <td class="title"><input type="text" value="${list_u.qna_idx}"><c:out value="${list_u.qna_title}"/></td>
                </tr>
            </c:forEach>
        </table>
        <a href="/qna/list_u">더보기</a>
    </div>
    <div>
        <h2>여행 문의</h2>
        <table class="comment">
            <c:forEach items="${list_r}" var="list_r">
                <tr>
                    <td class="title"><input type="text" value="${list_r.qna_idx}"><c:out value="${list_r.qna_title}"/></td>
                </tr>
            </c:forEach>
        </table>
        <a href="/qna/list_r">더보기</a>
    </div>
    <div>
        <h2>플래너 문의</h2>
        <table class="comment">
            <c:forEach items="${list_e}" var="list_e">
                <tr>
                    <td class="title"><input type="text" value="${list_e.qna_idx}"><c:out value="${list_e.qna_title}"/></td>
                </tr>
            </c:forEach>
        </table>
        <a href="/qna/list_e">더보기</a>
    </div>

    <script>
        // $(function (){
        //     $(".comment").ready(function (){
        //         $.ajax({
        //             url : '/qna/main_list',
        //             success : function (){
        //
        //             }
        //         })
        //     })
        // })
    </script>
</body>
</html>
