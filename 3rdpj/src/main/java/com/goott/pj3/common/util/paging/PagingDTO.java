package com.goott.pj3.common.util.paging;

public class PagingDTO { // - 04.02 김범수
    private Criteria cri; // Criteria 인스턴스 형성 -> 게시글 시작 번호 등을 구하기 위함
    private int totalCount; // 총 게시글의 갯수
    private int startPage; // 시작
    private int endPage; // 끝
    private boolean prev; // 이전 버튼이 출력 true / 출력x false
    private boolean next; // 다음 버튼이 출력 true / 출력x false
    private int displayPageNum = 5; // 사용자에게 보여질 페이지 갯수

    public Criteria getCri() {
        return cri;
    }

    public void setCri(Criteria cri) {
        this.cri = cri;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData(); // totalcount로 계산
    }

    private void calcData() { // 페이징 관련 계산

        endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
        //끝 페이지 번호 = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수

        startPage = (endPage - displayPageNum) + 1;
        if(startPage <= 0) startPage = 1;
        //시작 페이지 번호 = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 갯수) + 1, 만약 시작페이지가 음수일 경우 1로 대체
        //  끝 페이지 번호(10) 페이지 번호의 갯수(5) -> 계산식(10-5)+1 -> 6페이지 시작


        //마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의 갯수
        int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }

        // 버튼 생성 여부
        prev = startPage == 1 ? false : true; // 1일경우 버튼 x
        next = endPage * cri.getPerPageNum() < totalCount ? true : false;
        // 끝 페이지 번호 * 페이지당 게시글 수 < 총 게시글 수 -> 총게시글이 많으면 생성 / 적으면 x

    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }

    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }

    @Override
    public String toString() {
        return "PagingDTO{" +
                ", cri=" + cri +
                ", totalCount=" + totalCount +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                ", displayPageNum=" + displayPageNum +
                '}';
    }
}
