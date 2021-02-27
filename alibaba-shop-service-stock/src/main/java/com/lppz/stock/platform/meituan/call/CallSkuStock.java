package com.lppz.stock.platform.meituan.call;

import com.lppz.stock.platform.base.PlatformResult;
import com.lppz.stock.platform.meituan.pojo.common.MeituanCall;
import com.lppz.stock.platform.meituan.pojo.common.MeituanRequest;
import com.lppz.stock.platform.meituan.pojo.common.MeituanResponse;


public class CallSkuStock extends MeituanCall<MeituanResponse> {

    public CallSkuStock(MeituanRequest request) {
        super(request);
    }

    @Override
    public PlatformResult<MeituanResponse> parseResult(String body) {
        return null;
    }
}
