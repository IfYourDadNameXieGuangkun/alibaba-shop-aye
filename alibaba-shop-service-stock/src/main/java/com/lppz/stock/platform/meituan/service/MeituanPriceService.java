package com.lppz.stock.platform.meituan.service;

import com.lppz.stock.platform.base.*;
import com.lppz.stock.platform.meituan.call.CallSkuStock;
import com.lppz.stock.platform.meituan.pojo.common.MeituanResponse;
import com.lppz.stock.platform.meituan.pojo.common.MeituanStockEntry;
import com.lppz.stock.platform.meituan.pojo.request.MeituanStockRequest;
import org.springframework.stereotype.Service;


/**
 * 美团同步库存service
 */
@Service
@ChannelSelector(channel = Channel.MEITUAN,name = "美团库存同步")
public class MeituanPriceService extends CallMethod<MeituanStockRequest,MeituanResponse> implements SynProvider {



    @Override
    public MeituanResponse run(Object obj) {
        PlatformResult<MeituanResponse> meituanResponsePlatformResult = this.doCall(new MeituanStockRequest());
        return null;
    }

    @Override
    public CallPlatform<MeituanResponse> buildCallParams(MeituanStockRequest request) {
        return new CallSkuStock((MeituanStockRequest) request);
    }

}
