<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
	</script>
</body>
</html>