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
