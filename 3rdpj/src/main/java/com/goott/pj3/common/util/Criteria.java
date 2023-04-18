package com.goott.pj3.common.util;

public class Criteria {
    // 게시글 조회 쿼리에 전달괼 파라미터를 담는 클래스 - 04.02 김범수

    private int page; // 현재 페이지 번호
    private int perPageNum; // 한 페이지당 보여줄 게시글의 갯수
    
    private String category, keyword, option; // 04.06 김범수 - 카테고리 분류를 위해 추가

    public int getPageStart() { // 특정 페이지의 게시글 시작 번호(게시글 시작 행 번호)
        return (this.page-1)*perPageNum;
    }

    public Criteria() { // 생성자 설정 - 최초로 게시판 목록에 들어왔을 때의 세팅
        this.page = 1;
        this.perPageNum = 10;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) { // 페이지가 음수값이 되지 않게 설정 -> 음수면 1page
        if(page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }
    public int getPerPageNum() {
        return perPageNum;
    }
    public void setPerPageNum(int pageCount) { // 페이지당 보여줄 게시글 수가 변하지 않게 하기 위함
        // 만약 8페이지 밖에 없으면 1~8페이지까지만 출력되기 위함
        int cnt = this.perPageNum;
        if(pageCount != cnt) {
            this.perPageNum = cnt;
        } else {
            this.perPageNum = pageCount;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // 검색기능 구현 - 04.07 김범수
    public String getKeyword() {
        if(keyword != null || keyword !=""){
            return this.keyword;
        }
        return "";
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "page=" + page +
                ", perPageNum=" + perPageNum +
                ", category='" + category + '\'' +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
}
