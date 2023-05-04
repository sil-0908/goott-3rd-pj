<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
</script>
<%--<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>--%>
<head>
    <title>이번달 회원가입 수</title>
</head>
<body>

<div style="width: 900px; height: 900px;">
    <!--차트가 그려질 부분-->
    <canvas id="myChart"></canvas>
</div>
<script type="text/javascript">
    var mylistA = [];
    <c:forEach items="${auth_a}" var="item1">
    mylistA.push("${item1}");
    </c:forEach>
    var mylistB = [];
    <c:forEach items="${auth_b}" var="item2">
    mylistB.push("${item2}");
    </c:forEach>
    var mylistC = [];
    <c:forEach items="${auth_c}" var="item3">
    mylistC.push("${item3}");
    </c:forEach>

    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            datasets: [{
                label: '어드민 회원가입 수',
                data: mylistA,
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            }, {
                label: '플래너 회원가입 수',
                data: mylistB,
                backgroundColor: 'rgba(0,100,255,0.5)',
                borderColor: 'rgba(0,100,255, 1)',
                borderWidth: 1
            }, {
                label: '회원 회원가입 수',
                data: mylistC,
                backgroundColor: 'rgba(89,127,9,0.4)',
                borderColor: 'rgba(89,127,9, 1)',
                borderWidth: 1
            },
            ]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
</script>


</body>
</html>
