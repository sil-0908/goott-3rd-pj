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
    <p>내용 : <input type="text" name="review_content"></p>
    <p>사진 : <input id="fileItem" type="file" name="file[]" onchange="previewFile()" multiple ></p>
    <p>평점 :
        <input type="radio" name="review_rating" value="1">1
        <input type="radio" name="review_rating" value="2">2
        <input type="radio" name="review_rating" value="3">3
        <input type="radio" name="review_rating" value="4">4
        <input type="radio" name="review_rating" value="5">5
    </p>
    <p> <input id="upload-btn" type="submit" value="저장" disabled="true"><span>사진 올려야 작성 가능</span></p>
</form>
<div id="preview"></div>
</body>
</html>
<script>
    /**
     * 조원재 23.04.22 이미지 미리보기
     * @returns {Promise<void>}
     */
    async function previewFile() {
        var preview = document.getElementById("preview"); // 미리보기 띄울 div
        var files = document.getElementById('fileItem').files; // img 파일들
        var cnt = 0; // 이미지 갯수
        preview.innerHTML = ''; // 미리보기 초기화

        for (const file of files) {  // 반복문 한번 반복 때마다 이미지 1개씩 view
            await new Promise((resolve, reject) => {
                var reader = new FileReader(); // FileReader 객체를 생성
                reader.onload = function() { // 파일 로드가 성공시 호출 될 함수
                    var img = document.createElement("img"); // img 생성
                    img.src = reader.result; // 로드된 파일을 img 요소의 src에 할당
                    img.onload = () => { // 이미지 로드가 완료되면 이 함수가 호출
                        preview.appendChild(img); // preview 요소의 자식 노드로 img 추가
                        resolve(); // 결과 호출
                        cnt++ // 이미지 갯수 더하기
                        if(cnt == files.length){
                            $('#upload-btn').prop('disabled', false); // 이미지 파일 올리면 저장버튼 활성화
                        }
                        else if(cnt != files.length){
                            $('#upload-btn').prop('disabled', true); // 이미지 파일 취소 할 경우 다시 비활성화
                        }
                    }
                };
                reader.onerror = function() {
                    reject(new Error('파일 로드 실패'));
                };
                reader.readAsDataURL(file);
            });
        }
    }
    /**
     * 조원재 23.04.06 이미지 업로드 조건
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
