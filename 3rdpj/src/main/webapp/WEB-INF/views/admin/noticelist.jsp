<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#btnWrite").click(function(){
		location.href ="admin/noticewrite";
	});
});
</script>
<body>
    <div class="page-wrapper">
        <div class="container-fluid">
            <div class="col-lg-8"><!--게시판 넓이 -->
                <div class="col-lg-12">
                    <h1 class="page-header">공지사항 관리</h1>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <button type="button" class="btn btn-outline btn-primary pull-right" id="btnWrite">
                            <i class="fa fa-edit fa-fw"></i> 공지사항 작성
                        </button>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">공지사항 </div>
                    <div class="panel-body">
                        <table class="table table-hover" border="1" width="700px">
                            <thead>
                                <tr>
                                    <th>작성자</th>
                                    <th>제목</th>
                                    <th>내용</th>
                                    <th>삭제여부</th>
                                    <th>최초등록일</th>
                                    <th>업데이트날짜</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="row" items="${noticelist}">
                                    <tr>
                                        <td>${row.user_id}</td>
                                        <td><a href="/admin/noticedetail?idx=${row.qna_idx}">${row.qna_title}</a></td>
                                        <td>${row.qna_content}</td>
                                        <td>${row.q_del_yn}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${row.create_date}"/></td> 
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${row.update_date}" /></td>             
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>