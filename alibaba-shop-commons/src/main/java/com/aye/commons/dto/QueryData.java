package com.aye.commons.dto;




import java.io.Serializable;
import java.util.List;


public class QueryData<T> implements Serializable {

    /**
     * 总页数
     */
    private Integer totalRow;

    /**
     * 当前页码
     */
    private Integer pageNo;

    /**
     * 页大小
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 是否有下一页
     */
    private boolean hasNextPage;

    /**
     * 是否有上一页
     */
    private boolean hasPrePage;

    /**
     * 是否是第一页
     */
    private boolean firstPage;


    /**
     * 是否是最后一页
     */
    private Boolean lastPage;

    /**
     * 记录数
     */
    private List<T> records;


    /**
     * 当前返回的集合数大小
     */
    private Integer currentRecordSize;

    public Integer getCurrentRecordSize() {
        return currentRecordSize;
    }

    public void setCurrentRecordSize(Integer currentRecordSize) {
        this.currentRecordSize = currentRecordSize;
    }

    /**
     * 查询参数
     */
    private QueryParams queryParams;


    public QueryParams getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(QueryParams queryParams) {
        this.queryParams = queryParams;
    }

    public QueryData(QueryParams queryParams, Integer totalRow, List<T> records) {
        this.totalRow = totalRow;
        this.pageNo = queryParams.getPage();
        this.pageSize = queryParams.getSize();
        this.records = records;
        this.queryParams = queryParams;
        this.firstPage = getPageNo() == 1;
        this.lastPage = getTotalPage().equals(getPageNo());
        this.hasPrePage = getPageNo() > 1;
        this.hasNextPage = getPageNo() < getTotalPage();
        this.currentRecordSize = records.isEmpty() ? 0 : records.size();
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Integer getTotalPage() {
        return getTotalRow()%getPageSize() == 0 ? (getTotalRow()/getPageSize()) : (getTotalRow()/getPageSize())+1;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public Boolean getLastPage() {
        return lastPage;
    }

    public void setLastPage(Boolean lastPage) {
        this.lastPage = lastPage;
    }
}
