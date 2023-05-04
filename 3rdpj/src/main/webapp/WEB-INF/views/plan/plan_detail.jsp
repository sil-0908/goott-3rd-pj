<%--@elvariable id="data" type="com.goott.pj3.plan.dto.PlanDTO"--%>
<%--
  Created by IntelliJ IDEA.
  User: 길영준
  Date: 2023-04-05
  Time: 오후 7:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <title></title>
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
    <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
<input class="session" type="hidden" value="${sessionScope.user_id}">
<input class="plan_idx" type="hidden" value="${data.plan_idx}">

<label for="title">제목</label>
<input id="title" type="text" value="${data.plan_title}">

<label for="price">가격</label>
<input id="price" type="text" value="${data.price}">

<label for="detail">설명</label>
<input id="detail" type="text" value="${data.plan_detail}">

<p> 이미지: </p>
<c:forEach var="img" items="${data.p_img}">
    <img src="${img}" width="200" height="200" style="border: 1px solid blue;">
</c:forEach>

<%--<c:set var = "date_count" value = "${data.end_date - data.start_date}"/>--%>
<%--<c:out value="${date_count}"/>--%>

<p>기간 : </p>
<p>시작날짜 : ${data.start_date}</p>
<p>종료날짜 : ${data.end_date}</p>
<label for="planner">플래너</label>
<input id="planner" type="text" value="${data.user_id}">

<c:if test="${data.user_id == sessionScope.user_id}">
    <button type="button" onclick="location.href='edit?idx=${data.plan_idx}&auth=${data.user_id}'">수정</button>
    <button data-id="${data.plan_idx}" id="delete">삭제</button>
</c:if>
<button id="cart" type="button" onclick="addCart()">카트담기</button>
<button type="button" onclick="kakao()">결제</button>

<script>
    // 삭제기능 버튼
    $('#delete').click(function (e) {
        let number = e.target.dataset.id;
        $.ajax({
            method: 'POST',
            url: '/plan/list/delete',
            data: {plan_idx: number}
        }).done(function (result) {
            alert('요청 성공')
            window.location.href = "/plan/list";
        }).fail(function (xhr, textStatus, errorThrown) {
            console.log(xhr, textStatus, errorThrown);  // 실패시 실행할 코드
        });
    });

    // 2023.04.23 길영준
    // 카카오페이 결제
    const price = $('#price').val(); // 가격
    const name = $('#title').val(); //플랜명
    const buyer = $('.session').val(); //구매자아이디
    const planner = $('#planner').val(); // 플래너아이디
    const plan_idx = $('.plan_idx').val(); //플랜 pk
    // 아임포트 결제 함수
    function kakao() {
        let IMP = window.IMP;
        IMP.init('imp67107132');
        IMP.request_pay({
            pg: 'kakaopay.TC0ONETIME',
            merchant_uid: 'suntour_' + new Date().getTime(), //상점에서 생성한 고유 주문번호
            name: name, // 상품명
            amount: price, // 가격
            buyer_name: buyer // 구매자
        }, function (rsp) { // 검증 로직
            $.ajax({
                type: 'POST',
                url: '/verifyIamport/' + rsp.imp_uid
            }).done(function (result) {
                if (rsp.paid_amount === result.response.amount) {
                    let info = {
                        imp_uid: rsp.imp_uid,
                        merchant_uid: rsp.merchant_uid,
                        buyer_id: buyer,
                        planner_id: planner,
                        plan_idx: plan_idx
                    }
                    $.ajax({//결제 검증 ajax
                        type: 'POST',
                        data: JSON.stringify(info),
                        url: '/payment/confirm',
                        dataType: "json",
                        contentType: 'application/json; charset=utf-8',
                        success: function (result) {
                            alert(result.msg)
                            window.location.reload();
                        },
                        error: function (xhr, status, error) {
                            alert(result.msg)
                            console.log(xhr)
                            console.log(status)
                            console.log(error)
                        }
                    })
                } else {
                    alert("결제실패" + "에러 : " + rsp.error_code + "에러내용: " + rsp.error_msg);
                }
            })

        });
    }

    //2023.04.25 카트담기
    function addCart() {
        let cart = {
            plan_idx: plan_idx,
            user_id: buyer
        };
        $.ajax({
            type: 'Post',
            url: '/addcart',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(cart)
        }).done(function (rsp) {
            if (rsp.cart === '카트담기') {
                alert('카트담기성공')
            } else {
                alert('카트담기실패');
            }

        }).fail(function (error) {
            alert('에이쟉스 실패')
        })
    }


</script>
</body>
</html>
