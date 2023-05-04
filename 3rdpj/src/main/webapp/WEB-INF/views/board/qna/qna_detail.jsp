<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/WEB-INF/views/common/layout.jsp" %> 
<main class="detail">
  <section class="detail__document">
    <div class="btns__box">
      <button class="btn btn__normal" onclick="list()">게시글 목록</button>
      <button class="btn btn__normal" id="modify">게시글 수정</button>
      <button class="btn btn__normal" id="delete">게시글 삭제</button>
    </div>
    <hgroup class="detail__title">
      <ul class="title__box">
        <li class="title__component">
          <span>글번호: </span>
          <span id="qna_id">${data.qna_idx}</span>
        </li>
        <li class="title__component">
          <span>제목: </span>
          <span id="qna_title">${data.qna_title}</span>
        </li>
        <li class="title__component">
          <span>작성자: </span>
          <span>${data.user_id}</span>
        </li>
        <li class="title__component">
          <span>등록일: </span>
          <span
            ><fmt:formatDate pattern="yyyy/MM/dd" value="${data.create_date}"
          /></span>
        </li>
      </ul>
    </hgroup>
    <article class="detail__content">
      <p class="content__txt">${data.qna_content}</p>
    </article>
  </section>
  <section class="detail__document--review">
    <article class="review__write">
      <hgroup class="review__write--title">
        <h1>댓글 작성</h1>
      </hgroup>
      <div class="write__box">
        <form class="write__form" action="">
          <input
            placeholder="댓글을 작성하려면 로그인이 필요합니다."
            type="text"
          />
          <button class="btn btn__normal">등록하기</button>
        </form>
      </div>
    </article>
    <article class="review__list">
      <hgroup class="list__title">
        <h1>댓글 목록</h1>
      </hgroup>
      <ul class="list__box">
        <li class="list__component">
          <hgroup class="review__info">
            <span>글번호</span>
            <span>등록일</span>
          </hgroup>
          <div class="review__txt">
            <p>내용</p>
          </div>
        </li>
      </ul>
    </article>
  </section>
</main>
<script src="/resources/js/common/layout.js"></script>

<input type="hidden" id="category" value="${data.category}" />
<script>
  $(function () {
    $("#modify").click(function () {
      const qna_title = document.querySelector("input[name=qna_title]").value;
      const qna_content = document.querySelector(
        "textarea[name=qna_content]"
      ).value;
      const qna_idx = document.querySelector("#qna_id").value;
      alert("test");
      $.ajax({
        url: "/qna/modify",
        data: {
          qna_idx: qna_idx,
          qna_title: qna_title,
          qna_content: qna_content,
        },
        type: "post",
        dataType: "text",
        success: function (data) {
          if (data == "N") {
            alert("게시글이 수정되었습니다.");
            location.href = "/qna/list_N";
          } else if (data == "Q") {
            alert("게시글이 수정되었습니다.");
            location.href = "/qna/list_Q";
          } else if (data == "R") {
            alert("게시글이 수정되었습니다.");
            location.href = "/qna/list_R";
          } else {
            alert("게시글이 수정되었습니다.");
            location.href = "/qna/list_U";
          }
        },
      });
    });

    $("#delete").click(function () {
      const qna_idx = document.querySelector("#qna_id").value;
      $.ajax({
        url: "/qna/delete",
        data: { qna_idx: qna_idx },
        type: "post",
        dataType: "text",
        success: function (data) {
          if (data == "N") {
            alert("게시글이 삭제되었습니다.");
            location.href = "/qna/list_N";
          } else if (data == "Q") {
            alert("게시글이 삭제되었습니다.");
            location.href = "/qna/list_Q";
          } else if (data == "R") {
            alert("게시글이 삭제되었습니다.");
            location.href = "/qna/list_R";
          } else {
            alert("게시글이 삭제되었습니다.");
            location.href = "/qna/list_U";
          }
        },
      });
    });
  });

  function list() {
    const category = document.querySelector("#category").value;
    console.log(category);
    if (category == "N".toString()) {
      location.href = "/qna/list_N";
    } else if (category == "Q".toString()) {
      location.href = "/qna/list_Q";
    } else if (category == "R".toString()) {
      location.href = "/qna/list_R";
    } else {
      location.href = "/qna/list_U";
    }
  }

  $(document).ready(function () {
    getList();
  });

  function getList() {
    var qna_idx = $("input[name=qna_idx]").val();
    var user_id = $("input[name=r_writer]").val();
    var auth = $("input[name=auth]").val();
    $.ajax({
      type: "GET",
      url: "/qnaReply/getList",
      data: { qna_idx: qna_idx },
      success: function (result) {
        for (var i = 0; i < result.length; i++) {
          var str = "<div class='replyarea'>";
          str += result[i].r_writer + "&nbsp;:&nbsp;";
          if (user_id == result[i].r_writer) {
            str +=
              "<input type='text' name='r_content' value=" +
              result[i].r_content +
              " >";
          } else {
            str +=
              "<input type='text' name='r_content' value=" +
              result[i].r_content +
              " readonly>";
          }
          str += "&nbsp;&nbsp;";
          if (auth == "auth_a") {
            str += "<button onclick = 'r_edit()'>수정</button>";
            str += "&nbsp;<button onclick = 'r_delete()'>삭제</button>";
          }
          str +=
            "<input type='hidden' name='reply_idx' value=" +
            result[i].reply_idx +
            ">";
          str += "</div><hr>";
          $("#reply").append(str);
        }
      },
      error: function () {
        alert("에러");
      },
    });
  }

  function r_edit() {
    var qna_idx = $("input[name=qna_idx]").val();
    var reply_idx =
      document.querySelector(".replyarea").children.reply_idx.value;
    var r_content = document.querySelector(".replyarea").children[0].value;

    $.ajax({
      url: "/qnaReply/update",
      data: { qna_idx: qna_idx, reply_idx: reply_idx, r_content: r_content },
      type: "post",
      success: function () {
        alert("댓글이 수정되었습니다");
        location.href = "/qna/detail/" + qna_idx;
      },
    });
  }

  function r_delete() {
    var qna_idx = $("input[name=qna_idx]").val();
    var reply_idx =
      document.querySelector(".replyarea").children.reply_idx.value;

    $.ajax({
      url: "/qnaReply/delete",
      data: { qna_idx: qna_idx, reply_idx: reply_idx },
      type: "post",
      success: function () {
        alert("댓글이 삭제되었습니다");
        location.href = "/qna/detail/" + qna_idx;
      },
    });
  }
</script>
