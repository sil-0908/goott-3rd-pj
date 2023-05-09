const windowOfDetail = document.querySelector(".modal__detail");
const windowOfTalk = document.querySelector(".modal__talk");
const openModals = document.querySelectorAll(".modal__btn--detail-open");
const closeModal = document.querySelector(".modal__btn--detail-close");
const talkModal = document.querySelector(".modal__btn--talk-open");
const closeTalk = document.querySelector(".modal__btn--talk-close");
const sendMessage = document.querySelector(".chatbox__submit");

const price = $('#price').val(); // 가격
const name = $('#title').val(); //플랜명
const buyer = $('.session').val(); //구매자아이디
const planner = $('#planner').val(); // 플래너아이디
const plan_idx = $('.plan_idx').val(); //플랜 pk


for (const openModal of openModals) {
  openModal.addEventListener("click", function () {
	  var modalId = openModal.dataset.id;
	  console.log(modalId);
	  
	  // 모달창에 데이터 삽입
	  /*fruitName.textContent = name;
	  fruitDescription.textContent = `This is a ${name}.`;*/
	  
	  // 모달창 열기
	  windowOfDetail.open = true;
  });
}

$(function() {
	for(const openModal of openModals){
		let modalId = openModal.dataset.id;
		openModal.addEventListener("click", function() {
			$.ajax({
				type : 'POST',
				url : '/plan/list/'+modalId,
				dataType : 'json',
				success : function(data){ 
					console.log(modalId);
					console.log(data);
		            let planImages=["<section class='modal__window'>", "<ul class='modal__grid'>"]; 
		            data["p_img"].forEach(
		                    image => planImages.push(
		                    		"<li class='thumbnail thumbnail--theme-modal'>" +
		                    		"<img src='"+image+"'/>" +
                    				"<div class='thumbnail__txt--theme-modal'>"+
                    				"<p>day</p>"+
                    				"</div>"+
		                    		"</li>"
                    				)    
		                    //JSON에 있는 member.id의 value를 li태그에 넣어서 array에 넣어줌
		            );
		            planImages.push("</ul>");
		            let planInfo=
	            	"<section class='modal__info'>" +
	            	"<hgroup class='profile'>" +
	            	"<div class='profile__title'>" +
	            	"<h1>"+data["plan_title"]+"</h1>"+
	                "<button class='modal__btn'>"+
	                "<a href='#'>플래너 페이지 바로가기 </a>"+
	                "</button>"+
		              "</div>"+
		              "<p>"+data["plan_detail"]+"</p>"+
		            "</hgroup>"+
		            "<div class='modal__btns--add-day'>"+
		              "<div class='modal__btn modal__btn--color-gray'></div>"+
		              "<div class='modal__btn'></div>"+
		            "</div>"+
		            "<section class='schedule'>"+
		              "<article class='schedule__day'>"+
		                "<div class='schedule__day--img-node'>"+
		                  "<img src='../img/day_node.png' alt='' />"+
		                "</div>"+
		                "<div class='schedule__day--detail'>"+
		                  "<hgroup class='schedule__day--detail-title'>"+
		                    "<h1>DAY</h1>"+
		                  "</hgroup>"+
		                  "<div class='schedule__day--detail-info'>"+
		                    "<div class='schedule__selectboxes'>"+
		                      "<select class='schedule__selectbox' name='' id=''>"+
		                        "<option value=''>셀렉트박스1</option>"+
		                      "</select>"+
		                      "<select class='schedule__selectbox' name='' id=''>"+
		                        "<option value=''>셀렉트박스2</option>"+
		                      "</select>"+
		                      "<select class='schedule__selectbox' name='' id=''>"+
		                        "<option value=''>셀렉트박스3</option>"+
		                      "</select>"+
		                    "</div>"+
		                    "<div class='schedule__textbox'>"+
		                      "<p>플랜 상세</p>"+
		                    "</div>"+
		                  "</div>"+
		                "</div>"+
		              "</article>"+
		            "</section>"+
		            "<div class='modal__btns'>"+
		              "<button class='modal__btn modal__btn--detail-close'>닫기</button>"+
		              "<button class='modal__btn modal__btn--cart-add'>카트담기</button>"+
		              "<button class='modal__btn modal__btn--talk-open'>대화하기</button>"+
		            "</div>"+
		            "</section>"; 
		            $(".modal__detail").html(function(){ 
		            	let planModal=[];
		            	planModal.push(planImages.join(""));
		            	planModal.push(planInfo);
		            	return planModal.join("");
		            });
		            $(".modal__btn--detail-close").click(function(){
		            	$(this).parentsUntil("dialog").parent().prop("open", false);
		            });
		            $(".modal__btn--talk-open").click(function(){
		            	windowOfDetail.close();
	            	    windowOfTalk.open = true;
		            	/*$(this).parentsUntil("dialog").parent().prop("open", true);*/
		            });
		            $(".modal__btn--talk-close").click(function(){
		            	windowOfTalk.close();
		            	/*$(this).parentsUntil("dialog").parent().prop("open", true);*/
		            });
		            $(".modal__btn--cart-add").click(function(){
		            	let cart = {
			                    plan_idx: plan_idx,
			                    user_id: buyer
			                };
			                $.ajax({
			                    type: 'Post',
			                    url: '/addcart',
			                    dataType: 'json',
			                    contentType: 'application/json; charset=utf-8',
			                    data: JSON.stringify(cart),
			                    error: function(xhr, status, error) {
			  	                  console.log(xhr.responseText);
			  	                  console.log(xhr.status);
			  	                  console.log(xhr.statusText);
			                    },
			                	success: function(){
			                		alert("에이쟉스 성공");
			                	} 
			                }).done(function (rsp) {
			                    if (rsp.cart === '카트담기') {
			                        alert('카트담기성공')
			                    } else {
			                        alert('카트담기실패');
			                    }

			                }).fail(function (error) {
			                    alert('에이쟉스 실패')
			                })
		            });
		            },
		            //array의 요소들을 다 합쳐서 하나로 만든후 id="result"인 태그에 html로 출력				
		            
				error: function(xhr, status, error) {
	                  console.log(xhr.responseText);
	                  console.log(xhr.status);
	                  console.log(xhr.statusText);
	            } 
			})
		})
	}
	
})

	
/*window.addEventListener("load", function () {
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
	});*/

// 모달창 닫기 버튼에 이벤트 리스너 추가
closeModal.addEventListener("click", function () {
  // 모달창 닫기
  windowOfDetail.close();
});

talkModal.addEventListener("click", function () {
  windowOfDetail.close();
  windowOfTalk.open = true;
});


