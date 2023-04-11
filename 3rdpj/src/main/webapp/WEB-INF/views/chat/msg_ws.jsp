<%--
  Created by IntelliJ IDEA.
  User: chowonjae
  Date: 2023-04-11
  Time: 오전 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<html>
<head>
    <title>실시간 채팅</title>
</head>
<body>
<!-- 채팅 버튼 -->
<div class="openBtn">
    <button class="socketBtn">입장</button>
</div>
<!-- 채팅 리스트 / 채팅 방 OPEN / CLOSE -->
<script>
    $(document).on("click", ".openBtn", function(){                // 채팅 버튼 클릭 시,
        if($('.chatContainer').hasClass("display-none")){           // if ) 채팅방이 열려있지 않을 때,
            $('.chatListContainer').toggleClass('display-none');    // 리스트를 연다.
        }else{                                                      // else ) 채팅방이 열려있다면,
            $('.chatContainer').toggleClass('display-none');        // 채팅방을 닫는다.
            websocket.close();
        }

        if(!$('.chatListContainer').hasClass('display-none')){         // 채팅 리스트가 닫혀 있을 때
            getRoomList();                                            // 채팅 방 목록을 불러온다.
        }
    });

    $(document).on("click", "img.close", function(){                // X 버튼 클릭 시,
        $('.chatContainer').toggleClass('display-none');           // 채팅방을 닫는다.
        websocket.close();                                            // socket 연결 종료
    });

    $(document).on("click", "img.down", function(){                 // - 버튼 클릭 시,
        $('.chatContainer').toggleClass('display-none');           // 채팅방을 닫고,
        $('.chatListContainer').toggleClass('display-none');       // 리스트를 연다.
        websocket.close();                                            // socket 연결 종료
    });
</script>
<!-- 채팅 창 -->
<div class="chatContainer display-none">
    <div class="chatTop">
        <div class="floatLeft" id="loginOn">
            <img class="profile_img" id="setPic"><!-- src 사진 경로 동적 생성 -->
        </div>
        <div class="name_container font_noto" id="setName"><!-- 이름 동적 생성 --></div>
        <div class="floatRight">
            <img src="resources/img/chat-close.png" class="btnImg close">
        </div>
        <div class="floatRight">
            <img src="resources/img/chat-minus.png" class="btnImg down">
        </div>
    </div>
    <div class="chatMiddle">
        <ul>
            <!-- 동적 생성 -->
        </ul>
    </div>
    <div class="chatBottom">
        <textarea placeholder="메세지를 입력해 주세요."></textarea>
    </div>
</div>

<!-- format -->
<div class="chatMiddle format">
    <ul>
        <li>
            <div class="sender">
                <span></span>
            </div>
            <div class="message">
                <span></span>
            </div>
        </li>
    </ul>
</div>

<!-- 채팅 리스트 -->
<div class="chatListContainer font_jua display-none">
    <div class="chatTop">
        <div style="padding: 10px; margin-left: 4px;">니즈톡 리스트</div>
    </div>
    <div class="chatList">
        <!-- 동적 생성 -->
    </div>
</div>

<h1>실시간 채팅</h1>
  <div id="chatMessages"></div>
      <input type="text" id="sender" placeholder="Sender">
      <input type="text" id="content" placeholder="Message">
      <button onclick="sendChatMessage()">Send</button>
  </div>

<script>
    let websocket;
    window.onload = function (){
        connet();
    }
    // 입장 버튼 클릭 시 호출되는 함수
    function connet(){
        //웹소켓 주소
        var url = "http://localhost:8080/msg-ws";
        //웹소켓 객체 생성
        websocket = new SockJS(url);
        console.log(websocket)
        websocket.onopen = onOpen;
        websocket.onmessage = onMessage;
        websocket.onclose = onClose;
        websocket.onerror = onError;
    }

    // 웹 소켓 열기
    function onOpen(){
        console.log("연결")
    }
    // 메세지 전송
    function sendMessage(message){

    }
    // 메세지 수신
    function onMessage(evt){

    }
    // 웹소켓 종료
    function onClose(){
        console.log("종료")
    }
    // 웹소켓 에러
    function onError(){

    }

    // 메세지 보내기
    // function sendChatMessage(){
    //     ws.onmessage = function (event){
    //         console.log(event.data+'\n');
    //         var sender = document.getElementById('sender').value;
    //         var content = document.getElementById('content').value;
    //         var chatMessage = {
    //             sender: sender,
    //             content: content
    //         };
    //         ws.send(JSON.stringify(chatMessage)); // a
    //     }
    // }

    // 메세지 받기
    // ws.onmessage = function(event) {
    //   var chatMessage = JSON.parse(event.data);
    //   console.log('Received: ' + chatMessage.sender + ' - ' + chatMessage.content);
    //   // 메시지를 화면에 표시하는 로직 구현
    //   var chatMessagesDiv = document.getElementById('chatMessages');
    //   var chatMessageDiv = document.createElement('div');
    //   chatMessageDiv.innerHTML = chatMessage.sender + ': ' + chatMessage.content;
    //   chatMessagesDiv.appendChild(chatMessageDiv);
    // }



</script>

</body>
</html>
