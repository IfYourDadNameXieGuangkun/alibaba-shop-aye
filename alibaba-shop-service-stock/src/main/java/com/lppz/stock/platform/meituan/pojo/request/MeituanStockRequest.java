package com.lppz.stock.platform.meituan.pojo.request;

import com.lppz.stock.platform.meituan.pojo.common.MeituanRequest;
import lombok.Data;

import java.util.Random;

@Data
public class MeituanStockRequest extends MeituanRequest {
    private String app_poi_code;

    private String food_data;

    @Override
    public String getMethodUrl() {
        return null;
    }

    @Override
    public String getRequestId() {
        //TODO 需要特殊处理成唯一请求ID
        return new Random().nextInt()+"";
    }
}
