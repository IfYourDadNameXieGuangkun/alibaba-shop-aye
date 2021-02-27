package com.lppz.stock.pojo;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 履约服务承运商
 *
 * @author liqiwen
 * @version 1.0
 */
@Data
public class StockEntry implements Serializable {

    /**
     * 承运商 id
     */
    @NotNull(message = "Please provide a sku")
    private String sku;

    /**
     * 承运商全称
     */
    @NotBlank(message = "Please provide a stock")
    private Integer stock;


}
