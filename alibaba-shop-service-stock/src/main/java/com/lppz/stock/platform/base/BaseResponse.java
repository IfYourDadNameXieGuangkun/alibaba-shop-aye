package com.lppz.stock.platform.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public interface BaseResponse extends Serializable {
	@JsonIgnore
	public Object getBizData();
}
