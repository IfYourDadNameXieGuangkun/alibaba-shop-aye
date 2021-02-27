package com.lppz.stock.platform.meituan.pojo.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lppz.stock.platform.base.BaseResponse;
import lombok.Data;


@Data
public abstract class MeituanResponse implements BaseResponse {
    @JsonProperty(value = "data")
    private String data;
    @JsonProperty(value = "error")
    private String error;
}
