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
    <input type="text" name="qna_idx" value="${data.qna_idx}" id="test4" readonly>
</div>
<div class="input_wrap">
    <label>게시판 제목</label>
    <input type="text" name="free_title" value="${data.qna_idx}" >
</div>
<div class="input_wrap">
    <label>게시판 내용</label>
    <textarea name="qna_content">${data.qna_content}</textarea>
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
            const qna_title = document.querySelector('input[name=qna_title]').value;
            const qna_content = document.querySelector('textarea[name=qna_content]').value;
            const qna_idx = document.querySelector('input[name=qna_idx]').value;

            $.ajax({
                url : '/qnamodify',
                data : {"qna_idx" : qna_idx, "qna_title" : qna_title,
                    "qna_content" : qna_content},
                type : 'post',
                dataType : 'text',
                success : function(data) {
                    if(data === "수정완료"){
                        alert("게시글이 수정되었습니다.")
                        location.href = "/qnalist"
                    }
                }
            })
        })
    })

    $(function() {
        $('#delete').click(function() {
            const qna_idx = document.querySelector('input[name=qna_idx]').value;

            $.ajax({
                url : '/qnadelete',
                data : {"qna_idx" : qna_idx},
                type : 'post',
                success : function() {
                    alert("게시글이 삭제되었습니다.")
                    location.href = "/qnalist"
                }

            })
        })
    })
</script>
</body>
</html>