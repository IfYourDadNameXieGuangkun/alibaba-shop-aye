package com.aye.commons.dto;

import java.io.Serializable;


public class QueryParams implements Serializable {

    /**
     * 当前页
     */
    protected int page;

    /**
     * 页大小
     */
    protected int size;

    /**
     * 偏移量
     */
    protected Integer offset;


    public boolean hasSize() {
        return size > 0;
    }

    public boolean hasPage() {
        return page > 0;
    }
    
    public int getOffset() {
        return getSize() * (getPage() - 1);
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPage() {
        return Math.max(1, page);
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return Math.min(Math.max(1, this.size), 20);
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
