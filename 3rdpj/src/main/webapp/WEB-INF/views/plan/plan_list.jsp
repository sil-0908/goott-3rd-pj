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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous">
</script>
</body>
</html>
