const windowOfDetail = document.querySelector(".modal__detail");
const windowOfTalk = document.querySelector(".modal__talk");
const openModals = document.querySelectorAll(".modal__btn--detail-open");
const closeModal = document.querySelector(".modal__btn--detail-close");
const talkModal = document.querySelector(".modal__btn--talk-open");
const closeTalk = document.querySelector(".modal__btn--talk-close");
const sendMessage = document.querySelector(".chatbox__submit"); 
// const openPaymentPage = document.querySelector(".modal__btn--pay-open");

for (const openModal of openModals) {
  openModal.addEventListener("click", function () {
    // 모달창 열기
    windowOfDetail.open = true;
  });
}

// 모달창 닫기 버튼에 이벤트 리스너 추가
closeModal.addEventListener("click", function () {
  // 모달창 닫기
  windowOfDetail.close();
});

talkModal.addEventListener("click", function () {
  windowOfDetail.close();
  windowOfTalk.open = true;
});

closeTalk.addEventListener("click", function () {
  windowOfTalk.close();
});

// 메세지 보내기
// sendMessage.addEventListener("click", function(){

// })

// openPaymentPage.addEventListener("click", function () {

// });
