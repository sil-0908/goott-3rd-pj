<%--
  Created by IntelliJ IDEA.
  User: Ang
  Date: 2023-04-09
  Time: 오후 11:51
  To change this template use File | Settings | File Templates.
  2023.04.09 길영준 업로드 테스트용 jsp
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>File Upload Example</title>
    <style>
        #preview {
            max-width: 100%;
            max-height: 400px;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1>File Upload Example</h1>
<form id="upload-form" action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file" id="file-input" onchange="previewFile()">
    <br><br>
    <button type="submit" id="upload-btn" disabled>Upload</button>
</form>
<div id="preview"></div>
<script>
    function previewFile() {
        var preview = document.getElementById('preview');
        var file = document.getElementById('file-input').files[0];
        var reader = new FileReader();
        reader.onloadend = function() {
            preview.innerHTML = '<img id="preview-img" src="' + reader.result + '">';
            $('#upload-btn').prop('disabled', false);
        }
        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.innerHTML = '';
            $('#upload-btn').prop('disabled', true);
        }
    }
    // $('#fileUploadForm').submit(function (e) {
    //     e.preventDefault();
    //     $.ajax({
    //         url: "/upload",
    //         type: "POST",
    //         data: new FormData(this),
    //         contentType: false,
    //         cache: false,
    //         processData: false,
    //         success: function (response) {
    //             $('#imagePreview').attr('src', response);
    //         },
    //         error: function () {
    //             alert('Error uploading file');
    //         }
    //     });
    // });
</script>
</body>
</html>