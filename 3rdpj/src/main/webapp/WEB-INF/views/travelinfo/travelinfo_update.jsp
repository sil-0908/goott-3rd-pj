<%--
  Created by IntelliJ IDEA.
  User: chowonjae
  Date: 2023-04-06
  Time: 오전 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<html>
<head>
    <title>여행지 정보 수정</title>
</head>
<body>
<h1>여행지 정보 작성</h1>
<p>기존 이미지 : <img src="${data.country_img}" height="200px" width="200px" style="border: 1px solid red;"></p>
<form method="POST" onsubmit="travelAdress();">
    <p>여행지 이름 : <input type="text" name="country_c" value="${data.country_c}"></p>
    <p>국가 : <input type="text" name="country_a" value="${data.country_b}"></p>
    <p>지역 : <input type="text" name="country_b" value="${data.country_a}"></p>
    <p>내용 : <input type="text" name="country_detail" value="${data.country_detail}"></p>
    <p>기존 여행지 주소 : ${data.country_script}</p>
    <div id="travel_adress">
        <p> 변경할 여행지 주소 :
            <input id="total_adress" type="hidden" name="country_script" value="">
            <input type="text" id="travel_postcode" class="address_item" placeholder="우편번호">
            <input type="button" onclick="travelPostcode()" value="우편번호 찾기" class="d_btn"><br>
            <input type="text" id="travel_roadAddress" class="address_item" placeholder="도로명주소">
            <input type="text" id="travel_jibunAddress" class="address_item" placeholder="지번주소">
            <span id="guide" style="color:#999;display:none"></span>
            <input type="text" id="travel_detailAddress" class="address_item" placeholder="상세주소">
            <input type="text" id="travel_extraAddress" class="address_item" placeholder="참고항목">
        </p>
    </div>
    <p>변경할 이미지 : <input type="file" multiple name="country_img" value="${data.country_img}"></p> </p>
    <input type="submit" value="저장">
</form>
</body>
</html>

<script>
    /**
     * 조원재 23.04.09. 여행지 주소 값 더하는 로직
     * @type {NodeListOf<Element>}
     */
    let addressItem = document.querySelectorAll(".address_item");
    let total_adress = document.querySelector("#total_adress");

    function travelAdress(){
        for(item of addressItem){
            total_adress.value += item.value+" ";
        }
    }
    /**
     * 조원재 23.04.07.카카오 우편 번호 API
     */
    function travelPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 추가 정보 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('travel_postcode').value = data.zonecode;
                document.getElementById("travel_roadAddress").value = roadAddr;
                document.getElementById("travel_jibunAddress").value = data.jibunAddress;

                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("travel_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("travel_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>