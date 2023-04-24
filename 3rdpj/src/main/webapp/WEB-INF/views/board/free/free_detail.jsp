<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>조회 페이지</h1>
	<div class="input_wrap">
		<label>게시판 번호</label>
		<input type="text" name="free_idx" value="${data.free_idx}" id="test4" readonly>
	</div>
	<div class="input_wrap">
		<label>게시판 제목</label>
		<input type="text" name="free_title" value="${data.free_title}" >
	</div>
	<div class="input_wrap">
		<label>게시판 내용</label>
		<textarea name="free_content">${data.free_content}</textarea>
	</div>
	<div class="input_wrap">
		<label>게시판 등록일</label>
		<p><fmt:formatDate pattern="yyyy/MM/dd" value="${data.create_date}"/></p>
	</div>
	<button id="modify">게시글 수정</button>
	<button id="delete">게시글 삭제</button>
	<div>
		<form method="post" action="/freeReply/write">
			<p>
				<label>댓글 작성자</label>
				<input type="text" name="r_writer" value="${sessionScope.user_id}">
			</p>
			<p>
				<textarea rows="5" cols="50" name="r_content"></textarea>
			</p>
			<p>
				<input type="hidden" name="free_idx" value="${data.free_idx}">
				<button type="submit">댓글 작성</button>
			</p>
		</form>
	</div>
	<hr>
	<div id="reply">
		
	</div>
	<script>
		$(function() {
			$('#modify').click(function() {
				const free_title = document.querySelector('input[name=free_title]').value;
				const free_content = document.querySelector('textarea[name=free_content]').value;
				const free_idx = document.querySelector('input[name=free_idx]').value;

				$.ajax({
					url : '/free/modify',
					data : {"free_idx" : free_idx, "free_title" : free_title, "free_content" : free_content},
					type : 'post',
					dataType : 'text',
					success : function(data) {
						if(data === "수정완료"){
							alert("게시글이 수정되었습니다.")
							location.href = "/free/list"
						}
					}
				})
			})
		})

		$(function() {
			$('#delete').click(function() {
				const free_idx = document.querySelector('input[name=free_idx]').value;

				$.ajax({
					url : '/free/delete',
					data : {"free_idx" : free_idx},
					type : 'post',
					success : function() {
						alert("게시글이 삭제되었습니다.")
						location.href = "/free/list"
					}

				})
			})
		})
		
		$(document).ready(function() {
			getList();
		})
	
		function getList() {
			var free_idx = $('input[name=free_idx]').val();
			var user_id = $('input[name=r_writer]').val();
			$.ajax({
				type : 'GET',
				url : '/freeReply/getList',
				data : {'free_idx' : free_idx},
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
						str += "<button onclick = 'r_edit()'>수정</button>"
						str += "&nbsp;<button onclick = 'r_delete()'>삭제</button>"
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
			var free_idx = $('input[name=free_idx]').val();
			var reply_idx = document.querySelector('.replyarea').children.reply_idx.value
			var r_content = document.querySelector('.replyarea').children[0].value
			
			$.ajax({
				url : '/freeReply/update',
				data : {"free_idx" : free_idx, 'reply_idx' : reply_idx, 'r_content' : r_content},
				type : 'post',
				success : function (result){
					alert('댓글이 수정되었습니다')
					location.href = "/free/detail/"+free_idx;
				}
			})
		}
		
		function r_delete() {
			var free_idx = $('input[name=free_idx]').val();
			var reply_idx = document.querySelector('.replyarea').children.reply_idx.value

			$.ajax({
				url : '/freeReply/delete',
				data : {"free_idx" : free_idx, 'reply_idx' : reply_idx},
				type : 'post',
				success : function (result){
					alert('댓글이 삭제되었습니다')
					location.href = "/free/detail/"+free_idx;
				}
			})
		}
		
	</script>
</body>
</html>