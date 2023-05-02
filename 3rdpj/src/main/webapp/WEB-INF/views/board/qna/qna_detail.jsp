<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/style.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
	<h1>조회 페이지</h1>
	<div class="input_wrap">
		<label>게시판 번호</label>
		<input type="text" value="${data.qna_idx}" id="qna_id" readonly>
	</div>
	<div class="input_wrap">
		<label>게시판 제목</label>
		<input type="text" name="qna_title" value="${data.qna_title}" >
	</div>
	<div class="input_wrap">
		<label>게시판 내용</label>
		<textarea name="qna_content">${data.qna_content}</textarea>
	</div>
	<div class="input_wrap">
		<label>게시판 작성자</label>
		${data.user_id}
	</div>
	<div class="input_wrap">
		<label>게시판 등록일</label>
		<p><fmt:formatDate pattern="yyyy/MM/dd" value="${data.create_date}"/></p>
	</div>
	<button onclick="list()">게시글 목록</button>
	<button id="modify">게시글 수정</button>
	<button id="delete">게시글 삭제</button>

	<div>
		<c:if test="${sessionScope.auth eq 'auth_a'}">
			<form method="post" action="/qnaReply/write">
				<p>
					<label>댓글 작성자</label>
					<input type="text" name="r_writer" value="${sessionScope.user_id}">

				</p>
				<p>
					<textarea rows="5" cols="50" name="r_content"></textarea>
				</p>
				<p>
					<input type="hidden" name="qna_idx" value="${data.qna_idx}">
					<button type="submit">댓글 작성</button>
				</p>
			</form>
		</c:if>
	</div>
	<hr>
	<div id="reply">

	</div>
	<input type="hidden" name="r_writer" value="${sessionScope.user_id}">
	<input type="hidden" name="qna_idx" value="${data.qna_idx}">
	<input type="hidden" name="auth" value="${sessionScope.auth}">

	<script src="/resources/js/common/layout.js"></script>

<input type="hidden" id="category" value="${data.category}">
<script>
	$(function() {

		$('#modify').click(function() {
			const qna_title = document.querySelector('input[name=qna_title]').value;
			const qna_content = document.querySelector('textarea[name=qna_content]').value;
			const qna_idx = document.querySelector('#qna_id').value;
			alert("test");
			$.ajax({
				url : '/qna/modify',
				data : {"qna_idx" : qna_idx, "qna_title" : qna_title, "qna_content" : qna_content},
				type : 'post',
				dataType : 'text',
				success : function(data) {
					if(data == "N"){
						alert("게시글이 수정되었습니다.")
						location.href = "/qna/list_N"
					}
					else if(data == "Q"){
						alert("게시글이 수정되었습니다.")
						location.href = "/qna/list_Q"
					}
					else if(data == "R"){
						alert("게시글이 수정되었습니다.")
						location.href = "/qna/list_R"
					}
					else{
						alert("게시글이 수정되었습니다.")
						location.href = "/qna/list_U"
					}
				}
			})
		})


		$('#delete').click(function() {
			const qna_idx = document.querySelector('#qna_id').value;
			$.ajax({
				url : '/qna/delete',
				data : {"qna_idx" : qna_idx},
				type : 'post',
				dataType: 'text',
				success : function(data) {
					if(data == "N"){
						alert("게시글이 삭제되었습니다.")
						location.href = "/qna/list_N"
					}
					else if(data == "Q"){
						alert("게시글이 삭제되었습니다.")
						location.href = "/qna/list_Q"
					}
					else if(data == "R"){
						alert("게시글이 삭제되었습니다.")
						location.href = "/qna/list_R"
					}
					else{
						alert("게시글이 삭제되었습니다.")
						location.href = "/qna/list_U"
					}
				}
			})
		})
	})

	function list(){
		const category = document.querySelector("#category").value
		console.log(category)
		if(category == 'N'.toString()){
			location.href = '/qna/list_N'
		}
		else if(category == 'Q'.toString()){
			location.href = '/qna/list_Q'
		}
		else if(category == 'R'.toString()){
			location.href = '/qna/list_R'
		}
		else{
			location.href = '/qna/list_U'
		}

	}

	$(document).ready(function() {
		getList();
	})

	function getList() {
		var qna_idx = $('input[name=qna_idx]').val();
		var user_id = $('input[name=r_writer]').val();
		var auth = $('input[name=auth]').val();
		$.ajax({
			type : 'GET',
			url : '/qnaReply/getList',
			data : {'qna_idx' : qna_idx},
			success : function(result) {
				for(var i = 0; i < result.length; i++){
					var str = "<div class='replyarea'>"
					str += result[i].r_writer + "&nbsp;:&nbsp;"
					if(user_id == (result[i].r_writer)){
						str += "<input type='text' name='r_content' value=" + result[i].r_content + " >"
					}
					else{
						str += 	"<input type='text' name='r_content' value="+result[i].r_content+" readonly>"
					}
					str	+= "&nbsp;&nbsp;"
					if(auth == 'auth_a'){
						str += "<button onclick = 'r_edit()'>수정</button>"
						str += "&nbsp;<button onclick = 'r_delete()'>삭제</button>"
					}
					str += "<input type='hidden' name='reply_idx' value="+result[i].reply_idx+">"
					str += "</div><hr>"
					$("#reply").append(str);
				}
			},
			error : function() {
				alert("에러")
			}
		})
	}

	function r_edit() {
		var qna_idx = $('input[name=qna_idx]').val();
		var reply_idx = document.querySelector('.replyarea').children.reply_idx.value
		var r_content = document.querySelector('.replyarea').children[0].value

		$.ajax({
			url : '/qnaReply/update',
			data : {"qna_idx" : qna_idx, 'reply_idx' : reply_idx, 'r_content' : r_content},
			type : 'post',
			success : function (){
				alert('댓글이 수정되었습니다')
				location.href = "/qna/detail/"+qna_idx;
			}
		})
	}

	function r_delete() {
		var qna_idx = $('input[name=qna_idx]').val();
		var reply_idx = document.querySelector('.replyarea').children.reply_idx.value

		$.ajax({
			url : '/qnaReply/delete',
			data : {"qna_idx" : qna_idx, 'reply_idx' : reply_idx},
			type : 'post',
			success : function (){
				alert('댓글이 삭제되었습니다')
				location.href = "/qna/detail/"+qna_idx;
			}
		})
	}
</script>
</body>
</html>