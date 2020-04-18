package com.labinvent.task.serivice.dto;

public class SearchParameters {

    private int page = 0;

    private int pageSize = 10;

    private String text;

    public int getPage() {
        return page;
    }

    public SearchParameters setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public SearchParameters setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getText() {
        return text;
    }

    public SearchParameters setText(String text) {
        this.text = text;
        return this;
    }
}
