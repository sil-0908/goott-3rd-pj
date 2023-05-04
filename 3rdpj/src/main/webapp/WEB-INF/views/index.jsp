<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
    <link rel="stylesheet" href="/resources/css/style.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>Sun Tour</title>
</head>
<jsp:include page="/WEB-INF/views/common/layout.jsp"/>
<script src="/resources/js/common/layout.js"></script>
<main class="index">
    <section class="con">
        <ul class="carousel carousel--theme-full">
            <li id="firstClone" class="carousel__box carousel__box--theme-full">
                <img class="carousel__img-full" src="/resources/img/gunchim1.jpg" alt=""/>
            </li>
            <li class="carousel__box carousel__box--theme-full">
                <img class="carousel__img-full" src="/resources/img/gunchim2.jpg" alt=""/>
            </li>
            <li id="lastClone" class="carousel__box carousel__box--theme-full">
                <img class="carousel__img-full" src="/resources/img/gunchim3.jpg" alt=""/>
            </li>
        </ul>
        <button class="btn btn--theme-full prev">
            <i class="fa-solid fa-chevron-left"></i>
        </button>
        <button class="btn btn--theme-full next">
            <i class="fa-solid fa-chevron-right"></i>
        </button>
    </section>
    <section class="con">
        <ul class="carousel carousel--theme-div2">
            <a href="./search.html" class="carousel__box carousel__box--theme-div2">
                <img class="carousel__img-div2" src="/resources/img/gunchim1.jpg" alt=""/>
            </a>
            <a href="./search.html" class="carousel__box carousel__box--theme-div2">
                <img class="carousel__img-div2" src="/resources/img/gunchim2.jpg" alt=""/>
            </a>
            <a href="./search.html" class="carousel__box carousel__box--theme-div2">
                <img class="carousel__img-div2" src="/resources/img/gunchim3.jpg" alt=""/>
            </a>
            <a href="./search.html" class="carousel__box carousel__box--theme-div2">
                <img class="carousel__img-div2" src="/resources/img/gunchim1.jpg" alt=""/>
            </a>
            <a href="./search.html" class="carousel__box carousel__box--theme-div2">
                <img class="carousel__img-div2" src="/resources/img/gunchim2.jpg" alt=""/>
            </a>
            <a href="./search.html" class="carousel__box carousel__box--theme-div2">
                <img class="carousel__img-div2" src="/resources/img/gunchim3.jpg" alt=""/>
            </a>
        </ul>
        <button class="btn btn--theme-div2 prev">
            <i class="fa-solid fa-chevron-left"></i>
        </button>
        <button class="btn btn--theme-div2 next">
            <i class="fa-solid fa-chevron-right"></i>
        </button>
    </section>
</main>
<script src="/resources/js/common/main.js"></script>
<script src="https://kit.fontawesome.com/7723a79ab5.js" crossorigin="anonymous">
</script>
</body>
</html>