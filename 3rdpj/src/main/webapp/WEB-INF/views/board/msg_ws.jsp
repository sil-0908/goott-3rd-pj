<%--
  Created by IntelliJ IDEA.
  User: chowonjae
  Date: 2023-04-11
  Time: 오전 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div class="msg_item">
    <input type="text" id="msg" value="1212" class="form-control" />
    <button id="btnSend" class="">Send Message</button>

  </div>

<script>
  var socket = null;
  function connect() {
    var ws = new WebSocket("ws://localhost:8080/sun_tour?diehreo=021548"); // ws : 브라우저가 지원
    socket = ws;

    ws.onopen = function (){
      console.log('Info : connetion opened.');
      setTimeout(function (){connet();},1000); // retry connetion!
    }

    ws.onmessage = function (event){
      console.log(event.data+'\n');
    }

    ws.onclose = function (event) {
      console.log('Info : connection closed.');
      // setTimeout(function (){connet();},1000); // 연결 끊어지면 1초 마다 다시 커넥션
    }
    ws.onerror = function (event){
      console.log('Error', err);
    }
  }

  $('#btnSend').on('click', function (evt){
    evt.preventDefault();
    if(socket.readyState !== 1) return;
    let msg = $('input#msg').val();
    ws.send(msg);
  })
  connect();
</script>

</body>
</html>
