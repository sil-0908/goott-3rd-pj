<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<dialog class="guide">
  <hgroup class="guide__title">
    <h1>도움이 더 필요하신가요?</h1>
  </hgroup>
  <article class="guide__list">
    <a href="">- 이용가이드 바로가기</a><br />
    <a href="/qna/create">- Q&A 문의글 작성</a><br /> 
    <a href="/free/create">- 자유 게시판 글 작성</a>
  </article>
  <button class="guide__btn-close">
    <i class="fa-solid fa-xmark"></i>
  </button>
</dialog>