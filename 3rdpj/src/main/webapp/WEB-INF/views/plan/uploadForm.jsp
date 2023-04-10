<%--
  Created by IntelliJ IDEA.
  User: Ang
  Date: 2023-04-09
  Time: 오후 11:51
  To change this template use File | Settings | File Templates.
  2023.04.09 길영준 업로드 테스트용 jsp
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Image Upload Form</title>
</head>
<body>
<h1>Image Upload Form</h1>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <div>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" />
    </div>
    <div>
        <label for="file">Choose an image:</label>
        <input type="file" id="file" name="file" accept="image/*" onchange="previewImage()" />
    </div>
    <div>
        <img id="imagePreview" src="#"  style="display: none; max-width: 100%; height: auto;">
    </div>
    <div>
        <button type="submit">Upload</button>
    </div>
</form>
<script>
    function previewImage() {
        let preview = document.getElementById("imagePreview");
        let file = document.getElementById("file").files[0];
        let reader = new FileReader();
        reader.onloadend = function () {
            preview.src = reader.result;
            preview.style.display = "block";
        }
        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.src = "";
            preview.style.display = "none";
        }
    }
</script>
</body>
</html>