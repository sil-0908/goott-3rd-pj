// 아이디 찾기 - 장민실 23.04.19
$("#find_id").on('click', function() {
		document.find_id.action="/user/find_id";
		document.find_id.submit();
});

// 비밀번호 찾기 - 장민실 23.04.19
$("#find_pw").on('click', function() {
		document.find_pw.action="/user/find_pw";
		document.find_pw.submit();
});