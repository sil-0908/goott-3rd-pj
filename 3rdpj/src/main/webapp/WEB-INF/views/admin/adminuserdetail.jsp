<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
	var original_Pw = $("#pw").val();
	var original_Birth = $("#birth").val();
	var original_Hp = $("#hp").val();
	var original_Hp_emp = $("#hp_emp").val();
	var original_Email = $("#email").val();
	var original_Intro = $("#intro").val();
	var original_Auth = $("#auth").val();
	var original_Profile_img = $("#profile_img").val();
	var original_U_del_yn = $("#u_del_yn").val();
	var original_U_point = $("#u_point").val();
	var original_Emp_num = $("#emp_num").val();
	var original_Success_count = $("#success_count").val();
	var original_Planner_like = $("#planner_like").val();
	var original_Planner_unlike = $("#planner_unlike").val();
	var original_Acount = $("#acount").val();
	
	$("#btnUpdate").click(function(){
		var current_Pw = $("#pw").val();
		var current_Birth = $("#birth").val();
		var current_Hp = $("#hp").val();
		var current_Hp_emp = $("#hp_emp").val();
		var current_Email = $("#email").val();
		var current_Intro = $("#intro").val();
		var current_Auth = $("#auth").val();
		var current_Profile_img = $("#profile_img").val();
		var current_U_del_yn = $("#u_del_yn").val();
		var current_U_point = $("#u_point").val();
		var current_Emp_num = $("#emp_num").val();
		var current_Success_count = $("#success_count").val();
		var current_Planner_like = $("#planner_like").val();
		var current_Planner_unlike = $("#planner_unlike").val();
		var current_Acount = $("#acount").val();
		
		if (current_Pw !== original_Pw 
				|| current_Birth !== original_Birth 
				|| current_Hp !== original_Hp 
				|| current_Hp_emp !== original_Hp_emp 
				|| current_Email !== original_Email 
				|| current_Intro !== original_Intro 
				|| current_Auth !== original_Auth 
				|| current_Profile_img !== original_Profile_img 
				|| current_U_del_yn !== original_U_del_yn 
				|| current_U_point !== original_U_point 
				|| current_Emp_num !== original_Emp_num 
				|| current_Success_count !== original_Success_count 
				|| current_Planner_like !== original_Planner_like 
				|| current_Planner_unlike !== original_Planner_unlike 
				|| current_Acount !== original_Acount) {
			  document.form1.action="/admin/userupdate";
			  document.form1.submit();
			}
	});
    $("#btnDelete").click(function(){
        if(confirm("회원을 탈퇴시키겠습니까?")){
            document.form1.action="/admin/userdelete";
            document.form1.submit();
        }
    });
    $("#btnDeleteRe").click(function(){
        if(confirm("회원을 복원시키겠습니까?")){
            document.form1.action="/admin/userdeletere";
            document.form1.submit();
        }
    });
});
</script>
<body>
    <div class="page-wrapper">
        <div class="container-fluid">
            <div class="col-lg-8"><!--게시판 넓이 -->
                <div class="col-lg-12">
                    <h1 class="page-header">회원상세내역</h1>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">회원정보 </div>
                    <div class="panel-body">
                    <form name="form1" method="post">
                        <table class="table table-hover" border="1" width="700px">
                                <tr>
                                    <td>회원아이디 : ${dto.user_id}</td>
                                </tr>
                                <tr>
                                    <td>패스워드 :<input name="pw" id="pw" value="${dto.pw}"></td>
                                </tr>
                                <tr>
                                    <td>생년월일 :<input name="birth" id="birth" value="${dto.birth}"></td>
                                </tr>
                                <tr>
                                    <td>연락처 :<input name="hp" id="hp" value="${dto.hp}"></td>
                                </tr>
                                <tr>
                                    <td>업무용 연락처 :<input name="hp_emp" id="hp_emp" value="${dto.hp_emp}"></td>
                                </tr>
                               	<tr>
                                    <td>이메일 :<input name="email" id="email" value="${dto.email}"></td>
                                </tr>
                                <tr>
                                    <td>자기소개 :<textarea rows="5" cols="80" id="intro" name="intro">${dto.intro}</textarea></td>
                                </tr>
                                <tr>
                                    <td>권한 :<input name="auth" id="auth" value="${dto.auth}"></td>
                               </tr>
                               <tr>
                                    <td>탈퇴여부 :<input name="u_del_yn" id="u_del_yn" value="${dto.u_del_yn}"></td>
                               </tr>
                               <tr>
                                    <td>결제포인트 :<input name="u_point" id="u_point" value="${dto.u_point}"></td>
                               </tr>
                               <tr>
                                    <td>사업자번호 :<input name="emp_num" id="emp_num" value="${dto.emp_num}"></td>
                               </tr>
                               <tr>
                                    <td>결제성공횟수 :<input name="success_count" id="success_count" value="${dto.success_count}"></td>
                               </tr>
                               <c:if test="${dto.auth == 'auth_b' }">
								    <tr>
								        <td>플래너 좋아요 수 :<input name="planner_like" id="planner_like" value="${dto.planner_like}"></td>
								    </tr>
								    <tr>
								        <td>플래너 싫어요 수 :<input name="planner_unlike" id="planner_unlike" value="${dto.planner_unlike}"></td>
								    </tr>
							    </c:if>
								<tr>
                                    <td>계좌번호 :<input name="acount" id="acount" value="${dto.acount}"></td>
                               </tr>
                               <tr>
                                    <td>회원가입일 :<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${dto.create_date}"/></td>
                               </tr>
                               <tr>
                                    <td>회원수정일 :<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${dto.update_date}"/></td>
                                </tr>
	                        </table>
		                    <div style="width:700px; text-align:center;">
								<input type="hidden" name="user_id" value="${dto.user_id}">
								<button style="button" id="btnUpdate">수정</button>
								<button style="button" id="btnDelete">탈퇴</button>
								<button style="button" id="btnDeleteRe">회원복원</button>
							</div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>