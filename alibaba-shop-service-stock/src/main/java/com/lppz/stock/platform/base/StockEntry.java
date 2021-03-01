package com.lppz.stock.platform.base;

import lombok.Data;


/**
 * 库存同步基类,主要包括
 * 1.商家店铺号-->storeCode
 *
 */
@Data
public class StockEntry {
    private String storeCode;

    private String thirdSku;

    private Integer stock;
}
