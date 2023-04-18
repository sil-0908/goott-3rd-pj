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

<h1>실시간 채팅</h1>
  <div id="chat"></div>
    <div>
      <div class="text"></div>
    </div>
      <input type="text" id="msg" value="1212">
      <button class="sendBtn">Send</button>
  </div>

<script>
    // 메세지 send
    let sendBtn = document.querySelector(".sendBtn");

    sendBtn.addEventListener("click", function (evt){
        evt.preventDefault();
        if(socket.readyState !== 1) return;
        let msg = document.querySelector('input[id="msg"]').value;
        socket.send(msg);

    })

    // 소켓 연결
    let websocket;
    var socket=null

    window.onload = function (){
        connet();
    }
    // 입장 버튼 클릭 시 호출되는 함수
    function connet(){
        //웹소켓 주소
        var url = "http://localhost:8080/msg-ws";
        //웹소켓 객체 생성
        websocket = new SockJS(url);
        socket = websocket;

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
      document.querySelector(".text").innerText += evt.data + "\n"
        console.log("ReceiveMessage : " + evt.data+'\n');
    }
    // 웹소켓 종료
    function onClose(){
        console.log("종료")
    }
    // 웹소켓 에러
    function onError(){
        console.error("Error : " + err);
    }

</script>

</body>
</html>
