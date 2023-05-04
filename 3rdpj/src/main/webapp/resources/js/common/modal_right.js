
const qnaGuideModal = document.querySelector(".guide");
const closeBtnQnaGuide = document.querySelector(".guide__btn-close");

window.addEventListener("load", function () {
  qnaGuideModal.open = true;
});

closeBtnQnaGuide.addEventListener("click", () => {
  qnaGuideModal.close();
}); 