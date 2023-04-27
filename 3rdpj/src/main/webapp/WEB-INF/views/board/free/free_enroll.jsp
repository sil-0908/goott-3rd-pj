<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<main>
	<hgroup class="free__title">
        <h1>문의 등록</h1>
      </hgroup>
	<section>
		<form name="test1" action="/free/enroll" method="post">
		    <div class="input_wrap free__label">
		        <label>Title</label>
		        <input name="free_title">
		    </div>
		    <div class="input_wrap">
		        <label>Content</label>
		        <textarea rows="3" name="free_content"></textarea>
		    </div>
			<input type="button" value="등록" onclick="test()">
		</form>
	</section>
</main>
<script src="/resources/js/common/layout.js"></script>
<script>
function test() {
	document.test1.submit();
}
</script>