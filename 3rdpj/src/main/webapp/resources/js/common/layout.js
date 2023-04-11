/**
 * 
 */
window.addEventListener("load", function () {
  var allElements = document.getElementsByTagName("*");
  console.log("allElements: " + allElements);
  Array.prototype.forEach.call(allElements, function (el) {
    var includePath = el.dataset.includePath;
    console.log(includePath);
    if (includePath) {
      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          el.outerHTML = this.responseText;
        }
      };
      xhttp.open("GET", includePath, true);
      xhttp.send();
    }
  });
});

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
