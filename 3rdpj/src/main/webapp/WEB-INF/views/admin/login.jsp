<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<script>
$(function(){
	   $("#login_chk").click(function(){
	      var user_id=$("#user_id").val(); // 태그에 입력한 값
	      var pw=$("#pw").val();
	      
//	      alert(userid);
//	      alert(passwd);
	      if(user_id==""){
	         alert("아이디를 입력하세요");
	         $("#user_id").focus();
	         return;
	      }
	      if(pw==""){
	         alert("비번을 입력하세요");
	         $("#pw").focus();
	         return;
	      } 
	     
	      document.login.submit();// submit을 이벤트 객체를 통해 변경 가능한것을 보여주는것 
	   });
	   
	   $("#main").click(function() {
		   document.login.action="/admin/main";
		   document.login.subimt();
		
	})
	});


</script>
<title>관리자로그인</title>
</head>
<body>
	<form name="login" method="post" action="/admin/login_check" >
		<table>
			<tr>
				<td>아이디</td>
				<td><input name="user_id" id="user_id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input name="pw" id="pw"></td>
			</tr>
			<tr>
				<td id="login_check"></td>
				<td><input type="button" id="login_chk" value="로그인"></td>
				<td><input type="button" id="main" value="홈으로"></td>
			</tr>
		</table>
	</form>	
	
</body>
</html>