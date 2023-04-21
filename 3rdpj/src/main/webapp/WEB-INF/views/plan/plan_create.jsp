<%--
  Created by IntelliJ IDEA.
  User: goott4
  Date: 2023-04-05
  Time: 오전 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<form name="create" method="POST" action="/plan/create" enctype="multipart/form-data">
    <label for="title">제목<input id="title" type="text" name="plan_title"></label>
    <br>
    <label for="start_date">여행시작날짜</label>
    <input type="date" id="start_date" name="start_date">
    <br>
    <label for="finish_date">여행종료날짜</label>
    <input type="date" id="finish_date" name="end_date">
    <br>
    <label for="price">가격</label>
    <input type="number" id="price" name="price">
    <br>
    <label for="plan_detail">내용</label>
    <textarea id="plan_detail" name="plan_detail"></textarea>
    <input type="file" name="files[]" id="file-input"  multiple/>
    <button type="submit" id="upload-btn" >Upload</button>
</form>
<div id="preview"></div>
<script>
    // function previewFile() {
    //     let preview = document.getElementById('preview');
    //     let file = document.getElementById('file-input').files[0];
    //     let reader = new FileReader();
    //     reader.onloadend = function () {
    //         preview.innerHTML = '<img id="preview-img" src="' + reader.result + '">';
    //         $('#upload-btn').prop('disabled', false);
    //     }
    //     if (file) {
    //         reader.readAsDataURL(file);
    //     } else {
    //         preview.innerHTML = '';
    //         $('#upload-btn').prop('disabled', true);
    //     }
    // }
</script>


</body>
</html>
