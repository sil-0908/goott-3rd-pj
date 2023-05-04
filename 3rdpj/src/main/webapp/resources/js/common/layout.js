/** 
 * 
 */

window.addEventListener("scroll", function () {
  var scrollTop = document.documentElement.scrollTop;
  var scrollHeight = document.documentElement.scrollHeight;
  var clientHeight = document.documentElement.clientHeight;

  if (scrollTop + clientHeight >= scrollHeight) {
    document.querySelector("footer").classList.add("show");
  } else {
    document.querySelector("footer").classList.remove("show");
  }
});
window.addEventListener("scroll", function () {
  var header = document.querySelector(".header");
  header.classList.toggle("visible", window.scrollY > 0);
});

//로그아웃 - 장민실 23.04.21
$(".sign_out").on('click', function(){
	location.href = "/user/sign_out";
});

//마이페이지 - 장민실 23.05.04
$(".my_page").on('click', function() {
	var auth = $(".user_auth_input").val();
	if(auth==="auth_c") {
		location.href = "/user/userpage";
	}
	else if(auth==="auth_b") {
		location.href = "/user/plannerpage"
	}
});