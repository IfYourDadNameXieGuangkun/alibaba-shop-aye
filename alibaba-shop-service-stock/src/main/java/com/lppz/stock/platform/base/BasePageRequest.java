package com.lppz.stock.platform.base;

public interface BasePageRequest extends BaseRequest {
	public void setPageInfo(int pageNo, int pageSize);
}
