<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
	<link rel="stylesheet" href="/resources/css/common/style.css"/>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<main class="qna">
      <hgroup class="qna__title">
        <h1>문의 등록</h1>
      </hgroup>
      <section class="qna__sheet">
        <form name="enroll" method="post" class="qna__list" action="/qna/enroll">
          <ul class="qna__list">
            <label class="qna__label" for="question">문의사항을 선택하세요.</label>
	        <li class="qna__create">
	          <select class="qna__selection" id="question" name="qna_selection">
	            <option value="criminal">플래너가 범죄자입니다.</option>
	            <option value="fake">허위 플랜에 당했습니다.</option>
	            <option value="refund">환불하고싶어요.</option>
	            <option value="clame">서비스가 불만족스러워요.</option>
	          </select>
	        </li>
            <label class="qna__label" for="tel">전화번호</label>
            <li class="qna__list--question">
              <input name="qna_tel" class="qna__typing" type="text" />
            </li>
            <label class="qna__label" for="email">이메일 주소</label>
            <li class="qna__list--question">
              <input name="qna_email" class="qna__typing" id="email" type="email" />
            </li>
            <label class="qna__label" for="title">제목</label>
            <li class="qna__list--question">
              <input name="qna_title" class="qna__typing" id="title" type="text" />
            </li>
            <label class="qna__label" for="contents">내용</label>
            <li class="qna__list--question-big">
              <textarea
                name="qna_content"
                id="contents"
                cols="65"
                rows="10"
              ></textarea>
            </li>
        	<input class="qna__send qna__btn" type="submit" value="등록" onclick="enroll()">
          </ul>
        </form>
      </section> 
      </main>   
<script src="/resources/js/common/layout.js"></script>
<script>
function create() {
    const title = document.querySelector('input[id=title]');
    const content = document.querySelector('textarea[id=content]');

    if(title.value == "") {
        alert("제목을 입력하세요");
        $('#title').focus();
        return;
    }
    if(content.value == ""){
        alert("내용을 입력하세요");
        $('#content').focus();
        return;
    }
	document.enroll.submit();
}

</script>
</body>
</html>