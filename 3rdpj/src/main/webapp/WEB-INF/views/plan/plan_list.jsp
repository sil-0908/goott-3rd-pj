<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.goott.pj3.plan.dto.PlanDTO" %><%--
  Created by IntelliJ IDEA.
  User: goott4
  Date: 2023-04-05
  Time: 오후 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
	<form name="search">
		<div>
			<select id="selectBox" name="option">
				<option value="">=======</option>
				<option value="user_id">ID</option>
				<option value="title">제목</option>
			</select>
		</div>
		<div class="search_wrap">
			<div class="search_area">
				<input type="text" name="keyword" value="${paging.cri.keyword }">
				<button id="search">Search</button>
			</div>
		</div>
    </form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">번호</th>
        <th scope="col">제목</th>
        <th scope="col">가격</th>
        <th scope="col">작성자</th>
    </tr>
    </thead>
    <tbody>
    <% List<PlanDTO> list = (ArrayList<PlanDTO>) request.getAttribute("data");
        for (int i = 0; i < list.size(); i++) { %>
    <tr>
        <th scope="row">
            <%=list.get(i).getPlan_idx()%>
        </th>
        <td><a href="/plan/list/<%=list.get(i).getPlan_idx()%>" style="text-decoration: none;">
            <%=list.get(i).getPlan_title()%></a></td>
        <td>
            <%=list.get(i).getPrice()%>
        </td>
        <td>
            <%=list.get(i).getUser_id()%>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
	<div class="pagination">
		<form action="form1">
			<ul class="btn-group pagination">
				<c:if test="${paging.prev}">
					<li>
						<a href='<c:url value="/plan/list?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.startPage-1}"/>'><i class="fa fa-chevron-left"></i></a>
					</li>
				</c:if>
				<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="pageNum">
					<li>
						<a href='<c:url value="/plan/list?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${pageNum}"/>'><i class="fa">${pageNum}</i></a>
					</li>
				</c:forEach>
				<c:if test="${paging.next && paging.endPage >0 }">
					<li>
						<a href='<c:url value="/plan/list?option=${paging.cri.option}&keyword=${paging.cri.keyword}&page=${paging.endPage+1}"/>'><i class="fa fa-chevron-right"></i></a>
					</li>
				</c:if>
			</ul>
			<input type="hidden" name="page" value="${paging.cri.page}">
			<input type="hidden" name="keyword" value="${paging.cri.keyword}">
			<input type="hidden" name="option" value="${paging.cri.option}">
		</form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous">
</script>
</body>
</html>
