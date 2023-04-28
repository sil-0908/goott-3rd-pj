<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<main>
	<hgroup class="free__title">
        <h1>문의 등록</h1>
    </hgroup>
	<section>
		<form name="test1" action="/free/enroll" method="post">
			<ul>
				<label class="free__label">Title</label>
				<li class="input__wrap">
		        	<input class="input__box" name="free_title">
				</li>
		        
				<button class="btn btn__normal" type="submit" onclick="test()">등록</button>
			</ul>
		</form>
	</section>
</main>
<script src="/resources/js/common/layout.js"></script>
<script>
function test() {
	document.test1.submit();
}
</script>