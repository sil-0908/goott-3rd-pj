<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원관리</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
    <link rel="stylesheet" href="/resources/css/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>

</script>
<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
    <div class="page-wrapper">
        <div class="container-fluid">
            <div class="col-lg-10"><!--게시판 넓이 -->
                <div class="col-lg-12">
                    <h1 class="page-header">회원관리</h1>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">회원목록 </div>
                    <div class="panel-body">
                        <form name="search">
                            <div>
                                <select id="selectBox" name="option">
                                    <option value="">=======</option>
                                    <option value="user_id">ID</option>
                                    <option value="auth">유저 종류</option>
                                    <option value="email">이메일</option>
                                    <option value="del">탈퇴여부</option>
                                </select>
                            </div>
                            <div class="search_wrap">
                                <div class="search_area">
                                    <input type="text" name="keyword" value="${paging.cri.keyword }">
                                    <button id="search">Search</button>
                                </div>
                            </div>
                        </form>
                        <table class="table table-hover" border="1" width="700px">
                            <thead>
                                <tr>
                                    <th>회원아이디</th>
                                    <th>패스워드</th>
                                    <th>연락처</th>
                                    <th>이메일</th>
                                    <th>권한</th>
                                    <th>탈퇴여부</th>
                                    <th>결제포인트</th>
                                    <th>회원가입일</th>
                                    <th>회원수정일</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="row" items="${adminuserlist}">
                                    <tr>
                                        <td><a href="/admin/userdetail?user_id=${row.user_id}">${row.user_id}</a></td>
                                        <td>${row.pw}</td>
                                        <td>${row.hp}</td>
                                        <td>${row.email}</td>
                                        <td>${row.auth}</td>
                                        <td>${row.u_del_yn}</td>
                                        <td>${row.u_point}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${row.create_date}"/></td> 
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${row.update_date}" /></td>             
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="pagination" style="display: flex; justify-content: center">
                        <form action="form1">
                            <ul class="btn-group pagination">
                                <c:if test="${paging.prev}">
                                    <li>
                                        <a href='<c:url value="/admin/userlist?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.startPage-1}"/>'><i class="fa fa-chevron-left"></i></a>
                                    </li>
                                </c:if>
                                <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="pageNum">
                                    <li>
                                        <a href='<c:url value="/admin/userlist?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${pageNum}"/>'><i class="fa">${pageNum}</i></a>
                                    </li>
                                </c:forEach>
                                <c:if test="${paging.next && paging.endPage >0 }">
                                    <li>
                                        <a href='<c:url value="/admin/userlist?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.endPage+1}"/>'><i class="fa fa-chevron-right"></i></a>
                                    </li>
                                </c:if>
                            </ul>
                            <input type="hidden" name="page" value="${paging.cri.page}">
                            <input type="hidden" name="keyword" value="${paging.cri.keyword}">
                            <input type="hidden" name="option" value="${paging.cri.option}">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script src="/resources/js/common/layout.js"></script>
</body>
</html>