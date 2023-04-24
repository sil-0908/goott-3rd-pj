<%--
  Created by IntelliJ IDEA.
  User: goott4
  Date: 2023-04-05
  Time: 오후 6:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>리뷰 화면</title>
</head>
<body>
<h1> 리뷰 화면</h1>

<p>번호 : ${data.review_idx}</p>
<c:forEach var="image" items="${imglist}" >
    <p>리뷰 사진 : <img src="${image}" height="200px" width="200px" style="border: 1px solid red;"></p>
</c:forEach>
<p>내용 : ${data.review_content}</p>
<p>작성자 : ${data.user_id}</p>
<p>작성일 : ${data.create_date}"</p>


<%--<c:if test="${data.user_id == sessionScope.user_id}">--%>
<p>
    <a href="/review/update/${data.review_idx}">수정</a>
</p>

<form method="POST" action="/review/delete/${data.review_idx}">
    <input type="submit" value="삭제">
</form>
<%--</c:if>--%>
<p>
    <a href="/review/list">목록</a>
</p>
<%--	<div>--%>
<%--		<form method="post" action="/reviewReply/write">--%>
<%--			<p>--%>
<%--				<label>댓글 작성자</label>--%>
<%--				<input type="text" name="r_writer" value="${sessionScope.user_id}">--%>
<%--			</p>--%>
<%--			<p>--%>
<%--				<textarea rows="5" cols="50" name="r_content"></textarea>--%>
<%--			</p>--%>
<%--			<p>--%>
<%--				<input type="hidden" name="review_idx" value="${data.review_idx}">--%>
<%--				<button type="submit">댓글 작성</button>--%>
<%--			</p>--%>
<%--		</form>--%>
<%--	</div>--%>
<%--	<hr>--%>
<%--	<div id="reply">--%>
<%--		--%>
<%--	</div>--%>
	<script>
		// $(document).ready(function() {
		// 	getList();
		// })
		//
		// function getList() {
		// 	var free_idx = $('input[name=review_idx]').val();
		// 	var user_id = $('input[name=r_writer]').val();
		// 	$.ajax({
		// 		type : 'GET',
		// 		url : '/reviewReply/getList',
		// 		data : {'review_idx' : review_idx},
		// 		success : function(result) {
		// 			for(var i = 0; i < result.length; i++){
		// 				var str = "<div class='replyarea'>"
		// 				str += result[i].r_writer + "&nbsp;:&nbsp;"
		// 				if(user_id == (result[i].r_writer)){
		// 					str += "<input type='text' name='r_content' value=" + result[i].r_content + " >"
		// 				}
		// 				else{
		// 					str += 	"<input type='text' name='r_content' value="+result[i].r_content+" readonly>"
		// 				}
		// 				str	+= "&nbsp;&nbsp;"
		// 				str += "<button onclick = 'r_edit()'>수정</button>"
		// 				str += "&nbsp;<button onclick = 'r_delete()'>삭제</button>"
		// 				str += "<input type='hidden' name='reply_idx' value="+result[i].reply_idx+">"
		// 				str += "</div><hr>"
		// 				$("#reply").append(str);
		// 			}
		// 		},
		// 		error : function() {
		// 			alert("에러")
		// 		}
		// 	})
		// }
		//
		// function r_edit() {
		// 	var free_idx = $('input[name=review_idx]').val();
		// 	var reply_idx = document.querySelector('.replyarea').children.reply_idx.value
		// 	var r_content = document.querySelector('.replyarea').children[0].value
		//
		// 	$.ajax({
		// 		url : '/reviewReply/update',
		// 		data : {"review_idx" : review_idx, 'reply_idx' : reply_idx, 'r_content' : r_content},
		// 		type : 'post',
		// 		success : function (result){
		// 			alert('댓글이 수정되었습니다')
		// 			location.href = "/review/detail/"+review_idx;
		// 		}
		// 	})
		// }
		//
		// function r_delete() {
		// 	var free_idx = $('input[name=review_idx]').val();
		// 	var reply_idx = document.querySelector('.replyarea').children.reply_idx.value
		//
		// 	$.ajax({
		// 		url : '/reviewReply/delete',
		// 		data : {"review_idx" : review_idx, 'reply_idx' : reply_idx},
		// 		type : 'post',
		// 		success : function (result){
		// 			alert('댓글이 삭제되었습니다')
		// 			location.href = "/review/detail/"+review_idx;
		// 		}
		// 	})
		// }
	</script>
</body>
</html>
