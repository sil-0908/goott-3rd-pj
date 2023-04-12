/**
 * 
 */
const qnaGuideModal = document.querySelector(".qna__guide");
const closeBtnQnaGuide = document.querySelector(".qna__guide--btn-close");

window.addEventListener("load", function () {
  qnaGuideModal.open = true;
});

closeBtnQnaGuide.addEventListener("click", () => {
  qnaGuideModal.close();
});