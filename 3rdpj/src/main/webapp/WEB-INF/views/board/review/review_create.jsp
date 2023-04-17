<%--
  Created by IntelliJ IDEA.
  User: goott4
  Date: 2023-04-05
  Time: 오후 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<html>
<head>
    <title>리뷰 작성</title>
    <style>
        #preview {
            max-width: 100%;
            max-height: 400px;
        }
    </style>
</head>
<body>
<h1>리뷰 작성</h1>
<form method="POST" enctype="multipart/form-data" >
    <input type="hidden" name="plan_idx" value="1">
    <p>내용 : <input type="text" name="review_content"></p>
    <p>사진 : <input id="fileItem" name="file" type="file" multiple name="review_img" onchange="previewFile()"></p>
    <p>평점 :
        <input type="radio" name="review_rating" value="1">1
        <input type="radio" name="review_rating" value="2">2
        <input type="radio" name="review_rating" value="3">3
        <input type="radio" name="review_rating" value="4">4
        <input type="radio" name="review_rating" value="5">5
    </p>
    <p><input id="upload-btn" type="submit" value="저장"></p>
</form>
<div id="preview"></div>
</body>
</html>
<script>
    /**
     * 조원재 23.04.13. follow - uploadForm
     */
    function previewFile() {
        var preview = document.getElementById('preview');
        var file = document.getElementById('fileItem').files[0];
        var reader = new FileReader();
        reader.onloadend = function() {
            preview.innerHTML = '<img id="preview-img" src="' + reader.result + '">';
        }
        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.innerHTML = '';
        }
    }
    /**
     * 조원재 23.04.06 이미지 업로드
     * @type {RegExp}
     */
    let regex = new RegExp("(.*?)\.(jpg|png)$");         // jpg,png 파일만 허용
    let maxSize = 41943040;                              // file 제한 용량 40MB

    $("input[type='file']").on("change", function(e){
        let fileInput = document.querySelector("#fileItem");
        let fileList = fileInput.files;
        let fileObj = fileList[0];

        if(!fileCheck(fileObj.name, fileObj.size)) return false;
        alert("통과")
    });

    // 이미지 체크 로직
    function fileCheck(fileName, fileSize){
        if(fileSize >= maxSize){
            alert("파일 사이즈 초과 : 최대 40MB");
            return false;
        }
        if(!regex.test(fileName)){
            alert("해당 종류의 파일은 업로드할 수 없습니다. 업로드 가능한 file : jpg, png");
            return false;
        }
    }




</script>
