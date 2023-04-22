<%--@elvariable id="data" type="com.goott.pj3.plan.dto.PlanDTO"--%>
<%--
  Created by IntelliJ IDEA.
  User: goott4
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


<%--<c:set var = "date_count" value = "${data.end_date - data.start_date}"/>--%>
<%--<c:out value="${date_count}"/>--%>
<p>기간 : </p>
<p>시작날짜 : ${data.start_date}</p>
<p>종료날짜 : ${data.end_date}</p>
<label for="planner">플래너</label>
<input id="planner" type="text" value="${data.user_id}">

<c:if test="${data.user_id == sessionScope.user_id}">
    <button type="button" onclick="location.href='edit/${data.plan_idx}'">수정</button>
    <button data-id="${data.plan_idx}" id="delete">삭제</button>
</c:if>
<button type="button" onclick="kakao()">결제</button>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
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

    function kakao() {
        const IMP = window.IMP;
        IMP.init("imp67107132");
        IMP.request_pay({
            pg: 'kakaopay.{TC0ONETIME}',
            pay_method: 'card',  //생략가
            merchant_uid: 'sun' + new Date().getTime(), //상점에서 생성한 고유 주문번호
            name: $('#title').val(),
            amount: $('#price').val(),
            buyer_name: $('.session').val(),
        }, function (rsp) { // callback 로직
            if (rsp.success) {
                $.ajax({
                    method: "POST",
                    url: "/payment/verify/" + rsp.imp_uid, //결제 고유번호
                }).done(function (data) {
                    if (data.error_msg) {
                        alert(data.error_msg);
                    } else {
                        confirmPayment(rsp.imp_uid, rsp.merchant_uid, rsp.buyer_name, $('.plan_idx').val)
                    }
                }).fail(function (xhr, textStatus, errorThrown) {
                    console.log(xhr, textStatus, errorThrown);
                });
            } else {
                let msg = rsp.error_msg;
                alert("결제실패 : " + msg);
            }
        });
    }

    function confirmPayment(imp_uid, merchant_uid, buyer_name, plan_idx) {
        $.ajax({
            url: '/payment/confirm',
            type: 'POST',
            async: true,
            dataType: "Json",
            data: {
                imp_uid: imp_uid,            // 결제 고유번호
                merchant_uid: merchant_uid,// 주문번호
                user_id: buyer_name,
                plan_idx: plan_idx
            }.done(function () {
                alert("결제성공");
            }).fail(function (error) {
                console.log(error);
            })
        });
    }

</script>
</body>
</html>
