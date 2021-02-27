package com.lppz.stock.platform.meituan.service;

import com.lppz.stock.platform.base.*;
import com.lppz.stock.platform.meituan.call.CallSkuStock;
import com.lppz.stock.platform.meituan.pojo.common.MeituanResponse;
import com.lppz.stock.platform.meituan.pojo.common.MeituanStockResponse;
import com.lppz.stock.platform.meituan.pojo.request.MeituanStockRequest;
import com.lppz.stock.pojo.StockEntry;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 美团同步库存service
 */
@Service
@ChannelSelector(channel = Channel.MEITUAN, name = "美团库存同步")
public class MeituanStockService extends CallMethod<MeituanStockRequest, MeituanResponse> implements SynProvider {


    @Override
    public MeituanResponse run(Object obj) {
        List<StockEntry> stocks = (List<StockEntry>) obj;
        if (CollectionUtils.isEmpty(stocks)) {
            MeituanResponse rep = new MeituanStockResponse();
            rep.setError(new MeituanErrorCode("9999", "美团库存同步入参商品集合为空,不执行同步"));
            return rep;
        }
        RetailSkuStockRequest retailSkuPriceRequest = new RetailSkuStockRequest();
        List<FoodData> productParam = new ArrayList<FoodData>();
        for (SyncMeituanEntity entity : entitys) {
            FoodData foodSave = new FoodData();
            foodSave.setApp_food_code(entity.getThirdProCode());
            List<Skus> skus = new ArrayList<Skus>();
            Skus fsku = new Skus(entity.getThirdProCode(), entity.getStock());
            skus.add(fsku);
            foodSave.setSkus(skus);
            retailSkuPriceRequest.setApp_poi_code(entity.getStoreCode());
            productParam.add(foodSave);
        }

        retailSkuPriceRequest.setFood_data_list(productParam);
        //1.进入doCall方法
        PlatformResult<MeituanResponse> result = this.doCall(new MeituanStockRequest());
        return null;
    }

    @Override
    public CallPlatform<MeituanResponse> buildCallParams(MeituanStockRequest request) {
        return new CallSkuStock(request);
    }
}
